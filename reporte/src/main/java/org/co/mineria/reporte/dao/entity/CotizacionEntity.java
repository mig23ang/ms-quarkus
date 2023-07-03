package org.co.mineria.reporte.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "cotizacion")
@NoArgsConstructor
public class CotizacionEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @Column(name = "precio_actual")
    private BigDecimal precioActual;
}
