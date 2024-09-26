package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
   private final UserRepository userRepository;

   @Autowired
   public UserServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   public List<User> getAllUsers() {
      return userRepository.findAll();
   }

   @Override
   public User updateUserById (int id,User userProperty) {
         User user = userRepository.findById(id).orElseThrow();
         user.setName(userProperty.getName());
         user.setLastName(userProperty.getLastName());
         user.setWeight(userProperty.getWeight());
         user.setHeight(userProperty.getHeight());
         return userRepository.save(user);
   }

   @Override
   public void removeUserById (int id) {
      userRepository.deleteById(id);
   }

   @Override
   public User saveUser (User user) {
      return userRepository.save(user);
   }
}
