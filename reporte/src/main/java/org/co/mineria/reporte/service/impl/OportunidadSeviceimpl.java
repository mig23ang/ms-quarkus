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
import org.co.mineria.reporte.utils.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
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

            OportunidadEntity oportunidadEntity = new OportunidadEntity();
            oportunidadEntity.setDate(new Date());
            oportunidadEntity.setPropuestaId(propuestaDTO.getPropuestaId());
            oportunidadEntity.setCliente(propuestaDTO.getCliente());
            oportunidadEntity.setPrecioPorTonelada(propuestaDTO.getPrecioPorTonelada());
            oportunidadEntity.setLastDollarCotizazcion(cotizacionEntity.get(0).getPrecioActual());

            LOG.info("Termina construir reporte en OportunidadServiceImpl");
            oportunidadRepository.persist(oportunidadEntity);
        } else {
            LOG.warn("No se encontraron cotizaciones para construir el reporte.");
        }
    }

    @Override
    public void guardarCotiacion(CotizacionDTO cotizacionDTO) {

        LOG.info("Inicia guardarCotiacion en OportunidadServiceImpl");
        try {
            CotizacionEntity cotizacionEntity = new CotizacionEntity();
            cotizacionEntity.setDate(new Date());
            cotizacionEntity.setPrecioActual(cotizacionDTO.getPrecioActual());

            LOG.info("Termina guardarCotiacion en OportunidadServiceImpl");
            cotizacionDAO.persist(cotizacionEntity);

        } catch (Exception e) {
            LOG.error("Error al guardar la cotizacion: {}", e.getMessage());
        }
    }

    @Override
    public List<OportunidadDTO> generarOportunidades() {
//        LOG.info("Inicia generarOportunidades en OportunidadServiceImpl");
//        try {
//            List<OportunidadEntity> oportunidadEntities = oportunidadRepository.findAll().list();
//            List<OportunidadDTO> oportunidadDTOs = new ArrayList<>();
//
//            for (OportunidadEntity oportunidadEntity : oportunidadEntities) {
//                OportunidadDTO oportunidadDTO = new OportunidadDTO();
//                oportunidadDTO.setPropuestaId(oportunidadEntity.getPropuestaId());
//                oportunidadDTO.setCliente(oportunidadEntity.getCliente());
//                oportunidadDTO.setPrecioPorTonelada(oportunidadEntity.getPrecioPorTonelada());
//                oportunidadDTO.setLastDollarCotizacion(oportunidadEntity.getLastDollarCotizazcion());
//                oportunidadDTOs.add(oportunidadDTO);
//            }
//
//            LOG.info("Termina generarOportunidades en OportunidadServiceImpl");
//            return oportunidadDTOs;
//        } catch (Exception e) {
//            LOG.error("Error al generar las oportunidades: {}", e.getMessage());
//        }
        return null;
    }

    @Override
    public ByteArrayInputStream generarCSVOportunidadReporte() {

        LOG.info("Inicia generarCSVOportunidadReporte en OportunidadServiceImpl");
        try {
            List<OportunidadDTO> oportunidadList = new ArrayList<>();
            oportunidadRepository.findAll().list().forEach(item -> {
                oportunidadList.add(OportunidadDTO.builder()
                        .propuestaId(item.getPropuestaId())
                        .cliente(item.getCliente())
                        .precioPorTonelada(item.getPrecioPorTonelada())
                        .lastDollarCotizacion(item.getLastDollarCotizazcion())
                        .build());
            });
            LOG.info("Termina generarCSVOportunidadReporte en OportunidadServiceImpl");
            return CSVHelper.oportunidadToCSV(oportunidadList);
        } catch (Exception e) {
            LOG.error("Error al generar el reporte: {}", e.getMessage());
        }
        return null;
    }

}
