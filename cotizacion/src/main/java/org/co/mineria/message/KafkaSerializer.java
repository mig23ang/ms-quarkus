package org.co.mineria.message;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.common.serialization.Serializer;
import org.co.mineria.dto.CotizacionDTO;
import org.hibernate.type.SerializationException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
public class KafkaSerializer implements Serializer<CotizacionDTO> {

//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public byte[] serialize(String topic, CotizacionDTO cotizacionDTO) {
//        try {
//            return objectMapper.writeValueAsBytes(cotizacionDTO);
//        } catch (JsonProcessingException e) {
//            throw new SerializationException("Error serializing CotizacionDTO", e);
//        }
//    }


    @Override
    public byte[] serialize(String topic, CotizacionDTO cotizacionDTO) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        SpecificDatumWriter<CotizacionDTOAvro> writer = new SpecificDatumWriter<>(CotizacionDTOAvro.class);
        CotizacionDTOAvro cotizacionDTOAvro = convertToAvro(cotizacionDTO);

        try {
            writer.write(cotizacionDTOAvro, encoder);
            encoder.flush();
            out.close();
        } catch (IOException e) {
            throw new SerializationException("Error serializing CotizacionDTO", e);
        }

        return out.toByteArray();
    }

    private CotizacionDTOAvro convertToAvro(CotizacionDTO cotizacionDTO) {
        CotizacionDTOAvro cotizacionDTOAvro = new CotizacionDTOAvro();
        cotizacionDTOAvro.setDate(cotizacionDTO.getDate().getTime()); // Convierte la fecha a un valor de tipo long
        cotizacionDTOAvro.setActualPrice(cotizacionDTO.getActualPrice().toString()); // Convierte el BigDecimal a String

        return cotizacionDTOAvro;
    }

}
