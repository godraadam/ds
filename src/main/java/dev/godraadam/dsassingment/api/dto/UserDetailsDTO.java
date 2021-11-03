package dev.godraadam.dsassingment.api.dto;

import dev.godraadam.dsassingment.model.UserDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDTO {

    private Long id;
    private UserDetails userDetails;
}
