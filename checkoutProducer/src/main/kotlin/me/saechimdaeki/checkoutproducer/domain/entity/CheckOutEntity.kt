package me.saechimdaeki.checkoutproducer.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate

@Entity
@Table(name = "CHECKOUT_TABLE")
class CheckOutEntity(

    @Id
    @GeneratedValue
    val checkOutId: Long? = null,

    @Column(name = "memberId")
    val memberId: Long? = null,

    @Column(name = "productId")
    val productId: Long? = null,

    @Column(name = "shippingAddress")
    val shippingAddress : String? = null,

    @CreationTimestamp
    @Column(name = "createdAt")
    val createdAt : LocalDate
) {

}