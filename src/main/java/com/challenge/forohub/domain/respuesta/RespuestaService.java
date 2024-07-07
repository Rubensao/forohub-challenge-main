package com.challenge.forohub.domain.respuesta;

import com.challenge.forohub.domain.curso.Curso;
import com.challenge.forohub.domain.topico.Topico;
import com.challenge.forohub.domain.topico.TopicoRepository;
import com.challenge.forohub.domain.usuarios.Usuario;
import com.challenge.forohub.domain.usuarios.UsuarioRepository;
import com.challenge.forohub.infra.errores.ValidacionDeIntegridad;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RespuestaService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    public DatosRegistroRespuesta guardarRespuesta(DatosInputRespuesta datos) {
        Long number = Long.parseLong(datos.idUsuario());
        Optional<Usuario> usuario = usuarioRepository.findById(number);
        if (!usuario.isPresent()) {
            throw new ValidacionDeIntegridad("No existe el usuario");
        }
        number = Long.parseLong(datos.idTopico());
        Optional<Topico> topico = topicoRepository.findById(number);
        if (!topico.isPresent()) {
            throw new ValidacionDeIntegridad("Este topico no fue encontrado");
        }
        DatosRegistroRespuesta registro = new DatosRegistroRespuesta(datos.mensaje(), topico.get(), usuario.get(), datos.solucion());

        return registro;
    }

    public Respuesta actualizarRespuesta(Long id, DatosActualizarRespuesta datos) {
        Optional<Respuesta> optionalRespuesta = respuestaRepository.findById(id);

        if (!optionalRespuesta.isPresent()) {
            throw new EntityNotFoundException("Tópico no encontrado");
        }

        Respuesta respuesta = optionalRespuesta.get();

        respuesta.actualizarDatos(datos);

        return respuestaRepository.save(respuesta);
    }
}
