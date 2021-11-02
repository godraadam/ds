package dev.godraadam.dsassingment.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDTO {
    
    private String email;
    private String password;
}
