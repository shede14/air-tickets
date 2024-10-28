package ua.com.shede.airtickets.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import ua.com.shede.airtickets.service.CustomerService;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {

    private final CustomerService customerService;

    public WebSecurityConfig(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public ReactiveAuthenticationManager authenticationManager() {
        UserDetailsRepositoryReactiveAuthenticationManager authManager =
                new UserDetailsRepositoryReactiveAuthenticationManager(customerService);
        authManager.setPasswordEncoder(passwordEncoder());
        return authManager;
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

        return http.csrf(csrf -> csrf.disable())
                .authorizeExchange(exchange ->
                        exchange.pathMatchers("/", "/customers/register")
                                .permitAll()
                                .pathMatchers("/users").hasRole("User")
                                .pathMatchers("/admin").hasRole("Admin")
                                .anyExchange().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .authenticationManager(authenticationManager())
                .build();
    }
}
