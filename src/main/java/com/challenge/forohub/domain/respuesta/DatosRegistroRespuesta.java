package com.challenge.forohub.domain.respuesta;

import com.challenge.forohub.domain.topico.Topico;
import com.challenge.forohub.domain.usuarios.Usuario;

public record DatosRegistroRespuesta(
        String mensaje,
        Topico topico,
        Usuario autor,
        String solucion
) {

}
