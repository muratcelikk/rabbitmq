package com.mrtclk.controller;

import com.mrtclk.model.Person;
import com.mrtclk.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @RequestMapping(value = "/producer")
    public String producer(@RequestParam("personName") String personName, @RequestParam("personId") String personId) {

        Person person = new Person();
        person.setPersonId(personId);
        person.setPersonName(personName);
            rabbitMQSender.send(person);
        return "Message sent to the RabbitMQ, java in use successfully.";
    }
}
