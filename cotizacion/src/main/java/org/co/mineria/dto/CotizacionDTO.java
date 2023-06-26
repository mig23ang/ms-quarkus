package org.co.mineria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Date;

@Jacksonized
@Data
@Builder
@AllArgsConstructor
public class CotizacionDTO {

    private Date date;
    private BigDecimal actualPrice;

}
