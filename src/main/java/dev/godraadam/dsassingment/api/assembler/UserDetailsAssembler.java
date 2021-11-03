package dev.godraadam.dsassingment.api.assembler;

import org.springframework.stereotype.Component;

import dev.godraadam.dsassingment.api.dto.UserDetailsDTO;
import dev.godraadam.dsassingment.model.AppUser;

@Component
public class UserDetailsAssembler implements GeneralAssembler<AppUser, UserDetailsDTO> {

    @Override
    public AppUser createModel(UserDetailsDTO dto) {
        AppUser model = new AppUser();
        model.setId(dto.getId());
        model.setUserDetails(dto.getUserDetails());
        return model;
    }

    @Override
    public UserDetailsDTO createDTO(AppUser model) {
        UserDetailsDTO dto = new UserDetailsDTO();
        dto.setId(model.getId());
        dto.setUserDetails(model.getUserDetails());
        return dto;
    }

}
