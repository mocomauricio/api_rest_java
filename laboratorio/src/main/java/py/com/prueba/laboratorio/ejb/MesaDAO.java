package py.com.prueba.laboratorio.ejb;

import java.util.ArrayList;
import java.util.Date;
import py.com.prueba.laboratorio.modelo.Mesa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import py.com.prueba.laboratorio.modelo.Reserva;
import py.com.prueba.laboratorio.modelo.Restaurante;

@Stateless
public class MesaDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public Mesa get(Long id) {
        return em.find(Mesa.class, id);
    }

    public void persist(Mesa entidad) {
        this.em.persist(entidad);
    }

    public void merge(Mesa entidad) {
        this.em.merge(entidad);
    }

    public void delete(Long id) {
        this.em.remove(this.em.find(Mesa.class,id));
    }
    

    @SuppressWarnings("unchecked")
    public List<Mesa> lista() {
        Query q = em.createQuery("SELECT m FROM Mesa m");
        return (List<Mesa>)q.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Mesa> getMesasPorRestauranteFechaRango(Long restaurante_id, String fecha, List<String> rango_hora) {
        Query q = em.createQuery("SELECT m FROM Mesa m WHERE m.restaurante_id = :restaurante_id");
        return (List<Mesa>) q
                .setParameter("restaurante_id", restaurante_id)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Mesa> getMesasPorRestaurante(Long restaurante_id) {
        Query q = em.createQuery("SELECT m FROM Mesa m WHERE m.restaurante_id = :restaurante_id");
        return (List<Mesa>) q
                .setParameter("restaurante_id", restaurante_id)
                .getResultList();
    }
    
}


