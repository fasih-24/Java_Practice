package com.faiz.javaguide.springboot.controller;

import com.faiz.javaguide.springboot.DTO.UserDTO;
import com.faiz.javaguide.springboot.entity.User;
import com.faiz.javaguide.springboot.service.UsersServise;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UsersServise usersServise;

// Build Create Rest API
    @PostMapping("createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){

        UserDTO savedUser = usersServise.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("getAllUsers")
    public ResponseEntity<UserDTO> getAllUser(){
        return new ResponseEntity(usersServise.getALlUsers(), HttpStatus.OK);
    }
    // @RequestParam will be used when value come as part of uri as query param like: http://127.0.0.1:8080/api/users/user/id/?id=3
    @GetMapping("id")
    public ResponseEntity<UserDTO> getUser(@RequestParam(value = "id") Long userId){
        UserDTO user = usersServise.getUserById(userId);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }
    // @PAthVariable will be used when value is part of URL itself like; http://127.0.0.1:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUser2(@PathVariable(value = "id") Long userId){
        UserDTO user = usersServise.getUserById(userId);
        return  new ResponseEntity<>(user, HttpStatus.OK);
    }
    //Create Update API to update user
    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(value = "id") Long userId, @RequestBody UserDTO userDto){
        userDto.setId(userId);
        UserDTO updatedUSer = usersServise.updateUser(userDto);
        return new ResponseEntity<>(updatedUSer, HttpStatus.OK);
    }
    // Build Delete User API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        usersServise.deleteUser(userId);
        return new ResponseEntity("User Deleted Successfully", HttpStatus.OK);
    }
}
