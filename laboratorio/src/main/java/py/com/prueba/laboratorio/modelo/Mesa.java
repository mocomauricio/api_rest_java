/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author galactus
 */
@Entity
@Table(name = "mesas")
public class Mesa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "serial")
    private Long id;
    
    @Column(name = "nombre",length = 250)
    @Basic(optional = false)
    private String nombre;
    
    @Column(name = "posicion",length = 250)
    @Basic(optional = false)
    private String posicion;
    
    @Column(name = "planta")
    @Basic(optional = false)
    private Integer planta;

    @Column(name = "capacidad")
    @Basic(optional = false)
    private Integer capacidad;
    
    /*
    @JoinColumn(name = "restaurante_id",referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Restaurante restaurante;
    */
    @Column(name = "restaurante_id")
    @Basic(optional = false)
    private Long restaurante_id;
    
    public Mesa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getPlanta() {
        return planta;
    }

    public void setPlanta(Integer planta) {
        this.planta = planta;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Long getRestaurante_id() {
        return restaurante_id;
    }

    public void setRestaurante_id(Long restaurante_id) {
        this.restaurante_id = restaurante_id;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + '}';
    }
}
