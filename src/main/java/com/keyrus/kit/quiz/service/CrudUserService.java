package com.keyrus.kit.quiz.service;

import com.keyrus.kit.quiz.dto.UserDTO;
import com.keyrus.kit.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudUserService {
    @Autowired
    private UserRepository userRepository;

    private void save(UserDTO){
        

    }
}
