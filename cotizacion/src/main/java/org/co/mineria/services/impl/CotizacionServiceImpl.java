package org.co.mineria.services.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.co.mineria.client.PriceClient;
import org.co.mineria.dao.contract.CotizacionDAO;
import org.co.mineria.dao.entity.CotizacionEntity;
import org.co.mineria.dto.CotizacionDTO;
import org.co.mineria.dto.PriceDTO;
import org.co.mineria.message.KafkaEvent;
import org.co.mineria.services.contract.ICotizacionService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class CotizacionServiceImpl implements ICotizacionService {

    private final Logger LOG = LoggerFactory.getLogger(CotizacionServiceImpl.class);

    @Inject
    @RestClient
    PriceClient priceClient; // Cliente REST para obtener precios

    @Inject
    CotizacionDAO cotizacionDAO; // Acceso a la capa de datos para persistir cotizaciones

    @Inject
    KafkaEvent kafkaEvent; // Evento para enviar actualizaciones de cotización a Kafka

    public void getActualPrice() {
        LOG.info("Obteniendo el actual price");
        // Obtener el precio actual mediante una llamada al cliente REST
        PriceDTO actualPriceInfo = priceClient.getPriceByPair("USD-BRL");

        // Actualizar la cotización actual y enviar un evento Kafka si se realiza una actualización
        if (updateActualPrice(actualPriceInfo)) {
            kafkaEvent.sendNewEventKafka(CotizacionDTO
                    .builder()
                    .actualPrice(new BigDecimal(actualPriceInfo.getUSDBRL().getBid()))
                    .date(new Date())
                    .build());
        }
    }

    private boolean updateActualPrice(PriceDTO actualPriceInfo) {
        // Obtener el precio actual
        BigDecimal actualPrice = new BigDecimal(actualPriceInfo.getUSDBRL().getBid());
        boolean updatedPrice = false;

        // Obtener todas las cotizaciones existentes en la base de datos
        List<CotizacionEntity> cotizacionEntityList = cotizacionDAO.findAll().list();

        if (cotizacionEntityList.isEmpty()) {
            // Si no hay cotizaciones existentes, guardar la cotización actual en la base de datos
            saveCotizacion(actualPriceInfo);
            updatedPrice = true;
        } else {
            // Si hay cotizaciones existentes, comparar el precio actual con la última cotización guardada
            CotizacionEntity lastDollarPriceCotizacion = cotizacionEntityList.get(cotizacionEntityList.size() - 1);
            if (actualPrice.floatValue() > lastDollarPriceCotizacion.getActualPrice().floatValue()) {
                // Si el precio actual es mayor que el último precio guardado, guardar la cotización actual
                updatedPrice = true;
                saveCotizacion(actualPriceInfo);
            }
        }
        return updatedPrice;
    }

    private void saveCotizacion(PriceDTO actualPriceInfo) {
        // Guardar una nueva cotización en la base de datos
        CotizacionEntity cotizacion = new CotizacionEntity();
        cotizacion.setDate(new Date());
        cotizacion.setActualPrice(new BigDecimal(actualPriceInfo.getUSDBRL().getBid()));
        cotizacion.setPctChange(actualPriceInfo.getUSDBRL().getPctChange());
        cotizacion.setPair("USD-BRL");
        cotizacionDAO.persist(cotizacion);
    }
}

