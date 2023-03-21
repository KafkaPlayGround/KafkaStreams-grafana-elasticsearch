package me.saechimdaeki.shipmentconsumer.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate

@Entity
@Table(name = "SHIPMENT_CHECKOUT_TABLE")
class ShipmentCheckOutEntity(

    @Id
    @GeneratedValue
    val shipmentId: Long? = null,

    @Column(name = "checkOutId")
    val checkOutId: Long,

    @Column(name = "memberId")
    val memberId: Long,

    @Column(name = "productId")
    val productId: Long,

    @Column(name = "amount")
    val amount: Long,

    @Column(name = "shippingAddress")
    val shippingAddress: String,

    @CreationTimestamp
    @Column(name = "createdAt")
    val createdAt: LocalDate,
) {
}