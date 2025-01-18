package com.alura.foro.forohub.domain.usuario;

import com.alura.foro.forohub.domain.perfil.Perfil;

public record DatosTopicoUsuario(
        Long id,
        String nombre,
        String correoElectronico,
        Perfil perfil
) {
    public DatosTopicoUsuario(Usuario datos){
        this(datos.getId(), datos.getNombre(), datos.getCorreo_electronico(), datos.getPerfil());
    }
}
