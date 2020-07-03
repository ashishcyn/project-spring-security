package com.ashi.tech.projectspringsecurity.service;

import com.ashi.tech.projectspringsecurity.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;



public class MyUserDetails implements UserDetails {

    private  String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;


    public MyUserDetails(User user) {
        this.userName = user.getUserName();
        this.password = user.getPassword() ;
        this.active   = user.isActive();
        //In DB for the time being we have User table. Roles are also present in that as coma separated
        this.authorities = Arrays.stream( user.getRoles().split(","))
                            .map(SimpleGrantedAuthority::new )
                            .collect(Collectors.toList());

    }
    public MyUserDetails() {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
