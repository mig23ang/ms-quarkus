package org.co.mineria.message;

import jakarta.enterprise.context.ApplicationScoped;
import org.co.mineria.dto.PropuestaDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.logging.Logger;


@ApplicationScoped
public class KafkaEvent {

    private final Logger LOG = Logger.getLogger(KafkaEvent.class.getName());


    @Channel("propuesta")
    Emitter<PropuestaDTO> propuestaDetallesDTOEmitter; // Emisor para enviar eventos de cotización a Kafka

    public void sendNewEventKafka(PropuestaDTO propuestaDTO) {

        LOG.info("Enviando mensaje con en propuesta Kafka: {}" + propuestaDTO);

        // Enviar el evento de cotización a Kafka
        propuestaDetallesDTOEmitter.send(propuestaDTO).toCompletableFuture().join();
    }
}
