package org.co.mineria.message;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.co.mineria.dto.CotizacionDTO;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@ApplicationScoped
public class KafkaEvent {
    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    private final KafkaProducer<String, CotizacionDTO> kafkaProducer;

    public KafkaEvent() {
        // Configurar las propiedades del KafkaProducer
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", KafkaSerializer.class.getName());
        properties.put("client.id", "cotizacion-producer");

        // Agregar otras propiedades si es necesario, como seguridad (SSL, SASL, etc.)

        // Crear una instancia de KafkaProducer
        this.kafkaProducer = new KafkaProducer<>(properties);


    }

    public void sendNewEventKafka(CotizacionDTO cotizacionDTO) {
        LOG.info("Enviando mensaje con Kafka: {}", cotizacionDTO);

        // Enviar el evento de cotización a Kafka
        ProducerRecord<String, CotizacionDTO> record = new ProducerRecord<>("cotizacion", cotizacionDTO);
        kafkaProducer.send(record, (metadata, exception) -> {
            if (exception == null) {
                LOG.info("Mensaje enviado con éxito a Kafka. Offset: {}, Partition: {}", metadata.offset(), metadata.partition());
            } else {
                LOG.error("Error al enviar mensaje a Kafka", exception);
            }
        });

        // Asegurarse de que los mensajes se envíen antes de continuar
        kafkaProducer.flush();
    }

    public void close() {
        // Cerrar el KafkaProducer cuando ya no sea necesario
        kafkaProducer.close();
    }
}
