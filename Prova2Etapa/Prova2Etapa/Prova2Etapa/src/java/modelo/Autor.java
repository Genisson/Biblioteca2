/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "AUTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findById", query = "SELECT a FROM Autor a WHERE a.id = :id"),
    @NamedQuery(name = "Autor.findByNome", query = "SELECT a FROM Autor a WHERE a.nome = :nome"),
    @NamedQuery(name = "Autor.findByNaturalidade", query = "SELECT a FROM Autor a WHERE a.naturalidade = :naturalidade"),
    @NamedQuery(name = "Autor.findByCodigoObra", query = "SELECT a FROM Autor a WHERE a.codigoObra = :codigoObra")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOME", nullable = false, length = 30)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NATURALIDADE", nullable = false, length = 10)
    private String naturalidade;
    @Column(name = "CODIGO_OBRA")
    private Short codigoObra;

    public Autor() {
    }

    public Autor(Long id) {
        this.id = id;
    }

    public Autor(Long id, String nome, String naturalidade) {
        this.id = id;
        this.nome = nome;
        this.naturalidade = naturalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Short getCodigoObra() {
        return codigoObra;
    }

    public void setCodigoObra(Short codigoObra) {
        this.codigoObra = codigoObra;
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
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Autor[ id=" + id + " ]";
    }
    
}
