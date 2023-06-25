package org.co.mineria.message;

import jakarta.enterprise.context.ApplicationScoped;
import org.co.mineria.dto.CotizacionDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaEvent {
    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    @Channel("canal-cotizacion")
    Emitter<CotizacionDTO> kafkaEmitter; // Emisor para enviar eventos de cotización a Kafka

    public void sendNewEventKafka(CotizacionDTO cotizacionDTO) {

        LOG.info("Enviando mensaje con 8888888888888888888888888 Kafka: {}", cotizacionDTO);

        // Enviar el evento de cotización a Kafka
        kafkaEmitter.send(cotizacionDTO).toCompletableFuture().join();
    }
}
