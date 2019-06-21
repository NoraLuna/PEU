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
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p")
    , @NamedQuery(name = "Preguntas.findById", query = "SELECT p FROM Preguntas p WHERE p.id = :id")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String sigEtapa;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String nuevoProyecto;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String desAeroEspacial;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String normativaEspacial;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String proyectoAnterior;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String area;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String otraArea;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Proyecto idProyecto;

    public Preguntas() {
    }

    public Preguntas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigEtapa() {
        return sigEtapa;
    }

    public void setSigEtapa(String sigEtapa) {
        this.sigEtapa = sigEtapa;
    }

    public String getNuevoProyecto() {
        return nuevoProyecto;
    }

    public void setNuevoProyecto(String nuevoProyecto) {
        this.nuevoProyecto = nuevoProyecto;
    }

    public String getDesAeroEspacial() {
        return desAeroEspacial;
    }

    public void setDesAeroEspacial(String desAeroEspacial) {
        this.desAeroEspacial = desAeroEspacial;
    }

    public String getNormativaEspacial() {
        return normativaEspacial;
    }

    public void setNormativaEspacial(String normativaEspacial) {
        this.normativaEspacial = normativaEspacial;
    }

    public String getProyectoAnterior() {
        return proyectoAnterior;
    }

    public void setProyectoAnterior(String proyectoAnterior) {
        this.proyectoAnterior = proyectoAnterior;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOtraArea() {
        return otraArea;
    }

    public void setOtraArea(String otraArea) {
        this.otraArea = otraArea;
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
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexiones.Preguntas[ id=" + id + " ]";
    }
    
}
