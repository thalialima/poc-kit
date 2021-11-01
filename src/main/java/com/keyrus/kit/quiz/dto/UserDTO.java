package com.keyrus.kit.quiz.dto;

import com.keyrus.kit.quiz.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }

    public static List<UserDTO> toUserDtoList(List<User> users){
        List<UserDTO> userDTOList = new ArrayList<>();
        users.forEach(u -> userDTOList.add(new UserDTO(u)));
        return userDTOList;
    }

}
