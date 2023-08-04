package ru.khamedov.ildar.store.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        http.httpBasic();

        http.authorizeRequests().antMatchers("/signIn.html").permitAll()
                .antMatchers("/client.html").hasRole("CLIENT")
                .antMatchers("/api/owner/**").hasRole("OWNER")
                .antMatchers("/api/moderator/**").hasRole("MODERATOR");

        final FormLoginConfigurer<HttpSecurity> formLogin = http.formLogin();
        formLogin.loginPage("/signIn.html").defaultSuccessUrl("/");
        formLogin.usernameParameter("user");
        formLogin.loginProcessingUrl("/signIn.html");
        formLogin.passwordParameter("password");
        formLogin.failureUrl("/signIn.html?error=true");
        http.logout().logoutUrl("/signOut").logoutSuccessUrl("/");
    }
}