package uz.by.learn.project.service;

import uz.by.learn.project.dto.UserDTO;
import uz.by.learn.project.model.User;

import java.util.List;

public interface UserService {

    UserDTO register(UserDTO user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
