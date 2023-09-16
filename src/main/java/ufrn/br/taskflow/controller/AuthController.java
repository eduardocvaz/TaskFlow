package ufrn.br.taskflow.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import ufrn.br.taskflow.service.TokenService;
import ufrn.br.taskflow.dto.LoginDTO;

@RestController
public class AuthController {

    private final TokenService service;

    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService service, AuthenticationManager authenticationManager){
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public String getToken(@RequestBody LoginDTO loginDto){
        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password())
                );
        String token = service.generateToken(authentication);
        return token;
    }
}