package py.com.prueba.laboratorio.ejb;

import py.com.prueba.laboratorio.modelo.Cliente;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ClienteDAO {
    @PersistenceContext(unitName = "laboratorioPU")
    EntityManager em;

    public Cliente get(Long id) {
        return em.find(Cliente.class, id);
    }

    public void persist(Cliente entidad) {
        this.em.persist(entidad);
    }

    public void merge(Cliente entidad) {
        this.em.merge(entidad);
    }

    public void delete(Long id) {
        this.em.remove(this.em.find(Cliente.class,id));
    }
    

    @SuppressWarnings("unchecked")
    public List<Cliente> lista() {
        Query q = em.createQuery("SELECT c FROM Cliente c");
        return (List<Cliente>)q.getResultList();
    }

    @SuppressWarnings("unchecked")    
    public Cliente getClientePorCedula(String cedula) {
        Query q = em.createQuery("SELECT c FROM Cliente c WHERE c.cedula LIKE :cedula");
        
        return (Cliente) q
                .setParameter("cedula", '%' + cedula + '%')
                .getSingleResult();
    }
}
