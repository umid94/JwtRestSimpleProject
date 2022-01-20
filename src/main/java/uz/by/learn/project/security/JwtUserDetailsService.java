package uz.by.learn.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import uz.by.learn.project.model.User;
import uz.by.learn.project.repository.UserRepository;
import uz.by.learn.project.security.jwt.JwtFactoryUser;
import uz.by.learn.project.security.jwt.JwtUser;
import uz.by.learn.project.service.UserService;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        JwtUser jwtUser = JwtFactoryUser.createJwtUser(user);
        return jwtUser;
    }
}
