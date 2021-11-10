package dev.godraadam.dsassingment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.godraadam.dsassingment.service.AppUserDetailsService;

@Configuration
public class AppConfig {
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
	UserDetailsService userDetailsService() {
		return new AppUserDetailsService();
	}
}
