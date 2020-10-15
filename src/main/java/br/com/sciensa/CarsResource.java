package br.com.sciensa;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.panache.common.Sort;

@Path("/cars")
@ApplicationScoped
@Consumes("application/json")
@Produces("application/json")
public class CarsResource {

    @GET
    public List<Cars> hello() {
        return Cars.listAll(Sort.by("marca"));
    }

    @POST
    @Transactional
    public Response storeCar(Cars cars) {
        cars.persist();
        return Response.ok(cars).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Cars updateCar(@PathParam Long id,Cars cars){
        Cars car = Cars.findById(id);
        car.marca = cars.marca;
        car.persist();
        return car;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteCar(@PathParam Long id){
        Cars.deleteById(id);
        return Response.status(204).build();
    }
}