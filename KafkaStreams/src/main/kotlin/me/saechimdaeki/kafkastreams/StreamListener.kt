package me.saechimdaeki.kafkastreams

import me.saechimdaeki.kafkastreams.util.JsonUtils
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.KeyValue
import org.apache.kafka.streams.StreamsBuilder
import org.apache.kafka.streams.kstream.Grouped
import org.apache.kafka.streams.kstream.KStream
import org.apache.kafka.streams.kstream.Produced
import org.apache.kafka.streams.kstream.TimeWindows
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.time.Duration


@Component
class StreamListener {

    @Bean
    fun kStream(builder: StreamsBuilder): KStream<String, String> {
        val inputTopic = "checkout.complete.v1"
        val outputTopic = "checkout.productId.aggregated.v1"

        val inputStream = builder.stream<String, String>(inputTopic)
        inputStream
            .map { _, v -> KeyValue(JsonUtils.getProductId(v), JsonUtils.getAmount(v)) }
            // Group by productId
            .groupByKey(Grouped.with(Serdes.Long(), Serdes.Long()))
            // Window settings
            .windowedBy(TimeWindows.ofSizeWithNoGrace(Duration.ofMinutes(1)))
            // Apply sum method
            .reduce { aggValue, newValue -> aggValue + newValue }
            // map the window key
            .toStream { key, _ -> key.key() }
            // Generate as Json String to be sent to outputTopic
            .mapValues(JsonUtils::getSendingJson)
            // Set the key value to be sent to outputTopic as null
            .selectKey { _, _ -> null }
            // Set message (null, jsonString) transmission as outputTopic
            .to(outputTopic, Produced.with(null, Serdes.String()))

        return inputStream
    }

}