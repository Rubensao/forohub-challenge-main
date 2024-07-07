package com.challenge.forohub.domain.usuarios;

import com.challenge.forohub.domain.respuesta.DatosListarRespuesta;
import jakarta.validation.constraints.Email;

import java.util.List;

public record DatosRegistroUsuario(
        String nombre,
        @Email
        String correoElectronico,
        String contrasena,
        List<DatosListarRespuesta.Perfil> perfiles
) {
}
