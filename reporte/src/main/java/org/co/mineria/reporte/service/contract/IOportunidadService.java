package org.co.mineria.reporte.service.contract;

import org.co.mineria.reporte.dto.CotizacionDTO;
import org.co.mineria.reporte.dto.OportunidadDTO;
import org.co.mineria.reporte.dto.PropuestaDTO;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface IOportunidadService {

    void construirReporte(PropuestaDTO propuestaDTO);

    void guardarCotiacion(CotizacionDTO cotizacionDTO);

    List<OportunidadDTO> generarOportunidades();

    ByteArrayInputStream generarCSVOportunidadReporte();

}
