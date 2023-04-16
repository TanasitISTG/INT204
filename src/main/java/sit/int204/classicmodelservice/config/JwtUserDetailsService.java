package sit.int204.classicmodelservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelservice.entities.Customer;
import sit.int204.classicmodelservice.repositories.CustomerRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("tana".equals(username)) {
//            return new User("tana", "$2a$12$Rd/f9qJsbiXF1FRZmBYcvuQ9NyKeHJz5e2H9OZHK/4O9/OlwxHDHC", new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }

        Customer customer = customerRepository.findByUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(customer.getUsername(), customer.getPassword(), new ArrayList<>());
    }
}
