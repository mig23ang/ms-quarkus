package org.co.mineria.reporte.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class PropuestaDTO {

    private Long propuestaId;
    private String cliente;
    private BigDecimal precioPorTonelada;
}
