package org.co.mineria.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.co.mineria.dto.PriceDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/last")
@RegisterRestClient
@ApplicationScoped
public interface PriceClient {

    @GET
    @Path("/{pair}")
    PriceDTO getPriceByPair(@PathParam("pair") String pair);
}
