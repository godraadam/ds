package dev.godraadam.dsassingment.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.dsassingment.api.assembler.UserDetailsAssembler;
import dev.godraadam.dsassingment.api.assembler.UserLoginAssembler;
import dev.godraadam.dsassingment.api.assembler.UserRegisterAssembler;
import dev.godraadam.dsassingment.api.dto.UserDetailsDTO;
import dev.godraadam.dsassingment.api.dto.UserLoginDTO;
import dev.godraadam.dsassingment.api.dto.UserRegisterDTO;
import dev.godraadam.dsassingment.service.UserService;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsAssembler userDetailsAssembler;

    @Autowired
    private UserRegisterAssembler userRegisterAssembler;

    @Autowired
    private UserLoginAssembler userLoginAssembler;

    @GetMapping("admin/api/user/{id}")
    public UserDetailsDTO getUserById(@PathVariable Long id) {
        return userDetailsAssembler.createDTO(userService.findById(id));
    }

    @PostMapping("/register")
    public UserDetailsDTO registerUser(@RequestBody UserRegisterDTO dto) {
        return userDetailsAssembler.createDTO(userService.registerUser(userRegisterAssembler.createModel(dto)));
    }

    @PostMapping("/admin/register")
    public UserDetailsDTO registerAdmin(@RequestBody UserRegisterDTO dto) {
        return userDetailsAssembler.createDTO(userService.registerAdmin(userRegisterAssembler.createModel(dto)));
    }

    @PostMapping("/login")
    public UserDetailsDTO login(@RequestBody UserLoginDTO dto) {
        return userDetailsAssembler.createDTO(userService.login(userLoginAssembler.createModel(dto)));
    }

    @DeleteMapping("admin/api/user/rm/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/api/user")
    public UserDetailsDTO updateUser(@RequestBody UserDetailsDTO dto) {
        return userDetailsAssembler.createDTO(userService.updateUser(userDetailsAssembler.createModel(dto)));
    }

}
