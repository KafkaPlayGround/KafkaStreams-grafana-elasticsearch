package me.saechimdaeki.shipmentconsumer.service

import com.fasterxml.jackson.databind.ObjectMapper
import me.saechimdaeki.checkoutproducer.dto.CheckOutDto
import me.saechimdaeki.shipmentconsumer.domain.entity.ShipmentCheckOutEntity
import me.saechimdaeki.shipmentconsumer.domain.repository.ShipmentCheckOutRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class SaveService(
    private val shipmentCheckOutRepository: ShipmentCheckOutRepository,
    private val modelMapper: ModelMapper,
    private val customObjectMapper: ObjectMapper
) {

    fun saveCheckOutData(checkOutDto: CheckOutDto) : Long {
        val shipmentCheckOutEntity = modelMapper.map(checkOutDto, ShipmentCheckOutEntity::class.java)
        val savedEntity = shipmentCheckOutRepository.save(shipmentCheckOutEntity)
        return savedEntity.checkOutId
    }
}