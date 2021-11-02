package dev.godraadam.dsassingment.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AppUser extends BaseModel {
    
    @Embedded
    private AccountDetails accountDetails;
    @Embedded
    private UserDetails userDetails;
    @OneToMany(mappedBy = "owner")
    private List<Device> devices;
}
