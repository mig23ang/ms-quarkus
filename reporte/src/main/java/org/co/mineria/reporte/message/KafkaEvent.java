package org.co.mineria.reporte.message;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.co.mineria.reporte.dto.CotizacionDTO;
import org.co.mineria.reporte.dto.PropuestaDTO;
import org.co.mineria.reporte.service.impl.OportunidadSeviceimpl;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaEvent {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    @Inject
    OportunidadSeviceimpl reporteSeviceimpl;

    @Incoming("propuesta")
    @Transactional
    public void recibirPropuesta(PropuestaDTO propuestaDTO) {

        LOG.info("Recibiendo mensaje en propuesta Kafka: {}" , propuestaDTO);
        reporteSeviceimpl.construirReporte(propuestaDTO);
    }

    @Incoming("cotizacion")
    @Blocking
    public void recibirCotizacion(CotizacionDTO cotizacionDTO) {

        LOG.info("Recibiendo mensaje en cotizacion Kafka: {}" , cotizacionDTO);
        reporteSeviceimpl.guardarCotiacion(cotizacionDTO);
    }
}
