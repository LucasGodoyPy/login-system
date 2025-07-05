package com.lucas_login.Login.service;

import com.lucas_login.Login.entity.SecurityUser;
import com.lucas_login.Login.entity.User;
import com.lucas_login.Login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserDetailServicelmpl implements UserDetailsService {


    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not Found");
        }
        return new SecurityUser(user);
    }
}
