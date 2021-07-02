package com.horrordb.service;

import com.horrordb.entity.User;
import com.horrordb.entity.dto.RegisterRequest;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public void signup(RegisterRequest registerReq){
        User user = new User();
    }
}
