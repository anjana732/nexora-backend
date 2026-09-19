package com.nexora.backend.user;

import com.nexora.backend.user.dto.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("user not found"));
    }

    public boolean emailExists(String email){
        return userRepository.existsByEmail(email);
    }

    public User createUser(CreateUserRequest request){
        if(userRepository.existsByEmail(request.email())){
            throw new RuntimeException("Email already exist");
        }
        User user = new User(
                request.name(),
                request.email(),
                request.timezone()
        );

        return userRepository.save(user);
    }
}
