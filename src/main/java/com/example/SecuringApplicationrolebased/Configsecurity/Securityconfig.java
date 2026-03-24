package com.example.SecuringApplicationrolebased.Configsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class Securityconfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(auth-> auth
                // Role based Authentication
                .requestMatchers("/admin")
                .hasRole("ADMIN")
                .requestMatchers("/normal")
                .hasAnyRole("NORMAL","ADMIN")
                .requestMatchers("/public")
                .permitAll()
                .anyRequest()
                .authenticated())

                .formLogin(form->form.permitAll());
            return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails= User.withUsername("ravi")
                .password(passwordEncoder().encode("password"))
                .roles("NORMAL")
                .build();

        UserDetails adminDetails= User.withUsername("admin")
                .password(passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();

        //direct
        return new InMemoryUserDetailsManager(userDetails,adminDetails);

        /*
        //object creation and accesing
        InMemoryUserDetailsManager i=new InMemoryUserDetailsManager();
        i.createUser(userDetails);
        i.createUser(adminDetails);

        return i;

         */
    }
}
