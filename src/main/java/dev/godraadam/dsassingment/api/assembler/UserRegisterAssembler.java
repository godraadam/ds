package dev.godraadam.dsassingment.api.assembler;

import org.springframework.stereotype.Component;

import dev.godraadam.dsassingment.api.dto.UserRegisterDTO;
import dev.godraadam.dsassingment.model.AppUser;

@Component
public class UserRegisterAssembler implements GeneralAssembler<AppUser, UserRegisterDTO> {

    @Override
    public AppUser createModel(UserRegisterDTO dto) {
        AppUser user = new AppUser();
        user.setUserDetails(dto.getUserDetails());
        user.setAccountDetails(dto.getAccountDetails());
        return user;
    }

    @Override
    public UserRegisterDTO createDTO(AppUser model) {
        // Will probably never need backwards mapping
        return null;
    }

}
