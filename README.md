
Este proyecto es una aplicación web básica que implementa autenticación y autorización de usuarios utilizando **Spring Boot**, **Spring Security**, **JPA**, **Thymeleaf** y **PostgreSQL**.

# 🚀 Características

- 🧾 Formulario de inicio de sesión personalizado con Thymeleaf.
- 🔑 Autenticación basada en base de datos (JPA + PostgreSQL).
- 🛡️ Autorización basada en roles (`ADMIN` y `USER`).
- 👨‍💻 Página protegida para administradores.
- 👤 Página protegida para usuarios autenticados.
- 🌐 Página pública accesible sin login.

---

## 🛠️ Tecnologías usadas

- Java 17 o superior (usaste JDK 24)
- Spring Boot 3.5.3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Maven

---

⚙️ Configuración

### 1. Base de datos

Asegúrate de tener PostgreSQL ejecutando con una base de datos llamada `login_db` y configura el archivo `application.properties`:

``properties
spring.datasource.url=jdbc:postgresql://localhost:5433/login_db
spring.datasource.username=postgres
spring.datasource.password=12345678

### 2. Estructura inicial
Al iniciar la aplicación, se crean automáticamente dos usuarios:

👑 Admin:

Usuario: admin

Contraseña: admin123

👤 Usuario:

Usuario: usuario

Contraseña: user123

Las contraseñas se codifican con BCrypt.


http://localhost:8080/login → Página de login

http://localhost:8080/v1/admin → Página de administrador

http://localhost:8080/v1/home → Página de usuario

http://localhost:8080/public/home → Página pública

