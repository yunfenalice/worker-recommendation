package com.beady.elastic.service;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class FakerData {
    @Test
    void fakeData(){
        Faker faker=new Faker();
        String s = faker.name().fullName();
        System.out.println(s);

    }
    @Test
    void testWorker(){


    }
}
