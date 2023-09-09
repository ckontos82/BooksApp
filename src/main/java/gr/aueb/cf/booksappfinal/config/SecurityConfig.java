package gr.aueb.cf.booksappfinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
//    private static final String ENCODED_PASSWORD = "$2a$10$mWVKdCmd7M4Qf5HLoEn.n.9DNCrC2yI/tPkFWXPqfmsMimxkuxTHG";

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}password")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}adminPass")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests(request ->
                        request
                                .requestMatchers("/books/list").hasRole("USER")
                                .requestMatchers("/books/search_by_title").hasRole("USER")
                                .requestMatchers("/books/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticate")
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                );

        return http.build();
    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
