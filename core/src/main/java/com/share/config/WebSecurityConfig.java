package com.share.config;

import com.share.handler.AuthenticationEntryPointImpl;
import com.share.handler.AuthenticationFailHandler;
import com.share.handler.AuthenticationSuccessHandler;
import com.share.handler.JwtAuthenticationFilter;
import com.share.service.DatabaseUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Configuration
    public static class MySecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        @Qualifier("databaseUserDetailService")
        private DatabaseUserDetailsService databaseUserDetailsService;

        @Autowired
        @Qualifier("authenticationFailHandler")
        private AuthenticationFailHandler failHandler;

        @Autowired
        @Qualifier("authenticationSuccessHandler")
        private AuthenticationSuccessHandler successHandler;

        @Autowired
        @Qualifier("authenticationEntryPointImpl")
        private AuthenticationEntryPointImpl entryPoint;

        @Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterAfter(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().csrf().disable().authorizeRequests()
                    .antMatchers("/static/**", "/index.jsp", "/api/signup").permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().loginProcessingUrl("/api/login")
//                    .and().logout().addLogoutHandler()
                    .successHandler(successHandler)
                    .failureHandler(failHandler)
                    .and().exceptionHandling().authenticationEntryPoint(entryPoint);
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(databaseUserDetailsService).passwordEncoder(new Md5PasswordEncoder(){
                @Override
                public String encodePassword(String rawPass, Object salt) {
                    return super.encodePassword(rawPass, "");
                }

                @Override
                public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
                    return super.isPasswordValid(encPass, rawPass, "");
                }
            });
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
    }
}
