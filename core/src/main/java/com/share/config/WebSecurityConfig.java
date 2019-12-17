package com.share.config;

import com.share.handler.*;
import com.share.service.DatabaseUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Collections;

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

        @Autowired
        private AuthenticationLogoutHandler authenticationLogoutHandler;

        @Autowired
        private LoginAuthenticationDetailsSource loginAuthenticationDetailsSource;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .addFilterAfter(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().csrf().disable()
                    .authorizeRequests()
                    .antMatchers(
                "/static/**",
                            "/index.jsp",
                            "/api/sign_up",
                            "/api/logout",
                            "/api/is_username_duplicated/**",

                            "index_info/get",
                            "/api/verify_code",
                            "/api/index/articles/get"

                    )
                    .permitAll()
                    .antMatchers(HttpMethod.OPTIONS)
                    .permitAll()
                    .anyRequest().authenticated()
                    .and().formLogin().loginProcessingUrl("/api/login").authenticationDetailsSource(loginAuthenticationDetailsSource)
                    .successHandler(successHandler)
                    .failureHandler(failHandler)
                    .and().logout().logoutUrl("/api/logout").addLogoutHandler(authenticationLogoutHandler)
                    .and().exceptionHandling().authenticationEntryPoint(entryPoint);
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.parentAuthenticationManager(authenticationManagerBean());
            auth.authenticationProvider(authenticationProviderBean());
        }

        @Bean("md5PasswordEncoder")
        public Md5PasswordEncoder getMd5PasswordEncoder() {
            return new Md5PasswordEncoder(){
                @Override
                public String encodePassword(String rawPass, Object salt) {
                    return super.encodePassword(rawPass, "");
                }

                @Override
                public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
                    return super.isPasswordValid(encPass, rawPass, "");
                }
            };
        }

        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
            ProviderManager authenticationProvider = new ProviderManager(Collections.singletonList(new LoginAuthenticationProvider()));
            authenticationProvider.setEraseCredentialsAfterAuthentication(false);
            return authenticationProvider;
        }

        @Bean
        public AuthenticationProvider authenticationProviderBean() {
            return new LoginAuthenticationProvider();
        }

    }
}
