package py.com.prueba.laboratorio.rest;


import java.util.Date;
import java.util.List;
import py.com.prueba.laboratorio.ejb.MesaDAO;
import py.com.prueba.laboratorio.modelo.Mesa;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("mesas")
@Consumes("application/json")
@Produces("application/json")
public class MesaRest {

    @Inject
    MesaDAO mesaDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Long pk) {
        return Response.ok(mesaDAO.get(pk))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }
    
    @POST
    @Path("/")
    public Response agregar(Mesa mesa) {
        mesaDAO.persist(mesa);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }

    @PUT
    @Path("/")
    public Response modificar(Mesa mesa) {
        mesaDAO.merge(mesa);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(mesaDAO.lista())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Long pk){
        mesaDAO.delete(pk);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }
    
    
    @GET
    @Path("/mesasPorRestauranteFechaRango/{restaurante_id}/{fecha}/{rango_hora}")
    public Response lista(@PathParam("restaurante_id") Long restaurante_id, @PathParam("fecha") String fecha, @PathParam("rango_hora") List<String> rango_hora ) {
        return Response.ok(mesaDAO.getMesasPorRestauranteFechaRango(restaurante_id, fecha, rango_hora))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }

    @GET
    @Path("/mesasPorRestaurante/{restaurante_id}")
    public Response lista(@PathParam("restaurante_id") Long restaurante_id) {
        return Response.ok(mesaDAO.getMesasPorRestaurante(restaurante_id))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                .build();
    }
    
    
}
