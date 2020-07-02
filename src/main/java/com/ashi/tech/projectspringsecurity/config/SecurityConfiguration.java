package com.ashi.tech.projectspringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Set our configuration on the auth object
        //Learning purpose: we used inMemoryAuthentication here
        auth.inMemoryAuthentication()
                .withUser("foo")
                .password("foo")
                .roles("USER")
                .and()
                .withUser("abc")
                .password("abc")
                .roles("ADMIN");

    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
         //Learning purpose:
        // Use the desired encode here.The NoOpPasswordEncoder wont encode.It will still be the plain text here
        return NoOpPasswordEncoder.getInstance();
    }
}
