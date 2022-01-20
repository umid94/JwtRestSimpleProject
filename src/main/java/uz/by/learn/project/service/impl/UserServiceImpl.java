package uz.by.learn.project.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.by.learn.project.dto.UserDTO;
import uz.by.learn.project.model.Role;
import uz.by.learn.project.model.Status;
import uz.by.learn.project.model.User;
import uz.by.learn.project.repository.RoleRepository;
import uz.by.learn.project.repository.UserRepository;
import uz.by.learn.project.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
        User user = new User();
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public List<User> getAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User user1 = user.get();
            user1.setStatus(Status.DELETE);
            userRepository.save(user1);
        }
    }
}
