package com.appdeveloper.photoapp.api.users.photoappapiusers.ui.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private Environment environment;

    @Autowired
    public WebSecurity(Environment environment) {
        this.environment = environment;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/users/**").permitAll().and().addFilter(getAuthenticationFilter());
        http.headers().frameOptions().disable();
    }

    private AutheticationFilter getAuthenticationFilter() throws Exception{
        AutheticationFilter autheticationFilter = new AutheticationFilter();
        autheticationFilter.setAuthenticationManager(authenticationManager());
        return autheticationFilter;
    }

}
