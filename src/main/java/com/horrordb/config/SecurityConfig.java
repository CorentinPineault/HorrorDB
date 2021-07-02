package com.horrordb.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    public void configure(HttpSecurity httpSec) throws Exception {
        httpSec.csrf().disable()
        .authorizeRequests()
        .antMatchers("api/auth/**")
        .permitAll()
        .anyRequest()
        .authenticated();
    }
}
