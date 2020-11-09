/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.prueba.laboratorio.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.json.bind.annotation.JsonbDateFormat;
/**
 *
 * @author galactus
 */

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "serial")
    private Long id;
    /*
    @JoinColumn(name = "restaurante_id",referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Restaurante restaurante;
    
    @JoinColumn(name = "mesa_id",referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Mesa mesa;
    
    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    @ManyToOne(fetch=FetchType.EAGER)
    private Cliente cliente;
    */
    @Column(name = "restaurante_id")
    @Basic(optional = false)
    private Long restaurante_id;
    
    @Column(name = "mesa_id")
    @Basic(optional = false)
    private Long mesa_id;
    
    @Column(name = "cliente_id")
    @Basic(optional = false)
    private Long cliente_id;
    
    @Column(name = "fecha")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    //@JsonbDateFormat(value = "yyyy-mm-dd")
    private Date fecha;
    
    @Column(name = "rango_hora",length = 250)
    @Basic(optional = false)
    private String rango_hora;
    
    @Column(name = "cantidad_solicitada")
    @Basic(optional = false)
    private Integer cantidad_solicitada;

    public Reserva() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurante_id() {
        return restaurante_id;
    }

    public void setRestaurante_id(Long restaurante_id) {
        this.restaurante_id = restaurante_id;
    }

    public Long getMesa_id() {
        return mesa_id;
    }

    public void setMesa_id(Long mesa_id) {
        this.mesa_id = mesa_id;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRango_hora() {
        return rango_hora;
    }

    public void setRango_hora(String rango_hora) {
        this.rango_hora = rango_hora;
    }

    public Integer getCantidad_solicitada() {
        return cantidad_solicitada;
    }

    public void setCantidad_solicitada(Integer cantidad_solicitada) {
        this.cantidad_solicitada = cantidad_solicitada;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + '}';
    }
}
