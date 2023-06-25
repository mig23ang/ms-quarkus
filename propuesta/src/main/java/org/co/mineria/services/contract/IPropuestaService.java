package org.co.mineria.services.contract;

import org.co.mineria.dto.PropuestaDetallesDTO;

public interface IPropuestaService {

    PropuestaDetallesDTO findFullPropuesta(long id);

    void crearPropuesta(PropuestaDetallesDTO propuesta);

    void actualizarPropuesta(PropuestaDetallesDTO propuesta);

    void eliminarPropuesta(Long id);
}
