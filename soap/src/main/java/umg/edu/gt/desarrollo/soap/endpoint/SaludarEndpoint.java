package umg.edu.gt.desarrollo.soap.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import umg.edu.gt.desarrollo.soap.model.SaludarRequest;
import umg.edu.gt.desarrollo.soap.model.SaludarResponse;

@Endpoint
public class SaludarEndpoint {

    private static final String NAMESPACE_URI = "http://umg.edu.gt.desarrollo.web/soap/saludo";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "saludarRequest")
    @ResponsePayload
    public SaludarResponse saludar(@RequestPayload SaludarRequest request) {
        SaludarResponse response = new SaludarResponse();
        response.setMensaje("Hola, " + request.getNombre() + "! Bienvenido al servicio SOAP.");
        return response;
    }
}
