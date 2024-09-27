package com.Api.registration.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

//@Data
@Getter
@Setter

public class RegistrationDto {
    @Size(min=2, message = "min should be 2 letter in name")
    private String name;
    @Email
    private String email;
    @Size(min = 10,max = 10, message = "Should be 10 digit in mobile number")
    private String mobile;

}