package com.rabbitMQ.producer.controllers;

import com.rabbitMQ.producer.models.User;
import com.rabbitMQ.producer.services.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerController {

    private final RabbitMQSender rabbitMqSender;

    @Autowired
    public ProducerController(RabbitMQSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @PostMapping( value = "user" )
    public String publishUserDetails(@RequestBody User user) {

        rabbitMqSender.send(user);
        return "Message has been sent Successfully";

    }

}
