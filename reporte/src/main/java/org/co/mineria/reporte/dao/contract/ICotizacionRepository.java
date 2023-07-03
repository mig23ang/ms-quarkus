package org.co.mineria.reporte.dao.contract;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.co.mineria.reporte.dao.entity.CotizacionEntity;

public interface ICotizacionRepository extends PanacheRepository<CotizacionEntity> {
}
