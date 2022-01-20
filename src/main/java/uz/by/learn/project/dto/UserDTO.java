package uz.by.learn.project.dto;

import lombok.Data;
import uz.by.learn.project.model.Role;
import uz.by.learn.project.model.User;

import java.util.List;
import java.util.Set;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String status;
    private Set<Role> roles;

    public UserDTO(){}

    public  UserDTO(User user){
        id = user.getId();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        username= user.getUsername();
        email = user.getEmail();
        roles = user.getRoles();
    }
}
