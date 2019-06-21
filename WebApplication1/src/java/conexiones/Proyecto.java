/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexiones;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ras_05
 */
@Entity
@Table(catalog = "proyectos", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findById", query = "SELECT p FROM Proyecto p WHERE p.id = :id")
    , @NamedQuery(name = "Proyecto.findByMarcaTemporal", query = "SELECT p FROM Proyecto p WHERE p.marcaTemporal = :marcaTemporal")
    , @NamedQuery(name = "Proyecto.findByMonto", query = "SELECT p FROM Proyecto p WHERE p.monto = :monto")
    , @NamedQuery(name = "Proyecto.findByFechaFin", query = "SELECT p FROM Proyecto p WHERE p.fechaFin = :fechaFin")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Lob
    @Size(max = 65535)
    @Column(name = "nombre_proyecto", length = 65535)
    private String nombreProyecto;
    @Column(name = "marca_temporal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcaTemporal;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String resumen;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String tipo;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String etapa;
    private Integer monto;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String producto;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String logros;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String colaboradores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private Collection<Instituciones> institucionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private Collection<Responsable> responsableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private Collection<Preguntas> preguntasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProyecto")
    private Collection<Involucrados> involucradosCollection;

    public Proyecto() {
    }

    public Proyecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Date getMarcaTemporal() {
        return marcaTemporal;
    }

    public void setMarcaTemporal(Date marcaTemporal) {
        this.marcaTemporal = marcaTemporal;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getLogros() {
        return logros;
    }

    public void setLogros(String logros) {
        this.logros = logros;
    }

    public String getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(String colaboradores) {
        this.colaboradores = colaboradores;
    }

    @XmlTransient
    public Collection<Instituciones> getInstitucionesCollection() {
        return institucionesCollection;
    }

    public void setInstitucionesCollection(Collection<Instituciones> institucionesCollection) {
        this.institucionesCollection = institucionesCollection;
    }

    @XmlTransient
    public Collection<Responsable> getResponsableCollection() {
        return responsableCollection;
    }

    public void setResponsableCollection(Collection<Responsable> responsableCollection) {
        this.responsableCollection = responsableCollection;
    }

    @XmlTransient
    public Collection<Preguntas> getPreguntasCollection() {
        return preguntasCollection;
    }

    public void setPreguntasCollection(Collection<Preguntas> preguntasCollection) {
        this.preguntasCollection = preguntasCollection;
    }

    @XmlTransient
    public Collection<Involucrados> getInvolucradosCollection() {
        return involucradosCollection;
    }

    public void setInvolucradosCollection(Collection<Involucrados> involucradosCollection) {
        this.involucradosCollection = involucradosCollection;
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
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "conexiones.Proyecto[ id=" + id + " ]";
    }
    
}
