package org.co.mineria.reporte.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.co.mineria.reporte.dto.OportunidadDTO;
import org.co.mineria.reporte.message.KafkaEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static ByteArrayInputStream oportunidadToCSV(List<OportunidadDTO> oportunidades) {

        // Define el formato del archivo CSV con encabezados de columna
        final CSVFormat format = CSVFormat.DEFAULT.withHeader("id propuesta", "cliente", "precio por tonelada", "mejor cotizacion de moneda");

        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                // Crea un objeto CSVPrinter para escribir datos en el archivo CSV
                CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)
        ) {
            for (OportunidadDTO oportunidad : oportunidades) {
                // Crea una lista de strings con los valores de cada columna en una fila
                List<String> data = Arrays.asList(
                        String.valueOf(oportunidad.getPropuestaId()),
                        oportunidad.getCliente(),
                        String.valueOf(oportunidad.getPrecioPorTonelada()),
                        String.valueOf(oportunidad.getLastDollarCotizacion())
                );
                // Escribe la fila en el archivo CSV
                csvPrinter.printRecord(data);
            }
            // Guarda los cambios y vacía el búfer en el archivo CSV
            csvPrinter.flush();
            // Crea un objeto ByteArrayInputStream a partir de los datos escritos en el búfer
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            // Maneja la excepción en caso de error al generar el archivo CSV
            throw new RuntimeException("Failed to generate CSV file: " + e.getMessage());
        }
    }
}
