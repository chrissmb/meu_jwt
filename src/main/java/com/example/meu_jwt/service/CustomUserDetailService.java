package com.example.meu_jwt.service;

import com.example.meu_jwt.model.CustomGrantedAuthority;
import com.example.meu_jwt.model.CustomUserDetail;
import com.example.meu_jwt.model.User;
import com.example.meu_jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not Found."));
        Collection<CustomGrantedAuthority> authorities = user.getRoles().stream()
                .map(e -> new CustomGrantedAuthority("ROLE_".concat(e.getName())))
                .collect(Collectors.toList());
        UserDetails userDetails = new CustomUserDetail(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
        return userDetails;
    }
}
