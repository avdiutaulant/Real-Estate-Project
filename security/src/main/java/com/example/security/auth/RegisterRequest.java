package com.example.security.auth;

import com.example.security.user.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    //region FirstNameValidation
    @Schema(description = "The first name of the user. It must have at least 2 characters and cannot consist of spaces only.", example = "John")
    @NotNull(message = "First name is required")
    @Size(min = 2, message = "First name must have at least 2 characters")
    @NotBlank( message = "First name cannot consist of spaces only")
    //endregion
    private String firstname;

    //region LastNameValidation
    @Schema(description = "The last name of the user. It must have at least 2 characters and cannot consist of spaces only.", example = "Doe")
    @NotNull(message = "Last name is required")
    @Size(min = 2, message = "Last name must have at least 2 characters")
    @NotBlank( message = "Last name cannot consist of spaces only")
    //endregion
    private String lastname;

    //region EmailValidation
    @Schema(description = "The email of the user. It must be a valid email address and cannot consist of spaces only.", example = "john.doe@example.com")
    @NotNull(message = "Email is required")
    @Size(min = 1, message = "Email is required")
    @NotBlank(message = "The field cannot consist of spaces only")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please provide a valid email address")
    //endregion
    private String email;

    //region PasswordValidation
    @Schema(description = "The password of the user. It must be at least 6 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character, and cannot consist of spaces only.", example = "Password123!")
    @NotNull(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @NotBlank(message = "The field cannot consist of spaces only")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{6,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    //endregion
    private String password;

}
