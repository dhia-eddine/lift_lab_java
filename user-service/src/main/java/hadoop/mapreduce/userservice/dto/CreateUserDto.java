package hadoop.mapreduce.userservice.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CreateUserDto {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8, max = 50)
    private String password;
}