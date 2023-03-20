package me.saechimdaeki.checkoutproducer.controller

import me.saechimdaeki.checkoutproducer.dto.CheckOutDto
import me.saechimdaeki.checkoutproducer.service.SaveService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping

@Controller
class CheckOutSubmitController(
    private val saveService: SaveService
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    @PostMapping("/submitCheckOut")
    fun subMitCheckOut(checkOutDto: CheckOutDto, model: Model) : String {

        log.info("checkOutDto : {}",checkOutDto)
        val cechOutId:Long = saveService.saveCheckOutData(checkOutDto)
        model.addAttribute("checkOutId", cechOutId)
        return "submitComplete"
    }
}