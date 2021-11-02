package dev.godraadam.dsassingment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.godraadam.dsassingment.exception.InvalidCredentialsException;
import dev.godraadam.dsassingment.exception.UserAlreadyExistsException;
import dev.godraadam.dsassingment.exception.UserNotFoundException;
import dev.godraadam.dsassingment.model.AppUser;
import dev.godraadam.dsassingment.model.UserRole;
import dev.godraadam.dsassingment.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AppUser login(AppUser userToLogin) throws UserNotFoundException, InvalidCredentialsException {
        // check email
        Optional<AppUser> userFromRepoOptional = userRepo.findByAccountDetails_Email(userToLogin.getAccountDetails().getEmail());
        AppUser userFromRepo = userFromRepoOptional.orElseThrow(UserNotFoundException::new);

        // check password
        if (!passwordEncoder.matches(userToLogin.getAccountDetails().getPassword(), userFromRepo.getAccountDetails().getPassword())) {
            throw new InvalidCredentialsException();
        }
        return userFromRepo;
    }

    public AppUser registerUser(AppUser userToRegister) throws UserAlreadyExistsException {
        return registerGenericUser(userToRegister, UserRole.USER);
    }

    public AppUser registerAdmin(AppUser userToRegister) throws UserAlreadyExistsException {
        return registerGenericUser(userToRegister, UserRole.ADMIN);
    }

    private AppUser registerGenericUser(AppUser userToRegister, UserRole role) throws UserAlreadyExistsException {

        // check if email is available
        Optional<AppUser> userFromRepo = userRepo
                .findByAccountDetails_Email(userToRegister.getAccountDetails().getEmail());
        if (userFromRepo.isPresent()) {
            throw new UserAlreadyExistsException();
        }
        // encrypt password
        userToRegister.getAccountDetails()
                .setPassword(passwordEncoder.encode(userToRegister.getAccountDetails().getPassword()));
        // other validation: client side
        userToRegister.getAccountDetails().setRole(role);
        return userRepo.save(userToRegister);
    }

    public AppUser findById(Long id) {
        Optional<AppUser> userFromRepo = userRepo.findById(id);
        return userFromRepo.orElseThrow(UserNotFoundException::new);
    }

    public AppUser findByEmail(String email) {
        Optional<AppUser> userFromRepo = userRepo.findByAccountDetails_Email(email);
        return userFromRepo.orElseThrow(UserNotFoundException::new);
    }

    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

    public AppUser updateUser(AppUser updatedUser) {
        return userRepo.save(updatedUser);
    }
}
