package org.co.mineria.services.contract;

import org.co.mineria.dto.PropuestaDetallesDTO;

public interface IPropuestaService {

    PropuestaDetallesDTO findFullPropuesta(long id);

    void crearPropuesta(PropuestaDetallesDTO propuestaDetallesDTO);

    void actualizarPropuesta(PropuestaDetallesDTO propuestaDetallesDTO);

    void eliminarPropuesta(Long id);
}
