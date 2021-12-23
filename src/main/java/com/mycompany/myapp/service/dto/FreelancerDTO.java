package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.Freelancer} entity.
 */
public class FreelancerDTO implements Serializable {

    private Long id;

    private String freelancerName;

    private LocalDate freelancerDataDisponivel;

    private Boolean existeFreelancerDisponivel;

    private Boolean existeMaisQueUmFreelancerDisponivel;

    private Integer anosExperienciaFreelancer;

    private String freelancerEscolhido;

    private String freelancerUnicoEscolhido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFreelancerName() {
        return freelancerName;
    }

    public void setFreelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
    }

    public LocalDate getFreelancerDataDisponivel() {
        return freelancerDataDisponivel;
    }

    public void setFreelancerDataDisponivel(LocalDate freelancerDataDisponivel) {
        this.freelancerDataDisponivel = freelancerDataDisponivel;
    }

    public Boolean getExisteFreelancerDisponivel() {
        return existeFreelancerDisponivel;
    }

    public void setExisteFreelancerDisponivel(Boolean existeFreelancerDisponivel) {
        this.existeFreelancerDisponivel = existeFreelancerDisponivel;
    }

    public Boolean getExisteMaisQueUmFreelancerDisponivel() {
        return existeMaisQueUmFreelancerDisponivel;
    }

    public void setExisteMaisQueUmFreelancerDisponivel(Boolean existeMaisQueUmFreelancerDisponivel) {
        this.existeMaisQueUmFreelancerDisponivel = existeMaisQueUmFreelancerDisponivel;
    }

    public Integer getAnosExperienciaFreelancer() {
        return anosExperienciaFreelancer;
    }

    public void setAnosExperienciaFreelancer(Integer anosExperienciaFreelancer) {
        this.anosExperienciaFreelancer = anosExperienciaFreelancer;
    }

    public String getFreelancerEscolhido() {
        return freelancerEscolhido;
    }

    public void setFreelancerEscolhido(String freelancerEscolhido) {
        this.freelancerEscolhido = freelancerEscolhido;
    }

    public String getFreelancerUnicoEscolhido() {
        return freelancerUnicoEscolhido;
    }

    public void setFreelancerUnicoEscolhido(String freelancerUnicoEscolhido) {
        this.freelancerUnicoEscolhido = freelancerUnicoEscolhido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FreelancerDTO)) {
            return false;
        }

        FreelancerDTO freelancerDTO = (FreelancerDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, freelancerDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FreelancerDTO{" +
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
