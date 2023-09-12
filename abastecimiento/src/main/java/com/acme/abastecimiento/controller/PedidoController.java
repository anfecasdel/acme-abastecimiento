package com.acme.abastecimiento.controller;

import com.acme.abastecimiento.model.PedidoRequest;
import com.acme.abastecimiento.model.PedidoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    @Value("${acme.endpoint}")
    private String soapEndpoint;

    @PostMapping("/enviar")
    public PedidoResponse enviarPedido(@RequestBody PedidoRequest pedidoRequest ){
        //Transformar PedidoRequest JSON a XML usando JAXB
        String xmlRequest = convertirPedidoRequestAXML(pedidoRequest);

        // Enviar solicitud SOAP al servicio externo y recibir respuesta XML
        String xmlResponse = llamarServicioSOAP(xmlRequest);

        // Transformar respuesta XML a PedidoResponse JSON usando JAXB
        PedidoResponse respuesta = convertirXMLaPedidoResponse(xmlResponse);

        // Retornar la respuesta
        return respuesta;
    }

    private String convertirPedidoRequestAXML(PedidoRequest pedidoRequest) {
        try {
            JAXBContext context = JAXBContext.newInstance(PedidoRequest.class);
            Marshaller marshaller = context.createMarshaller();
            StringWriter writer = new StringWriter();
            marshaller.marshal(pedidoRequest, writer);
            return writer.toString();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

    private String llamarServicioSOAP(String xmlRequest) {
        // Configurar los encabezados HTTP para la solicitud SOAP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);

        // Crear la entidad HTTP con el cuerpo XML y los encabezados
        HttpEntity<String> requestEntity = new HttpEntity<>(xmlRequest, headers);

        // Realizar la solicitud POST al servicio SOAP
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(
            soapEndpoint,
            HttpMethod.POST,
            requestEntity,
            String.class
        );

        // Obtener la respuesta del servicio SOAP en formato XML
        String xmlResponse = responseEntity.getBody();

        return xmlResponse;
    }

    private PedidoResponse convertirXMLaPedidoResponse(String xmlResponse) {
        try {
            JAXBContext context = JAXBContext.newInstance(PedidoResponse.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlResponse);
            return (PedidoResponse) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            // Manejar excepción si ocurre un error en la conversión
            e.printStackTrace();
            return null;
        }
    }

}
