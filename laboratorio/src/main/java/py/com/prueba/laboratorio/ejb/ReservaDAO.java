package py.com.prueba.laboratorio.ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import py.com.prueba.laboratorio.modelo.Reserva;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import py.com.prueba.laboratorio.modelo.Cliente;
import py.com.prueba.laboratorio.modelo.Restaurante;

@Stateless
public class ReservaDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public Reserva get(Long id) {
        return em.find(Reserva.class, id);
    }

    public void persist(Reserva entidad) {
        this.em.persist(entidad);
    }

    public void merge(Reserva entidad) {
        this.em.merge(entidad);
    }

    public void delete(Long id) {
        this.em.remove(this.em.find(Reserva.class,id));
    }
    

    @SuppressWarnings("unchecked")
    public List<Reserva> lista() {
        Query q = em.createQuery("SELECT r FROM Reserva r");
        return (List<Reserva>)q.getResultList();
    }
    
    
    @SuppressWarnings("unchecked")    
    public List<Reserva> getReservasPorRestauranteFecha(Long restaurante_id, String fecha) throws ParseException {
        Query q = em.createQuery("SELECT r FROM Reserva r WHERE r.restaurante_id = :restaurante_id AND r.fecha = :fecha");
        
        Restaurante restaurante = new Restaurante();
        restaurante.setId(restaurante_id);

        Date mifecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
       
        return (List<Reserva>) q
                .setParameter("restaurante_id", restaurante_id)
                .setParameter("fecha", mifecha)     
                .getResultList();
    }
    
    @SuppressWarnings("unchecked")    
    public List<Reserva> getReservasPorRestauranteFechaCliente(Long restaurante_id, String fecha, Long cliente_id) throws ParseException {
        Query q = em.createQuery("SELECT r FROM Reserva r WHERE r.restaurante_id = :restaurante_id AND r.fecha = :fecha AND r.cliente_id = :cliente_id");
        /*
        Restaurante restaurante = new Restaurante();
        restaurante.setId(restaurante_id);
        */
        Date mifecha = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        /*
        Cliente cliente = new Cliente();
        cliente.setId(cliente_id);
        */
        return (List<Reserva>) q
                .setParameter("restaurante_id", restaurante_id)
                .setParameter("fecha", mifecha)
                .setParameter("cliente_id", cliente_id)       
                .getResultList();
    }
    
}
