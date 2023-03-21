package me.saechimdaeki.shipmentconsumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import me.saechimdaeki.checkoutproducer.dto.CheckOutDto
import me.saechimdaeki.shipmentconsumer.service.SaveService
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaConsumer(
    private val customObjectMapper : ObjectMapper,
    private val saveService: SaveService
) {
    private val log = LoggerFactory.getLogger(this::class.java)


    companion object {
        const val TOPIC_NAME = "checkout.complete.v1"
        const val GROUP_ID = "shipment.group.v1"
    }

    @KafkaListener(topics = [TOPIC_NAME], groupId = GROUP_ID)
    fun recordListener(jsonMessage: String) {
        val checkOutDto = customObjectMapper.readValue<CheckOutDto>(jsonMessage)
        log.info("checkOutDto : {}",checkOutDto)
        saveService.saveCheckOutData(checkOutDto)
    }


}