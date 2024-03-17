package mongkey.maeilmail.service;

import mongkey.maeilmail.domain.User;
import mongkey.maeilmail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
//        System.out.println("UserService.getAllUsers");
//        List<User> users = userRepository.findAll();
//        for (User user : users) {
//            System.out.println("user = " + user);
//        }
        return userRepository.findAll();
//        return users;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

//    public User updateUser(Long id, User userDetails) {
//        Optional<User> userOptional = userRepository.findById(id);
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            user.setNickname(userDetails.getNickname());
//            user.setEmail(userDetails.getEmail());
//            return userRepository.save(user);
//        } else {
//            throw new RuntimeException("User not found with id: " + id);
//        }
//    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
