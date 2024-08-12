package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean deleteUser(Integer id) {
        User user = userRepository.getById(id);
        if (user == null){
            return false;
        }
        userRepository.delete(user);
        return true;
    }

    public boolean updateUser(Integer id, User user) {
        User u = userRepository.getById(id);
        if (u == null){
            return false;
        }

        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAge(user.getAge());
        u.setRole(user.getRole());

        userRepository.save(u);
        return true;
    }
}
