package org.co.mineria.reporte.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.ServerErrorException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.co.mineria.reporte.service.impl.OportunidadSeviceimpl;

import java.util.Date;

@Path("/api/oportunidad")
public class ReporteController {

    @Inject
    OportunidadSeviceimpl oportunidadSeviceimpl;

    @GET
    @Path("/reporte")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response generarReporte() {

        try {
            return Response.ok(oportunidadSeviceimpl.generarCSVOportunidadReporte(), MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename= " + new Date() + "--oportunidad-venta.csv")
                    .build();
        } catch (ServerErrorException e) {
            return Response.serverError().build();
        }
    }
}
