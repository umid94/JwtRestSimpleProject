package uz.by.learn.project.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthenticationResponseDTO {
    private String username;
    private String token;
    private List<String> roles;

    public AuthenticationResponseDTO(String username, String token, List<String> roleNames) {
        this.username = username;
        this.token = token;
        this.roles = roleNames;
    }
}
