package fsega.security.service;

import fsega.security.model.User;
import fsega.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(fsega.security.model.UserDetails::new).get();
    }

    public void register(User user){
        PasswordEncoder passwordEncoder = (PasswordEncoder) applicationContext.getBean("PasswordEncoder");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
