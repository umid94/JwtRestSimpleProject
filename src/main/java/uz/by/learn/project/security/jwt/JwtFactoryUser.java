package uz.by.learn.project.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import uz.by.learn.project.model.Role;
import uz.by.learn.project.model.Status;
import uz.by.learn.project.model.User;
import uz.by.learn.project.security.jwt.JwtUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class JwtFactoryUser {

    public JwtFactoryUser(){}

    public static JwtUser createJwtUser(User user){
     return new JwtUser(
             user.getId(),
             user.getFirstName(),
             user.getLastName(),
             user.getUsername(),
             user.getPassword(),
             user.getEmail(),
             user.getStatus().equals(Status.ACTIVE),
             mapToGrantedAuthorities(user.getRoles()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> userRoles) {
         List<GrantedAuthority> collect = new ArrayList<>();
         collect = userRoles.stream().map(s-> new SimpleGrantedAuthority(s.getName())).collect(Collectors.toList());
         return collect;
    }
}
