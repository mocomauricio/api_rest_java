package py.com.prueba.laboratorio.rest;


import py.com.prueba.laboratorio.ejb.ClienteDAO;
import py.com.prueba.laboratorio.modelo.Cliente;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("clientes")
@Consumes("application/json")
@Produces("application/json")
public class ClienteRest {

    @Inject
    ClienteDAO clienteDAO;

    @GET
    @Path("/{pk}")
    public Response obtener(@PathParam("pk") Long pk) {
        return Response.ok(clienteDAO.get(pk))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }
    
    @GET
    @Path("/cedula/{cedula}")
    public Response obtener(@PathParam("cedula") String cedula) {
        return Response.ok(clienteDAO.getClientePorCedula(cedula))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }
    
    @POST
    @Path("/")
    public Response agregar(Cliente cliente) {
        clienteDAO.persist(cliente);
        return Response.ok(cliente)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }

    @PUT
    @Path("/")
    public Response modificar(Cliente cliente) {
        clienteDAO.merge(cliente);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }

    @GET
    @Path("/")
    public Response lista() {
        return Response.ok(clienteDAO.lista())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();
    }
    
    @DELETE
    @Path("/{pk}")
    public Response borrar(@PathParam("pk") Long pk){
        clienteDAO.delete(pk);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "*")
                .header("Access-Control-Allow-Headers", "*")
                .build();

    }
    
    
    @OPTIONS
    @Path("{path : .*}")
    public Response options() {
        return Response.ok("")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                //.header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }
}
