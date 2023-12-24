package com.emrecan.appointmentsystem.business.requests.user;

import com.emrecan.appointmentsystem.entities.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Emrecan
 * @created 24/12/2023 - 14:19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private UserRole userRole;


}
