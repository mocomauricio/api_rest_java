package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.Restaurante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class RestauranteDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public Restaurante get(Long id) {
        return em.find(Restaurante.class, id);
    }

    public void persist(Restaurante entidad) {
        this.em.persist(entidad);
    }

    public void merge(Restaurante entidad) {
        this.em.merge(entidad);
    }

    public void delete(Long id) {
        this.em.remove(this.em.find(Restaurante.class,id));
    }
    

    @SuppressWarnings("unchecked")
    public List<Restaurante> lista() {
        Query q = em.createQuery("SELECT r FROM Restaurante r");
        return (List<Restaurante>)q.getResultList();
    }
}
