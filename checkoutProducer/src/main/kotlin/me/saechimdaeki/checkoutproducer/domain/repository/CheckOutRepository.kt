package me.saechimdaeki.checkoutproducer.domain.repository

import me.saechimdaeki.checkoutproducer.domain.entity.CheckOutEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CheckOutRepository : JpaRepository<CheckOutEntity, Long> {
}