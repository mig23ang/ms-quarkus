package org.co.mineria.reporte.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.co.mineria.reporte.dao.contract.CotizacionDAO;
import org.co.mineria.reporte.dao.contract.OportunidadDAO;
import org.co.mineria.reporte.dao.entity.CotizacionEntity;
import org.co.mineria.reporte.dao.entity.OportunidadEntity;
import org.co.mineria.reporte.dto.CotizacionDTO;
import org.co.mineria.reporte.dto.OportunidadDTO;
import org.co.mineria.reporte.dto.PropuestaDTO;
import org.co.mineria.reporte.service.contract.IOportunidadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class OportunidadSeviceimpl implements IOportunidadService {

    private final Logger LOG = LoggerFactory.getLogger(OportunidadSeviceimpl.class);

    @Inject
    CotizacionDAO cotizacionDAO;

    @Inject
    OportunidadDAO oportunidadRepository;
    @Override
    public void construirReporte(PropuestaDTO propuestaDTO) {

        LOG.info("Inicia construir reporte en OportunidadServiceImpl");

        List<CotizacionEntity> cotizacionEntity = cotizacionDAO.findAll().list();
        Collections.reverse(cotizacionEntity);

        if (!cotizacionEntity.isEmpty()) {
            CotizacionEntity ultimaCotizacion = cotizacionEntity.get(0);

            OportunidadEntity oportunidadEntity = new OportunidadEntity();
            oportunidadEntity.setDate(new Date());
            oportunidadEntity.setPropuestaId(propuestaDTO.getPropuestaId());
            oportunidadEntity.setCliente(propuestaDTO.getCliente());
            oportunidadEntity.setPrecioPorTonelada(propuestaDTO.getPrecioPorTonelada());
            oportunidadEntity.setLastDollarCotizazcion(ultimaCotizacion.getPrecioActual());

            oportunidadRepository.persist(oportunidadEntity);
        } else {
            LOG.warn("No se encontraron cotizaciones para construir el reporte.");
        }
    }

    @Override
    public void guardarCotiacion(CotizacionDTO cotizacionDTO) {

    }

    @Override
    public List<OportunidadDTO> generarOportunidades() {
        return null;
    }
}
