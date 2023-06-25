package org.co.mineria.message;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.co.mineria.dto.PropuestaDetallesDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.logging.Logger;

@ApplicationScoped
public class KafkaEvent {

    private final Logger LOG = Logger.getLogger(KafkaEvent.class.getName());


    @Channel("canal-propuesta")
    Emitter<PropuestaDetallesDTO> propuestaDetallesDTOEmitter; // Emisor para enviar eventos de cotización a Kafka

    public void sendNewEventKafka(PropuestaDetallesDTO propuestaDetallesDTO) {

        LOG.info("Enviando mensaje con en propuesta Kafka: {}" + propuestaDetallesDTO);

        // Enviar el evento de cotización a Kafka
        propuestaDetallesDTOEmitter.send(propuestaDetallesDTO).toCompletableFuture().join();
    }
}
