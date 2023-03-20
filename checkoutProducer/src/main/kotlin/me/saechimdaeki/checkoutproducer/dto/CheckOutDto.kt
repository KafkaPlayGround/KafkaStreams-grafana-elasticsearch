package me.saechimdaeki.checkoutproducer.dto

import java.time.LocalDate

data class CheckOutDto(
    var checkOutId: Long?,
    val memberId: Long,
    val productId: Long,
    val amount : Long,
    val shippingAddress : String,
    var createdAt : LocalDate?
) {
}