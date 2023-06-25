package org.co.mineria.services.impl;

import org.co.mineria.dto.PropuestaDetallesDTO;
import org.co.mineria.services.contract.IPropuestaService;

import java.util.logging.Logger;

public class PropuestaServiceImpl implements IPropuestaService {

    private final Logger LOG = Logger.getLogger(PropuestaServiceImpl.class.getName());
    @Override
    public PropuestaDetallesDTO findFullPropuesta(long id) {
        return null;
    }

    @Override
    public void crearPropuesta(PropuestaDetallesDTO propuesta) {

    }

    @Override
    public void actualizarPropuesta(PropuestaDetallesDTO propuesta) {

    }

    @Override
    public void eliminarPropuesta(Long id) {

    }
}
