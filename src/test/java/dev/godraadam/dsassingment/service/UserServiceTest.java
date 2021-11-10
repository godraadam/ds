package dev.godraadam.dsassingment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.godraadam.dsassingment.exception.UserNotFoundException;
import dev.godraadam.dsassingment.model.AccountDetails;
import dev.godraadam.dsassingment.model.AppUser;
import dev.godraadam.dsassingment.model.UserDetails;
import dev.godraadam.dsassingment.repo.UserRepo;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceConfig {

        @Bean
        public UserService userService() {
            return new UserService();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    @BeforeEach
    public void setUp() {
        AppUser alice = new AppUser();
        AccountDetails aliceAccountDetails = new AccountDetails();
        aliceAccountDetails.setEmail("alice@acme.com");
        aliceAccountDetails.setPassword("iLikeBob");
        UserDetails aliceUserDetails = new UserDetails();
        aliceUserDetails.setFirstName("Alice");
        aliceUserDetails.setLastName("Alison");
        alice.setUserDetails(aliceUserDetails);
        alice.setAccountDetails(aliceAccountDetails);

        Mockito.when(userRepo.findByAccountDetails_Email(alice.getAccountDetails().getEmail()))
                .thenReturn(Optional.of(alice));
    }

    @Test
    public void whenEmailIsFoundReturnUser() {
        String email = "alice@acme.com";
        AppUser user = userService.findByEmail(email);

        assertEquals("Alice Alison", user.getUserDetails().getFirstName() + " " + user.getUserDetails().getLastName());
    }

    @Test
    public void whenEmailIsNotFoundThrowNotFoundException() {
        String email = "bob@acme.com";
        assertThrows(UserNotFoundException.class, () -> userService.findByEmail(email));
    }
}
