package me.saechimdaeki.kafkastreams.util

import com.jayway.jsonpath.JsonPath

class JsonUtils {

    companion object {
        fun getProductId(jsonString: String) : Long {
            return JsonPath.parse(jsonString).read("$.productId", Long::class.java)
        }

        fun getAmount(jsonString: String) : Long {
            return JsonPath.parse(jsonString).read("$.amount", Long::class.java)
        }

        fun getSendingJson(productId: Long, amount : Long) : String {
            return "{\"productId\":$productId,\"windowedAmount\":$amount,\"createdAt\":${System.currentTimeMillis()}}"
        }
    }
}