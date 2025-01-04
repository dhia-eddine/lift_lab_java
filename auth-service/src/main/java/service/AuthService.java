package service;


import dto.AuthCredentialsDto;
import entity.User;
import repository.UserRepository;
import util.JwtTokenUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtTokenUtil jwtTokenUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(AuthCredentialsDto authCredentialsDto) {
        User user = new User();
        user.setEmail(authCredentialsDto.getEmail());
        user.setPassword(passwordEncoder.encode(authCredentialsDto.getPassword()));
        return userRepository.save(user);
    }

    public String signIn(AuthCredentialsDto authCredentialsDto) {
        User user = userRepository.findByEmail(authCredentialsDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid email or password"));

        if (!passwordEncoder.matches(authCredentialsDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid email or password");
        }

        return jwtTokenUtil.generateToken(user);
    }
}