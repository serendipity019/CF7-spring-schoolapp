package gr.aueb.cf.schoolapp.authentication;

import gr.aueb.cf.schoolapp.core.exceptions.AppObjectNotAuthorizedException;
import gr.aueb.cf.schoolapp.dto.AuthenticationRequestDTO;
import gr.aueb.cf.schoolapp.dto.AuthenticationResponseDTO;
import gr.aueb.cf.schoolapp.model.UserEntity;
import gr.aueb.cf.schoolapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class authenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO dto)
        throws AppObjectNotAuthorizedException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(), dto.password())
        );

        UserEntity user = userRepository.findByUsername(authentication.getName())
                .orElseThrow(() -> new AppObjectNotAuthorizedException("User", "User not authorized"));

        String token = jwtService.generateToken(authentication.getName(), user.getRole().name());
        return new AuthenticationResponseDTO(user.getFirstname(), user.getLastname(), token);
    }
}
