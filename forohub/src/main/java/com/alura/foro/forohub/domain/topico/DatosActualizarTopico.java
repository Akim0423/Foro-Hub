package com.alura.foro.forohub.domain.topico;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.alura.foro.forohub.domain.topico.Estados;
import java.time.LocalDateTime;

public record DatosActualizarTopico (

        String titulo,
        String mensaje,
        Estados status,
        Long autor,
        Long curso
){
}
