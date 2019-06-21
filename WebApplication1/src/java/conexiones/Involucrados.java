/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ras_05
 */
@Entity
@Table(catalog = "proyectos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Involucrados.findAll", query = "SELECT i FROM Involucrados i")
    , @NamedQuery(name = "Involucrados.findById", query = "SELECT i FROM Involucrados i WHERE i.id = :id")
    , @NamedQuery(name = "Involucrados.findByTipoEstudiante", query = "SELECT i FROM Involucrados i WHERE i.tipoEstudiante = :tipoEstudiante")
    , @NamedQuery(name = "Involucrados.findByCantidad", query = "SELECT i FROM Involucrados i WHERE i.cantidad = :cantidad")})
public class Involucrados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(length = 50)
    private String tipoEstudiante;
    private Integer cantidad;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public Involucrados() {
    }

    public Involucrados(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoEstudiante() {
        return tipoEstudiante;
    }

    public void setTipoEstudiante(String tipoEstudiante) {
        this.tipoEstudiante = tipoEstudiante;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Proyecto getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Proyecto idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Involucrados)) {
            return false;
        }
        Involucrados other = (Involucrados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexiones.Involucrados[ id=" + id + " ]";
    }
    
}
