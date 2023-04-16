package sit.int204.classicmodelservice.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
public class JwtResponse implements Serializable {
    private final String jwtToken;
}
