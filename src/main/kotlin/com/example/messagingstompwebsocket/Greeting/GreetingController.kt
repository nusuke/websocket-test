package com.example.messagingstompwebsocket.Greeting

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class GreetingController {

    @Autowired
    lateinit var simpMessagingTemplate: SimpMessagingTemplate

    @MessageMapping("/hello") // クライアントは、setApplicationDestinationPrefixes / helloで指定。
    @SendTo("/topic/greetings") // 返り値をこちらのトピックに送信
    fun greeting(@Payload payload: String): String {
        println("clientからのpayload = $payload")
        Thread.sleep(1000)
        return "サーバからこんにちは"
    }

    @PutMapping("/test/hello")
    @ResponseBody
    fun hello(@RequestBody parameter: HelloParam): String {
        println("PUTで受け取った場合、subscribeしているクライアントに一斉送信")
        val message = "hello," + (parameter.name ?: "デフォルト名")
        simpMessagingTemplate.convertAndSend("/topic/greetings", message)
        return "OK"
    }

    data class HelloParam(val name: String? = null)
}