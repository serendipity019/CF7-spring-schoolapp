package gr.aueb.cf.schoolapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;


@Builder
public record AuthenticationRequestDTO (
        @NotNull
         String username,

        @NotNull
        String password
) { }
