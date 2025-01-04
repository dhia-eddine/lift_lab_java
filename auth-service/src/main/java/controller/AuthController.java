package controller;

import dto.AuthCredentialsDto;
import entity.User;
import service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@Valid @RequestBody AuthCredentialsDto authCredentialsDto) {
        User user = authService.signUp(authCredentialsDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Map<String, String>> signIn(@Valid @RequestBody AuthCredentialsDto authCredentialsDto) {
        String token = authService.signIn(authCredentialsDto);
        Map<String, String> response = new HashMap<>();
        response.put("access_token", token);
        return ResponseEntity.ok(response);
    }
}