package org.co.mineria.reporte.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Table(name = "oportunidad")
@Entity
@Data
@NoArgsConstructor

public class OportunidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @Column(name = "propuesta_Id")
    private Long propuestaId;

    private String cliente;

    @Column(name = "precio_tonelada")
    private BigDecimal precioPorTonelada;

    @Column(name = "last_dollar_cotizazcion")
    private BigDecimal lastDollarCotizazcion;


}
