package com.keyrus.kit.quiz.service;

import com.keyrus.kit.quiz.dto.UserDTO;
import com.keyrus.kit.quiz.form.UserForm;
import com.keyrus.kit.quiz.model.User;
import com.keyrus.kit.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CrudUserService {
    @Autowired
    private UserRepository userRepository;

    private List<UserDTO> list(){
        List<User> users = userRepository.findAll();
        return UserDTO.toUserDtoList(users);
    }

    @Transactional
    private void save(UserForm userForm){
        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .phone(userForm.getPhone())
                .build();
        userRepository.save(user);
    }

    @Transactional
    public boolean update(Long id, UserForm userForm){
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            User user = optional.get();
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setPhone(userForm.getPhone());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
