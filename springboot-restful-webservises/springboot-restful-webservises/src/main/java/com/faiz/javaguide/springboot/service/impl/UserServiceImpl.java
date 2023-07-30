package com.faiz.javaguide.springboot.service.impl;

import com.faiz.javaguide.springboot.DTO.UserDTO;
import com.faiz.javaguide.springboot.entity.User;
import com.faiz.javaguide.springboot.mapper.UserMapper;
import com.faiz.javaguide.springboot.repository.UsersRepository;
import com.faiz.javaguide.springboot.service.UsersServise;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UsersServise {
    public UsersRepository usersRepository;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        User user = UserMapper.mapUserDTOUser(userDto);
        User u = usersRepository.save(user);
        UserDTO userDTO = UserMapper.mapUserToUserDto(u);
        return userDTO;
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = usersRepository.findById(id);
        UserDTO uDto = UserMapper.mapUserToUserDto(user.get());
        return uDto;
    }

    @Override
    public List<UserDTO> getALlUsers() {
        List<User> users = usersRepository.findAll();
        List<UserDTO> uD = UserMapper.mapUserToUserDtoList(users);
        return uD;
    }

    @Override
    public UserDTO updateUser(UserDTO userDto) {
        User  user = UserMapper.mapUserDTOUser(userDto);
        User existingUser = usersRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = usersRepository.save(existingUser);
        UserDTO uDTO = UserMapper.mapUserToUserDto(updatedUser);
        return uDTO;
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

}
