package org.co.mineria.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.co.mineria.dto.PropuestaDetallesDTO;
import org.co.mineria.services.impl.PropuestaServiceImpl;

import java.util.logging.Logger;

@Path("/api/propuesta")
public class PropuestaController {

    private final Logger LOG = Logger.getLogger(PropuestaController.class.getName());
    @Inject
    PropuestaServiceImpl propuestaService;

    //obtener los detalles de la propuesta
    @GET
    @Path("/{id}")
    public PropuestaDetallesDTO findDetallesPropuesta(long id) {

        LOG.info("Inicia buscando propuesta por id: {}" + id);
        return propuestaService.findFullPropuesta(id);
    }

    //crear una nueva respuesta
    @POST
    @Path("/crear")
    public Response crearPropuesta(PropuestaDetallesDTO propuestaDetallesDTO) {

        LOG.info("Inicia creando propuesta: " + propuestaDetallesDTO);
        try {
            propuestaService.crearPropuesta(propuestaDetallesDTO);

            LOG.info("Finaliza creando propuesta: " + propuestaDetallesDTO);
            return Response.ok().build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/eliminar/{id}")
    public Response eliminarPropuesta(long id) {

        LOG.info("Inicia eliminando propuesta por id: {}" + id);
        try {
            propuestaService.eliminarPropuesta(id);

            LOG.info("Finaliza eliminando propuesta por id: {}" + id);
            return Response.ok().build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
