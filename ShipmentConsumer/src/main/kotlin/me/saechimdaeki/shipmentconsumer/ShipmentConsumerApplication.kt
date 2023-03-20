package me.saechimdaeki.shipmentconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShipmentConsumerApplication

fun main(args: Array<String>) {
    runApplication<ShipmentConsumerApplication>(*args)
}
