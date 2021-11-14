package com.mrtclk.listener;

import com.mrtclk.model.Person;

public class PersonListener {

    public void handleMessage(Person person){
        System.out.println(person.toString());
    }
}
