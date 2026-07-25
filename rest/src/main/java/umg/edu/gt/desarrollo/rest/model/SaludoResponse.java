package umg.edu.gt.desarrollo.rest.model;

public class SaludoResponse {

    private String mensaje;

    public SaludoResponse() {
    }

    public SaludoResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}