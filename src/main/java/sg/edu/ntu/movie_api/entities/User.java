/*
 * User.java
 * 
 * Status: bare minimum done, to be improved later
 * 
 * TODO: implement tests
 * TODO: check what other annotations can be used for each field
 * TODO: store encrypted password instead of plain text
 * TODO: check that email must be unique (i.e. no two users can have the same email)
 * 
 */

package sg.edu.ntu.movie_api.entities;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
public class User {

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    //@Column(name = "email") // TODO: check if this is optional
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;
    
    private String name;
}
