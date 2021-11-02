package dev.godraadam.dsassingment.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class AccountDetails {
    private String email;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserRole role;
}
