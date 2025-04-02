package com.jjvargas.formulario_nuevo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Indica que esta clase es un controlador REST
public class TestController {

    @Autowired  // Inyecta JdbcTemplate automáticamente
    private JdbcTemplate jdbcTemplate;

    // Endpoint accesible en http://localhost:8080/test-db
    @GetMapping("/test-db")
    public String testDB() {
        try {
            // Intenta ejecutar una consulta SQL simple
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "¡Conexión a SQL Server exitosa! 🎉";
        } catch (Exception e) {
            // Si hay error, devuelve detalles útiles
            return "❌ Error al conectar con la BD: " + e.getMessage() + 
                   "\nRevisa: " + 
                   "\n1. ¿SQL Server está en ejecución?" +
                   "\n2. ¿El usuario/contraseña son correctos?" +
                   "\n3. ¿La URL de conexión es válida?";
        }
    }
}