package com.scm.contacthub.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "Name is required")
    @Size(message = "minimum 3 characters required", min = 3, max = 100)
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(message = "Password must be more than 6 characters", min = 6, max = 100)
    private String password;
    @NotBlank(message = "About is required")
    private String about;
    @Size(min = 10, max = 12, message = "Invalid number")
    private String phoneNumber;
     
}
