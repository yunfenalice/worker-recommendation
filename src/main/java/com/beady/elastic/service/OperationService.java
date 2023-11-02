package com.beady.elastic.service;

import com.beady.elastic.model.User;
import com.beady.elastic.model.Worker;
import com.beady.elastic.repo.UserRepo;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OperationService {
    private final UserRepo userRepo;
    @Autowired
    public OperationService(UserRepo userRepo){
        this.userRepo=userRepo;

    }
    public void bulkInsert(List<User> userList){
        userRepo.saveAll(userList);
    }

}
