package com.letsTest.config;


import com.letsTest.Handler.entryPointHandler;
import com.letsTest.Handler.failureHandler;
import com.letsTest.Handler.logoutHandler;
import com.letsTest.Handler.successHandler;
import com.letsTest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Autowired
    private com.letsTest.Handler.entryPointHandler entryPointHandler;
    @Autowired
    private com.letsTest.Handler.successHandler successHandler;
    @Autowired
    private com.letsTest.Handler.failureHandler failureHandler;
    @Autowired
    private com.letsTest.Handler.logoutHandler logoutHandler;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();

        http.csrf().disable();
//                .authorizeRequests().antMatchers("/").permitAll();

        http.exceptionHandling().authenticationEntryPoint(entryPointHandler);
        http.formLogin().successHandler(successHandler);
        http.formLogin().failureHandler(failureHandler);
        http.logout().addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK));
                //.logoutSuccessUrl("/users/logout")
//                .permitAll();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

}