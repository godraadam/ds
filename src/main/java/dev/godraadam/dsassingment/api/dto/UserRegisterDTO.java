package dev.godraadam.dsassingment.api.dto;

import dev.godraadam.dsassingment.model.AccountDetails;
import dev.godraadam.dsassingment.model.UserDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {

    private AccountDetails accountDetails;
    private UserDetails userDetails;
}
