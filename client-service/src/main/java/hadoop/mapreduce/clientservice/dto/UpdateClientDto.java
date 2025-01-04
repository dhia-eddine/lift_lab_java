package hadoop.mapreduce.clientservice.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UpdateClientDto {
    @NotEmpty
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9]{8}$", message = "Mobile number must be 8 digits long")
    private String mobile;

    private String address;
}