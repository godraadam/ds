package dev.godraadam.dsassingment.model;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@RequiredArgsConstructor
public class UserDetails {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
}
