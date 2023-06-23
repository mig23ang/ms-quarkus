package org.co.mineria.dto.contract;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.co.mineria.dto.entity.CotizacionEntity;

public interface ICotizacionRepository extends PanacheRepository<CotizacionEntity> {
}
