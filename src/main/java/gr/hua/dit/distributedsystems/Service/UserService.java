package gr.hua.dit.distributedsystems.Service;

import gr.hua.dit.distributedsystems.entity.Authorities;
import gr.hua.dit.distributedsystems.entity.User;
import gr.hua.dit.distributedsystems.repository.AuthorityRepository;
import gr.hua.dit.distributedsystems.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authRepository;


    public void registerUser(User user , String role) {

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Authorities auth = new Authorities(role, newUser);
        userRepository.save(newUser);
        authRepository.save(auth);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(),  user.get().getAuthorities());
        }else{
            throw new UsernameNotFoundException(String.format("Username[%s] not found", username));
        }

    }

    public List<User> listAll1(){

        return (List<User>) userRepository.findAll();

    }

    public List<Authorities> listRoles(){

        return (List<Authorities>) authRepository.findAll();

    }

}