package com.faiz.javaguide.springboot.mapper;

import com.faiz.javaguide.springboot.DTO.UserDTO;
import com.faiz.javaguide.springboot.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserMapper {
    //Map Entity class user to UserDTO
    public static UserDTO mapUserToUserDto(User user){
        UserDTO uDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return uDTO;
    }
    //Map UserDTO class to JPA Entity class User
    public static User mapUserDTOUser(UserDTO userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
    public static List<UserDTO> mapUserToUserDtoList(List<User> user){
        List<UserDTO> userList = new ArrayList<>();
        for (User u:user) {
            UserDTO oD = mapUserToUserDto(u);
            userList.add(oD);
        }

        return userList;
    }
}
