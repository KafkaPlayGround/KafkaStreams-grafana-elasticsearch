package me.saechimdaeki.shipmentconsumer.domain.repository

import me.saechimdaeki.shipmentconsumer.domain.entity.ShipmentCheckOutEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ShipmentCheckOutRepository : JpaRepository<ShipmentCheckOutEntity, Long> {
}