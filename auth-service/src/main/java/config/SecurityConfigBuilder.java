package config;

import org.springframework.security.core.userdetails.UserDetailsService;
import util.JwtTokenFilter;

public class SecurityConfigBuilder {
    private JwtTokenFilter jwtTokenFilter;
    private UserDetailsService userDetailsService;

    public SecurityConfigBuilder setJwtTokenFilter(JwtTokenFilter jwtTokenFilter) {
        this.jwtTokenFilter = jwtTokenFilter;
        return this;
    }

    public SecurityConfigBuilder setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        return this;
    }

    public SecurityConfig createSecurityConfig() {
        return new SecurityConfig(jwtTokenFilter, userDetailsService);
    }
}