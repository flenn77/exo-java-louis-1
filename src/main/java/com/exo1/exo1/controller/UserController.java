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
    private final UserMapper userMapper; // Pas de majuscule ici, c'est une convention

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper; // Utiliser la bonne variable
    }

    @GetMapping
    public List<UserDTO> getAllUtilisateurs() {
        return userService.findAll()
                .stream()
                .map(userMapper::userToUserDTO) // Correction ici
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUtilisateurById(@PathVariable Long id) {
        return userService.findById(id)
                .map(userMapper::userToUserDTO) // Correction ici
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUtilisateur(@RequestBody UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO); // Correction ici
        User createdUser = userService.save(user);
        UserDTO createdUserDTO = userMapper.userToUserDTO(createdUser); // Correction ici
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUtilisateur(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        if (!userService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User user = userMapper.userDTOToUser(userDTO);
        user.setId(id);
        User updatedUser = userService.save(user);
        UserDTO updatedUserDTO = userMapper.userToUserDTO(updatedUser);
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
