package org.co.mineria.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.co.mineria.dto.CotizacionDTO;
import org.hibernate.type.SerializationException;

public class KafkaSerializer implements Serializer<CotizacionDTO> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, CotizacionDTO cotizacionDTO) {
        try {
            return objectMapper.writeValueAsBytes(cotizacionDTO);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Error serializing CotizacionDTO", e);
        }
    }
}
