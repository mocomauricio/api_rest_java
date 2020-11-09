package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.RestauranteDAO;
import py.com.prueba.laboratorio.modelo.Restaurante;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("restaurantes")
@Consumes("application/json")
@Produces("application/json")
public class RestauranteRest {

    @Inject
    RestauranteDAO restauranteDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Long pk) {
        return Response.ok(restauranteDAO.get(pk))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }
    
    @POST
    @Path("/")
    public Response agregar(Restaurante restaurante) {
        restauranteDAO.persist(restaurante);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }

    @PUT
    @Path("/")
    public Response modificar(Restaurante restaurante) {
        restauranteDAO.merge(restaurante);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(restauranteDAO.lista())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Long pk){
        restauranteDAO.delete(pk);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();

    }
    
}
