package org.co.mineria.dao.contract;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.co.mineria.dao.entity.CotizacionEntity;

public interface ICotizacionRepository extends PanacheRepository<CotizacionEntity> {
}
