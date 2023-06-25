package org.co.mineria.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cotizacion")
public class CotizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    @Column(name = "actual_price")
    private BigDecimal actualPrice;
    @Column(name = "porcentaje_cambio")
    private String pctChange;
    private String pair;
}
