package ru.nntu.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/login", "/login-error").permitAll()
                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login-error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN", "USER")
                .and()
                .withUser("Guznov").password(passwordEncoder().encode("admin")).roles("ADMIN", "USER")
                .and()
                .withUser("Kolchugin").password(passwordEncoder().encode("admin")).roles("ADMIN", "USER")
                .and()
                .withUser("Goryachev").password(passwordEncoder().encode("admin")).roles("ADMIN", "USER");

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
