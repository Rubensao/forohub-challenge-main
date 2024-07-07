package com.challenge.forohub.domain.topico;
import com.challenge.forohub.domain.curso.Curso;
import com.challenge.forohub.domain.usuarios.Usuario;
import jakarta.validation.constraints.NotBlank;


public record DatosInputTopico(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        String idUsuario,
        String nombreCurso
) {
}
