package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.PedidoInterprete} entity.
 */
public class PedidoInterpreteDTO implements Serializable {

    private Long id;

    private LocalDate dataPedido;

    private String localTuristicoPedido;

    private String clienteName;

    private String clienteEmail;

    private String freelancerNumeroReserva;

    private String empresaTerciariaNumeroReserva;

    private Integer precoReserva;

    private Boolean reservarServico;

    private Boolean confirmacaoReserva;

    private FreelancerDTO freelancer;

    private FreelancerDTO freelancer;

    private FreelancerDTO freelancer;

    private FreelancerDTO freelancer;

    private FreelancerDTO freelancer;

    private FreelancerDTO freelancer;

    private FreelancerDTO freelancer;

    private EmpresaTerciariaDTO empresaTerciaria;

    private EmpresaTerciariaDTO empresaTerciaria;

    private EmpresaTerciariaDTO empresaTerciaria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getLocalTuristicoPedido() {
        return localTuristicoPedido;
    }

    public void setLocalTuristicoPedido(String localTuristicoPedido) {
        this.localTuristicoPedido = localTuristicoPedido;
    }

    public String getClienteName() {
        return clienteName;
    }

    public void setClienteName(String clienteName) {
        this.clienteName = clienteName;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getFreelancerNumeroReserva() {
        return freelancerNumeroReserva;
    }

    public void setFreelancerNumeroReserva(String freelancerNumeroReserva) {
        this.freelancerNumeroReserva = freelancerNumeroReserva;
    }

    public String getEmpresaTerciariaNumeroReserva() {
        return empresaTerciariaNumeroReserva;
    }

    public void setEmpresaTerciariaNumeroReserva(String empresaTerciariaNumeroReserva) {
        this.empresaTerciariaNumeroReserva = empresaTerciariaNumeroReserva;
    }

    public Integer getPrecoReserva() {
        return precoReserva;
    }

    public void setPrecoReserva(Integer precoReserva) {
        this.precoReserva = precoReserva;
    }

    public Boolean getReservarServico() {
        return reservarServico;
    }

    public void setReservarServico(Boolean reservarServico) {
        this.reservarServico = reservarServico;
    }

    public Boolean getConfirmacaoReserva() {
        return confirmacaoReserva;
    }

    public void setConfirmacaoReserva(Boolean confirmacaoReserva) {
        this.confirmacaoReserva = confirmacaoReserva;
    }

    public FreelancerDTO getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerDTO freelancer) {
        this.freelancer = freelancer;
    }

    public FreelancerDTO getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerDTO freelancer) {
        this.freelancer = freelancer;
    }

    public FreelancerDTO getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerDTO freelancer) {
        this.freelancer = freelancer;
    }

    public FreelancerDTO getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerDTO freelancer) {
        this.freelancer = freelancer;
    }

    public FreelancerDTO getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerDTO freelancer) {
        this.freelancer = freelancer;
    }

    public FreelancerDTO getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerDTO freelancer) {
        this.freelancer = freelancer;
    }

    public FreelancerDTO getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(FreelancerDTO freelancer) {
        this.freelancer = freelancer;
    }

    public EmpresaTerciariaDTO getEmpresaTerciaria() {
        return empresaTerciaria;
    }

    public void setEmpresaTerciaria(EmpresaTerciariaDTO empresaTerciaria) {
        this.empresaTerciaria = empresaTerciaria;
    }

    public EmpresaTerciariaDTO getEmpresaTerciaria() {
        return empresaTerciaria;
    }

    public void setEmpresaTerciaria(EmpresaTerciariaDTO empresaTerciaria) {
        this.empresaTerciaria = empresaTerciaria;
    }

    public EmpresaTerciariaDTO getEmpresaTerciaria() {
        return empresaTerciaria;
    }

    public void setEmpresaTerciaria(EmpresaTerciariaDTO empresaTerciaria) {
        this.empresaTerciaria = empresaTerciaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedidoInterpreteDTO)) {
            return false;
        }

        PedidoInterpreteDTO pedidoInterpreteDTO = (PedidoInterpreteDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pedidoInterpreteDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedidoInterpreteDTO{" +
            "id=" + getId() +
            ", dataPedido='" + getDataPedido() + "'" +
            ", localTuristicoPedido='" + getLocalTuristicoPedido() + "'" +
            ", clienteName='" + getClienteName() + "'" +
            ", clienteEmail='" + getClienteEmail() + "'" +
            ", freelancerNumeroReserva='" + getFreelancerNumeroReserva() + "'" +
            ", empresaTerciariaNumeroReserva='" + getEmpresaTerciariaNumeroReserva() + "'" +
            ", precoReserva=" + getPrecoReserva() +
            ", reservarServico='" + getReservarServico() + "'" +
            ", confirmacaoReserva='" + getConfirmacaoReserva() + "'" +
            ", freelancer=" + getFreelancer() +
            ", freelancer=" + getFreelancer() +
            ", freelancer=" + getFreelancer() +
            ", freelancer=" + getFreelancer() +
            ", freelancer=" + getFreelancer() +
            ", freelancer=" + getFreelancer() +
            ", freelancer=" + getFreelancer() +
            ", empresaTerciaria=" + getEmpresaTerciaria() +
            ", empresaTerciaria=" + getEmpresaTerciaria() +
            ", empresaTerciaria=" + getEmpresaTerciaria() +
            "}";
    }
}
