package com.stackoverflow.question56004821;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findByFirstName(String firstName){
        return new User();
    }
}
