package org.co.mineria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {

    public USDCO USDCOP;
}
