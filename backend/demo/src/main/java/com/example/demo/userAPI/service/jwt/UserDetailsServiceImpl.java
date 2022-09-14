package com.example.demo.userAPI.service.jwt;
import com.example.demo.userAPI.persistance.entities.jwt.MainUserAuth;
import com.example.demo.userAPI.dto.jwt.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userService.findByEmail(username);
        return MainUserAuth.build(user);


    }
}
