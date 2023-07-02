package org.co.mineria.message;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.common.serialization.Serializer;
import org.co.mineria.avro.CotizacionDTOAvro;
import org.co.mineria.dto.CotizacionDTO;
import org.hibernate.type.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KafkaSerializer implements Serializer<CotizacionDTO> {
    private final Logger LOG = LoggerFactory.getLogger(KafkaSerializer.class);

    @Override
    public byte[] serialize(String topic, CotizacionDTO cotizacionDTO) {

        LOG.info("Inicia serializando CotizacionDTO: {}", cotizacionDTO);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        SpecificDatumWriter<CotizacionDTOAvro> writer = new SpecificDatumWriter<>(CotizacionDTOAvro.class);
        CotizacionDTOAvro cotizacionDTOAvro = convertToAvro(cotizacionDTO);

        try {
            writer.write(cotizacionDTOAvro, encoder);
            encoder.flush();
            out.close();
            LOG.info("Termina serializando CotizacionDTO : {}", cotizacionDTO);
            return out.toByteArray();
        } catch (IOException e) {
            LOG.error("Error serializando CotizacionDTO : {}", cotizacionDTO);
            throw new SerializationException("Error serializing CotizacionDTO", e);
        }

    }

    private CotizacionDTOAvro convertToAvro(CotizacionDTO cotizacionDTO) {

        LOG.info("Inicia Serializando cotizacionDTO a cotizacionDTOAvro ");
        try {
            CotizacionDTOAvro cotizacionDTOAvro = new CotizacionDTOAvro();
            cotizacionDTOAvro.setDate(cotizacionDTO.getDate().getTime()); // Convierte la fecha a un valor de tipo long
            cotizacionDTOAvro.setActualPrice(cotizacionDTO.getActualPrice().toString()
            ); // Convierte el BigDecimal a String

            LOG.info("Termina Serializando cotizacionDTO a cotizacionDTOAvro ");
            return cotizacionDTOAvro;
        } catch (Exception e) {
            LOG.error("Error Serializando cotizacionDTO a cotizacionDTOAvro ");
            return null;
        }
    }

}