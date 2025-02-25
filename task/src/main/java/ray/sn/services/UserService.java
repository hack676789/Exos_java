package ray.sn.services;

import ray.sn.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ray.sn.entites.Task;
import ray.sn.entites.Users;



@Service
public class UserService {

        private UsersRepository usersRepository;
        private final BCryptPasswordEncoder passwordEncoder;

        public UserService(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder){
            this.usersRepository = usersRepository;
            this.passwordEncoder = passwordEncoder;
        }

        public Users registUsers(String email, String password){
            String hashedPassword = passwordEncoder.encode(password);
            Users user = new Users();
            user.setEmail(email);
            user.setPassword(hashedPassword);
            
            return usersRepository.save(user);
        }

        public Users addUsers(Users users){
            return  this.usersRepository.save(users);
        }

        public Optional<Users> getUserById(int id){
            return usersRepository.findById(id);
        }
        public List<Users> getAllUsers(){
            return usersRepository.findAll();
        }
        public Optional<Users> getUserByEmail(String email){
            return usersRepository.findByEmail(email);
        }
}
