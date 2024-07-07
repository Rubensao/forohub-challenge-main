package com.challenge.forohub.domain.topico;

import com.challenge.forohub.domain.curso.Curso;
import com.challenge.forohub.domain.usuarios.Usuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public record DatosRegistroTopico(
        String titulo,
        String mensaje,
        @JsonManagedReference
        Usuario idUsuario,
        Curso nombreCurso
) {
}
