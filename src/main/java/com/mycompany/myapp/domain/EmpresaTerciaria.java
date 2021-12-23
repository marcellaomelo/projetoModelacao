package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A EmpresaTerciaria.
 */
@Entity
@Table(name = "empresa_terciaria")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EmpresaTerciaria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "interprete_empresa_name")
    private String interpreteEmpresaName;

    @Column(name = "interprete_empresa_data_disponivel")
    private LocalDate interpreteEmpresaDataDisponivel;

    @Column(name = "pedido_interprete_empresa")
    private Boolean pedidoInterpreteEmpresa;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EmpresaTerciaria id(Long id) {
        this.id = id;
        return this;
    }

    public String getInterpreteEmpresaName() {
        return this.interpreteEmpresaName;
    }

    public EmpresaTerciaria interpreteEmpresaName(String interpreteEmpresaName) {
        this.interpreteEmpresaName = interpreteEmpresaName;
        return this;
    }

    public void setInterpreteEmpresaName(String interpreteEmpresaName) {
        this.interpreteEmpresaName = interpreteEmpresaName;
    }

    public LocalDate getInterpreteEmpresaDataDisponivel() {
        return this.interpreteEmpresaDataDisponivel;
    }

    public EmpresaTerciaria interpreteEmpresaDataDisponivel(LocalDate interpreteEmpresaDataDisponivel) {
        this.interpreteEmpresaDataDisponivel = interpreteEmpresaDataDisponivel;
        return this;
    }

    public void setInterpreteEmpresaDataDisponivel(LocalDate interpreteEmpresaDataDisponivel) {
        this.interpreteEmpresaDataDisponivel = interpreteEmpresaDataDisponivel;
    }

    public Boolean getPedidoInterpreteEmpresa() {
        return this.pedidoInterpreteEmpresa;
    }

    public EmpresaTerciaria pedidoInterpreteEmpresa(Boolean pedidoInterpreteEmpresa) {
        this.pedidoInterpreteEmpresa = pedidoInterpreteEmpresa;
        return this;
    }

    public void setPedidoInterpreteEmpresa(Boolean pedidoInterpreteEmpresa) {
        this.pedidoInterpreteEmpresa = pedidoInterpreteEmpresa;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmpresaTerciaria)) {
            return false;
        }
        return id != null && id.equals(((EmpresaTerciaria) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmpresaTerciaria{" +
            "id=" + getId() +
            ", interpreteEmpresaName='" + getInterpreteEmpresaName() + "'" +
            ", interpreteEmpresaDataDisponivel='" + getInterpreteEmpresaDataDisponivel() + "'" +
            ", pedidoInterpreteEmpresa='" + getPedidoInterpreteEmpresa() + "'" +
            "}";
    }
}
