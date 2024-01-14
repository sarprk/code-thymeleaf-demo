package com.demo.restapi.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "User DTO model information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @Schema(
            description = "User first name"
    )
    //User validations
    @NotEmpty(message = "First name should not be empty")
    private String firstName;

    @Schema(
            description = "User last name"
    )
    @NotEmpty(message = "Last name should not be empty")
    private String lastName;

    @Schema(
            description = "User email address"
    )
    @NotEmpty
    @Email
    private String email;
}
