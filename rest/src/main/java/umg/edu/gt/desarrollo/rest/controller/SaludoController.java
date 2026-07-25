package umg.edu.gt.desarrollo.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import umg.edu.gt.desarrollo.rest.model.SaludoResponse;

@RestController
@RequestMapping("/api")
public class SaludoController {

    @GetMapping("/saludo/{nombre}")
    public ResponseEntity<SaludoResponse> saludar(@PathVariable("nombre") String nombre) {
        String mensaje = "Hola, " + nombre + "! Bienvenido al servicio REST.";
        SaludoResponse response = new SaludoResponse(mensaje);
        return ResponseEntity.ok(response);
    }
}
