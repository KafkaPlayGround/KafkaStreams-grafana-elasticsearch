package me.saechimdaeki.checkoutproducer.controller

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CheckoutFormController {

    private val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/checkOutForm")
    fun checkOutForm(model: Model) = run {
        log.info("checkOutForm ...")
        "checkOutForm"
    }
}