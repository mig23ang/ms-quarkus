package org.co.mineria.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "propuesta")
public class PropuestaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    @Column(name = "price_tonelada")
    private BigDecimal priceTonelada;
    private Integer toneladas;
    private String pais;
    @Column(name = "propuesta_valida_dias")
    private Integer propuestaValidaDias;
    private Date creado;
}
