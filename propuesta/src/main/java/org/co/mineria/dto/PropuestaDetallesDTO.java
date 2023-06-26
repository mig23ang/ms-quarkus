package org.co.mineria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class PropuestaDetallesDTO {

    private Long propuestaId;
    private String cliente;
    private BigDecimal priceTonelada;
    private Integer toneladas;
    private String pais;
    private Integer propuestaValidaDias;
}
