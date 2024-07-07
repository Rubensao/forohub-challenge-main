
# Foro Hub Challenge

## Descripción

Este proyecto es una API REST para un foro de discusión. Fue desarrollado utilizando Spring Boot y permite a los usuarios crear, leer, actualizar y eliminar tópicos. Los usuarios deben autenticarse mediante JSON Web Tokens (JWT) para realizar ciertas acciones.

## Requisitos Previos

- Java 17 o superior
- Maven 3.6.3 o superior
- IDE de tu preferencia (recomendado IntelliJ IDEA)
- Postman o Insomnia para probar la API

## Configuración del Proyecto

### Clonar el Repositorio

```sh
git clone https://github.com/tu_usuario/foro-hub-challenge.git
cd foro-hub-challenge
```

### Configuración del Entorno

1. **Configura el archivo `application.properties`**

   Crea un archivo `application.properties` en `src/main/resources/` con el siguiente contenido:

   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.h2.console.enabled=true
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.jpa.hibernate.ddl-auto=create-drop

   api.security.secret=your_jwt_secret
   ```

   Asegúrate de reemplazar `your_jwt_secret` con una clave secreta segura para firmar los tokens JWT.

2. **Instala las dependencias de Maven**

   Navega hasta la raíz del proyecto y ejecuta el siguiente comando para instalar las dependencias necesarias:

   ```sh
   mvn clean install
   ```

## Ejecución del Proyecto

### Desde la Línea de Comandos

Ejecuta el siguiente comando en la raíz del proyecto:

```sh
mvn spring-boot:run
```

### Desde un IDE

1. Importa el proyecto como un proyecto de Maven.
2. Ejecuta la clase `ForoApplication.java` desde tu IDE.

## Endpoints de la API

### Autenticación

- **POST /auth/register**
  
  Registra un nuevo usuario.

  ```json
  {
    "username": "user",
    "password": "password",
    "email": "user@example.com"
  }
  ```

- **POST /auth**

  Autentica un usuario y obtiene un token JWT.

  ```json
  {
    "username": "user",
    "password": "password"
  }
  ```

### Tópicos

- **GET /topics**

  Lista todos los tópicos.

- **POST /topics**

  Crea un nuevo tópico (requiere autenticación).

  ```json
  {
    "title": "Título del Tópico",
    "message": "Mensaje del Tópico"
  }
  ```

- **DELETE /topics/{id}**

  Elimina un tópico por ID (requiere autenticación).

## Pruebas con Insomnia

Puedes utilizar [Insomnia](https://insomnia.rest/) o [Postman](https://www.postman.com/) para probar la API. A continuación se muestra una breve guía para probar los endpoints:

1. **Registrar un usuario:**

   - URL: `POST http://localhost:8080/auth/register`
   - Body:
     ```json
     {
       "username": "user",
       "password": "password",
       "email": "user@example.com"
     }
     ```

2. **Autenticar al usuario:**

   - URL: `POST http://localhost:8080/auth`
   - Body:
     ```json
     {
       "username": "user",
       "password": "password"
     }
     ```
   - Copia el token JWT de la respuesta.

3. **Crear un nuevo tópico:**

   - URL: `POST http://localhost:8080/topics`
   - Headers: 
     ```plaintext
     Authorization: Bearer <token>
     ```
   - Body:
     ```json
     {
       "title": "Título del Tópico",
       "message": "Mensaje del Tópico"
     }
     ```

4. **Listar todos los tópicos:**

   - URL: `GET http://localhost:8080/topics`

5. **Eliminar un tópico:**

   - URL: `DELETE http://localhost:8080/topics/{id}`
   - Headers: 
     ```plaintext
     Authorization: Bearer <token>
     ```

## Notas Adicionales

- **Base de Datos:** Se utiliza H2 en memoria para facilitar las pruebas y el desarrollo. En un entorno de producción, puedes cambiar la configuración para utilizar una base de datos diferente, como MySQL o PostgreSQL.
- **Seguridad:** La API utiliza JWT para la autenticación y autorización. Asegúrate de mantener tu clave secreta segura y de cambiarla regularmente.

