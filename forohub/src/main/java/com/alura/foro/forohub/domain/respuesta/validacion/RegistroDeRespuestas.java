package com.alura.foro.forohub.domain.respuesta.validacion;

import com.alura.foro.forohub.domain.respuesta.DatosDetalleRespuesta;
import com.alura.foro.forohub.domain.respuesta.DatosRegistroRespuesta;
import com.alura.foro.forohub.domain.respuesta.Respuesta;
import com.alura.foro.forohub.domain.respuesta.RespuestaRepository;
import com.alura.foro.forohub.domain.topico.Topico;
import com.alura.foro.forohub.domain.topico.TopicoRepository;
import com.alura.foro.forohub.domain.usuario.Usuario;
import com.alura.foro.forohub.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroDeRespuestas {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    public DatosDetalleRespuesta registrar(DatosRegistroRespuesta datos){
        boolean existeDuplicado = respuestaRepository.existsByMensaje(datos.mensaje());
        if(existeDuplicado){
            throw new IllegalArgumentException("Ya existe una respuesta con el mismo mensaje.");
        }

        Topico topico = topicoRepository.findById(datos.idTopico())
                .orElseThrow(() -> new EntityNotFoundException("Topico no encontrado"));

        Usuario usuario = usuarioRepository.findById(datos.idAutor())
                .orElseThrow(() -> new EntityNotFoundException("Usuario No encontrado"));

        Respuesta respuesta = new Respuesta(datos, topico, usuario);
        respuestaRepository.save(respuesta);
        return new DatosDetalleRespuesta(respuesta);


    }

}
