package me.saechimdaeki.checkoutproducer.service

import com.fasterxml.jackson.databind.ObjectMapper
import me.saechimdaeki.checkoutproducer.domain.entity.CheckOutEntity
import me.saechimdaeki.checkoutproducer.domain.repository.CheckOutRepository
import me.saechimdaeki.checkoutproducer.dto.CheckOutDto
import org.modelmapper.ModelMapper
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class SaveService(
    private val modelMapper: ModelMapper,
    private val customObjectMapper: ObjectMapper,
    private val checkOutRepository: CheckOutRepository,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    private val CHECKOUT_COMPLETE_TOPIC_NAME = "checkout.complete.v1"

    private val log = LoggerFactory.getLogger(this::class.java)

    fun saveCheckOutData(checkOutDto: CheckOutDto): Long {
        val checkOutEntity = saveDatabase(checkOutDto)
        checkOutDto.checkOutId = checkOutEntity.checkOutId
        checkOutDto.createdAt = checkOutEntity.createdAt
        sendToKafka(checkOutDto)

        return checkOutEntity.checkOutId ?: throw IllegalStateException("id가 null입니다. 로그를 확인 해주세요")
    }

    private fun saveDatabase(checkOutDto: CheckOutDto): CheckOutEntity {

        val checkOutEntity = modelMapper.map(checkOutDto, CheckOutEntity::class.java)

        return checkOutRepository.save(checkOutEntity)
    }

    private fun sendToKafka(checkOutDto: CheckOutDto) {
        val jsonString = customObjectMapper.writeValueAsString(checkOutDto)
        kafkaTemplate.send(CHECKOUT_COMPLETE_TOPIC_NAME, jsonString)
    }
}