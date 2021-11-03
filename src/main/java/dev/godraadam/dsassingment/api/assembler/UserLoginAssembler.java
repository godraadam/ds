package dev.godraadam.dsassingment.api.assembler;

import org.springframework.stereotype.Component;

import dev.godraadam.dsassingment.api.dto.UserLoginDTO;
import dev.godraadam.dsassingment.model.AccountDetails;
import dev.godraadam.dsassingment.model.AppUser;

@Component
public class UserLoginAssembler implements GeneralAssembler<AppUser, UserLoginDTO> {

    @Override
    public AppUser createModel(UserLoginDTO dto) {
        AccountDetails details = new AccountDetails();
        details.setEmail(dto.getEmail());
        details.setPassword(dto.getPassword());
        AppUser user = new AppUser();
        user.setAccountDetails(details);
        return user;
    }

    @Override
    public UserLoginDTO createDTO(AppUser model) {
        // We don't need backwards mapping
        return null;
    }

}
