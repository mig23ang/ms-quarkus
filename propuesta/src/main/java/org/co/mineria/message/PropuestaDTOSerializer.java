package org.co.mineria.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.co.mineria.dto.PropuestaDTO;

import java.nio.charset.StandardCharsets;

public class PropuestaDTOSerializer implements Serializer<PropuestaDTO> {


    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, PropuestaDTO data) {
        try {
            if (data == null) {
                return null;
            }
            return objectMapper.writeValueAsString(data).getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing PropuestaDTO", e);
        }
    }
}
