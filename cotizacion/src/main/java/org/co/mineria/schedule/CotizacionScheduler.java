package org.co.mineria.schedule;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.co.mineria.services.impl.CotizacionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class CotizacionScheduler {

    private final Logger LOG = LoggerFactory.getLogger(CotizacionScheduler.class);
    @Inject
    CotizacionServiceImpl cotizacionService;

    //fijamos el tiempo de consulta a la api de cotizacion
    @Transactional
    @Scheduled(every = "35s", identity = "cotizacion-scheduler")
    void schedule() {
        LOG.info("Actualizando el precion desde el calendario");
        cotizacionService.getActualPrice();
    }
}

