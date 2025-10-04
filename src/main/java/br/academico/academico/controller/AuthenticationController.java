package br.academico.academico.controller;


import br.academico.academico.model.LoginRequest;
import br.academico.academico.model.LoginResponse;
import br.academico.academico.model.User;
import br.academico.academico.service.AuthorizationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final AuthorizationService authorizationService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(value = "/login", consumes = {"application/json"})
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest data, HttpServletRequest request) {
        LoginResponse loginResponse = authorizationService.login(data, request, authenticationManager);
        return ResponseEntity.ok().body(loginResponse);
    }


    @PostMapping(value = "/register", consumes = {"application/json"})
    public ResponseEntity<User> register(@RequestBody User data) {
        User usuario = authorizationService.register(data);
        return ResponseEntity.ok().body(usuario);
    }
}
