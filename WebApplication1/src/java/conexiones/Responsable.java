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
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r")
    , @NamedQuery(name = "Responsable.findById", query = "SELECT r FROM Responsable r WHERE r.id = :id")
    , @NamedQuery(name = "Responsable.findByNombre", query = "SELECT r FROM Responsable r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Responsable.findByApellido", query = "SELECT r FROM Responsable r WHERE r.apellido = :apellido")
    , @NamedQuery(name = "Responsable.findByCorreo", query = "SELECT r FROM Responsable r WHERE r.correo = :correo")
    , @NamedQuery(name = "Responsable.findByTelOfice", query = "SELECT r FROM Responsable r WHERE r.telOfice = :telOfice")
    , @NamedQuery(name = "Responsable.findByAdscripci\u00f3n", query = "SELECT r FROM Responsable r WHERE r.adscripci\u00f3n = :adscripci\u00f3n")})
public class Responsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(length = 50)
    private String nombre;
    @Size(max = 50)
    @Column(length = 50)
    private String apellido;
    @Size(max = 50)
    @Column(length = 50)
    private String correo;
    @Size(max = 50)
    @Column(length = 50)
    private String telOfice;
    @Size(max = 50)
    @Column(length = 50)
    private String adscripción;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public Responsable() {
    }

    public Responsable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelOfice() {
        return telOfice;
    }

    public void setTelOfice(String telOfice) {
        this.telOfice = telOfice;
    }

    public String getAdscripción() {
        return adscripción;
    }

    public void setAdscripción(String adscripción) {
        this.adscripción = adscripción;
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
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexiones.Responsable[ id=" + id + " ]";
    }
    
}
