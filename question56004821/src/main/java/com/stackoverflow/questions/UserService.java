package com.stackoverflow.questions;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findByFirstName(String firstName){
        return new User();
    }
}
