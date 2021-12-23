package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Freelancer.
 */
@Entity
@Table(name = "freelancer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Freelancer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "freelancer_name")
    private String freelancerName;

    @Column(name = "freelancer_data_disponivel")
    private LocalDate freelancerDataDisponivel;

    @Column(name = "existe_freelancer_disponivel")
    private Boolean existeFreelancerDisponivel;

    @Column(name = "existe_mais_que_um_freelancer_disponivel")
    private Boolean existeMaisQueUmFreelancerDisponivel;

    @Column(name = "anos_experiencia_freelancer")
    private Integer anosExperienciaFreelancer;

    @Column(name = "freelancer_escolhido")
    private String freelancerEscolhido;

    @Column(name = "freelancer_unico_escolhido")
    private String freelancerUnicoEscolhido;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Freelancer id(Long id) {
        this.id = id;
        return this;
    }

    public String getFreelancerName() {
        return this.freelancerName;
    }

    public Freelancer freelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
        return this;
    }

    public void setFreelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
    }

    public LocalDate getFreelancerDataDisponivel() {
        return this.freelancerDataDisponivel;
    }

    public Freelancer freelancerDataDisponivel(LocalDate freelancerDataDisponivel) {
        this.freelancerDataDisponivel = freelancerDataDisponivel;
        return this;
    }

    public void setFreelancerDataDisponivel(LocalDate freelancerDataDisponivel) {
        this.freelancerDataDisponivel = freelancerDataDisponivel;
    }

    public Boolean getExisteFreelancerDisponivel() {
        return this.existeFreelancerDisponivel;
    }

    public Freelancer existeFreelancerDisponivel(Boolean existeFreelancerDisponivel) {
        this.existeFreelancerDisponivel = existeFreelancerDisponivel;
        return this;
    }

    public void setExisteFreelancerDisponivel(Boolean existeFreelancerDisponivel) {
        this.existeFreelancerDisponivel = existeFreelancerDisponivel;
    }

    public Boolean getExisteMaisQueUmFreelancerDisponivel() {
        return this.existeMaisQueUmFreelancerDisponivel;
    }

    public Freelancer existeMaisQueUmFreelancerDisponivel(Boolean existeMaisQueUmFreelancerDisponivel) {
        this.existeMaisQueUmFreelancerDisponivel = existeMaisQueUmFreelancerDisponivel;
        return this;
    }

    public void setExisteMaisQueUmFreelancerDisponivel(Boolean existeMaisQueUmFreelancerDisponivel) {
        this.existeMaisQueUmFreelancerDisponivel = existeMaisQueUmFreelancerDisponivel;
    }

    public Integer getAnosExperienciaFreelancer() {
        return this.anosExperienciaFreelancer;
    }

    public Freelancer anosExperienciaFreelancer(Integer anosExperienciaFreelancer) {
        this.anosExperienciaFreelancer = anosExperienciaFreelancer;
        return this;
    }

    public void setAnosExperienciaFreelancer(Integer anosExperienciaFreelancer) {
        this.anosExperienciaFreelancer = anosExperienciaFreelancer;
    }

    public String getFreelancerEscolhido() {
        return this.freelancerEscolhido;
    }

    public Freelancer freelancerEscolhido(String freelancerEscolhido) {
        this.freelancerEscolhido = freelancerEscolhido;
        return this;
    }

    public void setFreelancerEscolhido(String freelancerEscolhido) {
        this.freelancerEscolhido = freelancerEscolhido;
    }

    public String getFreelancerUnicoEscolhido() {
        return this.freelancerUnicoEscolhido;
    }

    public Freelancer freelancerUnicoEscolhido(String freelancerUnicoEscolhido) {
        this.freelancerUnicoEscolhido = freelancerUnicoEscolhido;
        return this;
    }

    public void setFreelancerUnicoEscolhido(String freelancerUnicoEscolhido) {
        this.freelancerUnicoEscolhido = freelancerUnicoEscolhido;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Freelancer)) {
            return false;
        }
        return id != null && id.equals(((Freelancer) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Freelancer{" +
            "id=" + getId() +
            ", freelancerName='" + getFreelancerName() + "'" +
            ", freelancerDataDisponivel='" + getFreelancerDataDisponivel() + "'" +
            ", existeFreelancerDisponivel='" + getExisteFreelancerDisponivel() + "'" +
            ", existeMaisQueUmFreelancerDisponivel='" + getExisteMaisQueUmFreelancerDisponivel() + "'" +
            ", anosExperienciaFreelancer=" + getAnosExperienciaFreelancer() +
            ", freelancerEscolhido='" + getFreelancerEscolhido() + "'" +
            ", freelancerUnicoEscolhido='" + getFreelancerUnicoEscolhido() + "'" +
            "}";
    }
}
