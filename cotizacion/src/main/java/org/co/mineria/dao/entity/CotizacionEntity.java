package org.co.mineria.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "cotizacion")
@NoArgsConstructor
@AllArgsConstructor
public class CotizacionEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    private Date date;
    private BigDecimal price;
    @Column(name = "porcentaje_cambio")
    private String pctChange;
    private String pair;
}
