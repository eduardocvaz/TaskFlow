package ufrn.br.taskflow.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ufrn.br.taskflow.repository.CredencialRepository;
import ufrn.br.taskflow.model.Credencial;

import java.util.Optional;

@Service
public class CredencialService implements UserDetailsService {
    CredencialRepository repository;

    BCryptPasswordEncoder encoder;

    public CredencialService(CredencialRepository repository, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Credencial> credencial = repository.findByUsername(username);

        if(credencial.isPresent()){
            return credencial.get();
        } else {
            throw new UsernameNotFoundException("Usuário não cadastrado com username: " + username);
        }
    }

    public Credencial create(Credencial c){
        c.setPassword(encoder.encode(c.getPassword()));
        return repository.save(c);
    }
}

