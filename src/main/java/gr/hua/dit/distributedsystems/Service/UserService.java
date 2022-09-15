package gr.hua.dit.distributedsystems.Service;

import gr.hua.dit.distributedsystems.Exception.UserNotFoundException;
import gr.hua.dit.distributedsystems.entity.Authorities;
import gr.hua.dit.distributedsystems.entity.User;
import gr.hua.dit.distributedsystems.repository.AuthorityRepository;
import gr.hua.dit.distributedsystems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authRepository;

    public void registerUser(User user , String role) {

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Authorities auth = new Authorities(role, newUser);
        newUser.setEnabled(true);
        userRepository.save(newUser);
        authRepository.save(auth);
    }

    public List<User> listAll1(){

        return (List<User>) userRepository.findAll();

    }

    public List<Authorities> listRoles(){

        return (List<Authorities>) authRepository.findAll();

    }

    public User get(String id) throws UserNotFoundException {

        Optional<User> result =  userRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("could not"+id);

    }

    public Authorities get2(User user) throws UserNotFoundException {

        Optional<Authorities> result =  authRepository.findById(user);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("could not");
    }

    public void save(User user , String lang) throws UserNotFoundException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);

        Authorities auth = new Authorities(lang, user);

        authRepository.save(auth);
        userRepository.save(user);
    }

    public void delete (String user) throws UserNotFoundException {
        Optional<User> count = userRepository.findByUsername(user);
        if(count == null ){
            throw new UserNotFoundException("Could not FIND any users with ID"+user);
        }
        userRepository.deleteById(user);
    }
}