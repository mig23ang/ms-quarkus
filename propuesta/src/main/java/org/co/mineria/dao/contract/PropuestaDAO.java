package org.co.mineria.dao.contract;

import jakarta.enterprise.context.ApplicationScoped;
import org.co.mineria.dao.entity.PropuestaEntity;

import java.util.Optional;

@ApplicationScoped
public class PropuestaDAO implements IPropuestaRepository{

    public Optional<PropuestaEntity> findByCliente(String cliente) {
        return Optional.of(find("cliente", cliente).firstResult());
    }
}
