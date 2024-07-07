package com.challenge.forohub.domain.respuesta;

import com.challenge.forohub.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public record DatosListarRespuesta(
        Long id,
        String mensaje,
        String topico,
        String autor,
        String solucion,
        LocalDateTime fechaCreacion
) {
    @Entity(name = "Perfil")
    @Table(name = "perfil")
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    public static class Perfil {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        @ManyToMany(mappedBy = "perfiles")
        private List<Usuario> usuarios;

        public Perfil(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return "Perfil [nombre=" + nombre + ", usuarios=" + usuarios + "]";
        }


    }
}
