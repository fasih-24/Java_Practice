package com.faiz.javaguide.springboot.service;

import com.faiz.javaguide.springboot.DTO.UserDTO;
import com.faiz.javaguide.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsersServise {
    UserDTO createUser(UserDTO userDto);
    UserDTO getUserById(Long id);
    List<UserDTO> getALlUsers();
    UserDTO updateUser(UserDTO user);
    void deleteUser(Long id);
}
