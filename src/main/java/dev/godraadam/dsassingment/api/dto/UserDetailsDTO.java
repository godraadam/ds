package dev.godraadam.dsassingment.api.dto;

import dev.godraadam.dsassingment.model.UserDetails;
import dev.godraadam.dsassingment.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDTO {

    private Long id;
    private UserRole role;
    private UserDetails userDetails;
}
