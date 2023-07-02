package org.co.mineria.reporte.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.co.mineria.reporte.dto.OportunidadDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static ByteArrayInputStream
    OportunidadtoCSV(List<OportunidadDTO> oportunidades) {
        final CSVFormat format = CSVFormat.DEFAULT.withHeader("id propuesta", "cliente", "precio por tonelada", "mejor cotizacion de moneda");

        try {

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format) {
                for(
                OportunidadDTO oportunidad :oportunidades)

                {
                    List<String> data = Arrays.asList(
                            String.valueOf(oportunidad.getPropuestaId()),
                            oportunidad.getCliente(),
                            String.valueOf(oportunidad.getPrecioPorTonelada()),
                            String.valueOf(oportunidad.getLastDollarCotizacion())
                    );
                    csvPrinter.printRecord(data);
                }
                csvPrinter.flush();
                return new

                ByteArrayInputStream(out.toByteArray());
            }
        } catch (Exception e) {

            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }

    }
}
