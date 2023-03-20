package me.saechimdaeki.checkoutproducer.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class CheckOutSubmitControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun testPostSubmitCheckOut() {
        mockMvc.perform(
            post("/submitCheckOut")
                .param("memberId", "100001")
                .param("productId", "200001")
                .param("amount", "33000")
                .param("shippingAddress", "566")
        ).andExpect(status().isOk)
            .andDo(print())
    }
}