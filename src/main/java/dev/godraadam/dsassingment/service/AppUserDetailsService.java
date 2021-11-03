package dev.godraadam.dsassingment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import dev.godraadam.dsassingment.exception.UserNotFoundException;
import dev.godraadam.dsassingment.model.AppUser;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UserNotFoundException {
        try {
            AppUser user = userService.findByEmail(email);
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getAccountDetails().getEmail()).password(user.getAccountDetails().getPassword())
                    .roles(user.getAccountDetails().getRole().name()).build();
        } catch (UserNotFoundException e) {
            throw e;
        }
    }
}
