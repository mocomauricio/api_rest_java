package py.com.prueba.laboratorio.rest;


import java.text.ParseException;
import py.com.prueba.laboratorio.ejb.ReservaDAO;
import py.com.prueba.laboratorio.modelo.Reserva;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("reservas")
@Consumes("application/json")
@Produces("application/json")
public class ReservaRest {

    @Inject
    ReservaDAO reservaDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Long pk) {
        return Response.ok(reservaDAO.get(pk))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }
    
    @POST
    @Path("/")
    public Response agregar(Reserva reserva) {
        reservaDAO.persist(reserva);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }

    @PUT
    @Path("/")
    public Response modificar(Reserva reserva) {
        reservaDAO.merge(reserva);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(reservaDAO.lista())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Long pk){
        reservaDAO.delete(pk);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();

    }
    
    
    @GET
    @Path("/restaurante_fecha/{restaurante_id}/{fecha}")
    public Response obtener(@PathParam("restaurante_id") Long restaurante_id, @PathParam("fecha") String fecha) throws ParseException {
        return Response.ok(reservaDAO.getReservasPorRestauranteFecha(restaurante_id,fecha))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }
    
    @GET
    @Path("/restaurante_fecha_cliente/{restaurante_id}/{fecha}/{cliente_id}")
    public Response obtener(@PathParam("restaurante_id") Long restaurante_id, @PathParam("fecha") String fecha, @PathParam("cliente_id") Long cliente_id) throws ParseException {
        return Response.ok(reservaDAO.getReservasPorRestauranteFechaCliente(restaurante_id, fecha, cliente_id))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }
}
