package com.exo1.exo1.controller;

import com.exo1.exo1.dto.UserDTO;
import com.exo1.exo1.entity.User;
import com.exo1.exo1.mapper.UserMapper;
import com.exo1.exo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/utilisateurs")
public class UserController {

    private final UserService userService;
    private final UserMapper UserMapper;

    @Autowired
    public UserController(UserService userService, UserMapper UserMapper) {
        this.userService = userService;
        this.UserMapper = UserMapper;
    }

    @GetMapping
    public List<UserDTO> getAllUtilisateurs() {
        return userService.findAll()
                .stream()
                .map(UserMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUtilisateurById(@PathVariable Long id) {
        return userService.findById(id)
                .map(UserMapper::userToUserDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUtilisateur(@RequestBody UserDTO UserDTO) {
        User user = UserMapper.UserDTOToUser(UserDTO);
        User createdUser = userService.save(user);
        UserDTO createdUserDTO = UserMapper.userToUserDTO(createdUser);
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUtilisateur(@PathVariable Long id, @RequestBody UserDTO UserDTO) {
        if (!userService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User user = UserMapper.UserDTOToUser(UserDTO);
        user.setId(id);
        User updatedUser = userService.save(user);
        UserDTO updatedUserDTO = UserMapper.userToUserDTO(updatedUser);
        return ResponseEntity.ok(updatedUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        if (!userService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
