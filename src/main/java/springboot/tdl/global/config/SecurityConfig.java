package springboot.tdl.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((auth) -> auth
                .requestMatchers("/images/**").permitAll()
                .requestMatchers("/favicon.ico").permitAll()
                .requestMatchers("/video/**").permitAll()
                .requestMatchers(
                        "/",
                        "login",
                        "signup",
                        "logout",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-ui.html").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/board/**").hasAnyRole("ADMIN","USER")
                .anyRequest().authenticated()
        );
        return http.build();
    }
}
