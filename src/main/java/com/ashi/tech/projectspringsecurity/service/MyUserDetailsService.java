package com.ashi.tech.projectspringsecurity.service;

import com.ashi.tech.projectspringsecurity.domain.User;
import com.ashi.tech.projectspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
         Optional<User>  user = userRepository.findByUserName(userName);

         user.orElseThrow(()-> new UsernameNotFoundException(("Not found"+ userName)));

         return user.map(MyUserDetails::new).get();
    }
}
