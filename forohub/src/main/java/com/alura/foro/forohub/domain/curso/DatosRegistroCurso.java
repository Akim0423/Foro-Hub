package com.alura.foro.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso (
        @NotBlank String nombre,
        @NotNull Categoria categoria
){
}
