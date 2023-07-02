package org.co.mineria.avro;

import org.apache.avro.reflect.Nullable;

public class CotizacionDTOAvroPrueba {
    @Nullable
    private Long date;

    @Nullable
    private String actualPrice;

    public CotizacionDTOAvro() {
    }

    public CotizacionDTOAvro(Long date, String actualPrice) {
        this.date = date;
        this.actualPrice = actualPrice;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }
}
