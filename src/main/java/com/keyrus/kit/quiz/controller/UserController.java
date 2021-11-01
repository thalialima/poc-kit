package com.keyrus.kit.quiz.controller;

import com.keyrus.kit.quiz.dto.UserDTO;
import com.keyrus.kit.quiz.form.UserForm;
import com.keyrus.kit.quiz.service.CrudUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private CrudUserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> list(){
        return ResponseEntity.ok(this.userService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> details(@PathVariable Long id){
        UserDTO userDTO = this.userService.listById(id);
        if(userDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserForm userForm, UriComponentsBuilder builder){
        UserDTO userDTO = this.userService.save(userForm);
        URI uri = builder.path("users/{id}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserForm userForm){
        UserDTO userDTO = this.userService.update(id, userForm);
        if (userDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        boolean exists = this.userService.delete(id);
        if(!exists){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
