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
import javax.persistence.Lob;
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
    @NamedQuery(name = "Instituciones.findAll", query = "SELECT i FROM Instituciones i")
    , @NamedQuery(name = "Instituciones.findById", query = "SELECT i FROM Instituciones i WHERE i.id = :id")})
public class Instituciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String eAParticipantes;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String colaboracion;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public Instituciones() {
    }

    public Instituciones(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEAParticipantes() {
        return eAParticipantes;
    }

    public void setEAParticipantes(String eAParticipantes) {
        this.eAParticipantes = eAParticipantes;
    }

    public String getColaboracion() {
        return colaboracion;
    }

    public void setColaboracion(String colaboracion) {
        this.colaboracion = colaboracion;
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
        if (!(object instanceof Instituciones)) {
            return false;
        }
        Instituciones other = (Instituciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexiones.Instituciones[ id=" + id + " ]";
    }
    
}
