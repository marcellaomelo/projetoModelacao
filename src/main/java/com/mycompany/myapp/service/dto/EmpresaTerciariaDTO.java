package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.EmpresaTerciaria} entity.
 */
public class EmpresaTerciariaDTO implements Serializable {

    private Long id;

    private String interpreteEmpresaName;

    private LocalDate interpreteEmpresaDataDisponivel;

    private Boolean pedidoInterpreteEmpresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInterpreteEmpresaName() {
        return interpreteEmpresaName;
    }

    public void setInterpreteEmpresaName(String interpreteEmpresaName) {
        this.interpreteEmpresaName = interpreteEmpresaName;
    }

    public LocalDate getInterpreteEmpresaDataDisponivel() {
        return interpreteEmpresaDataDisponivel;
    }

    public void setInterpreteEmpresaDataDisponivel(LocalDate interpreteEmpresaDataDisponivel) {
        this.interpreteEmpresaDataDisponivel = interpreteEmpresaDataDisponivel;
    }

    public Boolean getPedidoInterpreteEmpresa() {
        return pedidoInterpreteEmpresa;
    }

    public void setPedidoInterpreteEmpresa(Boolean pedidoInterpreteEmpresa) {
        this.pedidoInterpreteEmpresa = pedidoInterpreteEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmpresaTerciariaDTO)) {
            return false;
        }

        EmpresaTerciariaDTO empresaTerciariaDTO = (EmpresaTerciariaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, empresaTerciariaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EmpresaTerciariaDTO{" +
            "id=" + getId() +
            ", interpreteEmpresaName='" + getInterpreteEmpresaName() + "'" +
            ", interpreteEmpresaDataDisponivel='" + getInterpreteEmpresaDataDisponivel() + "'" +
            ", pedidoInterpreteEmpresa='" + getPedidoInterpreteEmpresa() + "'" +
            "}";
    }
}
