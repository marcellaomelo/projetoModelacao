package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A PedidoInterprete.
 */
@Entity
@Table(name = "pedido_interprete")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PedidoInterprete implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "local_turistico_pedido")
    private String localTuristicoPedido;

    @Column(name = "cliente_name")
    private String clienteName;

    @Column(name = "cliente_email")
    private String clienteEmail;

    @Column(name = "freelancer_numero_reserva")
    private String freelancerNumeroReserva;

    @Column(name = "empresa_terciaria_numero_reserva")
    private String empresaTerciariaNumeroReserva;

    @Column(name = "preco_reserva")
    private Integer precoReserva;

    @Column(name = "reservar_servico")
    private Boolean reservarServico;

    @Column(name = "confirmacao_reserva")
    private Boolean confirmacaoReserva;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private EmpresaTerciaria empresaTerciaria;

    @ManyToOne
    private EmpresaTerciaria empresaTerciaria;

    @ManyToOne
    private EmpresaTerciaria empresaTerciaria;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PedidoInterprete id(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getDataPedido() {
        return this.dataPedido;
    }

    public PedidoInterprete dataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
        return this;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getLocalTuristicoPedido() {
        return this.localTuristicoPedido;
    }

    public PedidoInterprete localTuristicoPedido(String localTuristicoPedido) {
        this.localTuristicoPedido = localTuristicoPedido;
        return this;
    }

    public void setLocalTuristicoPedido(String localTuristicoPedido) {
        this.localTuristicoPedido = localTuristicoPedido;
    }

    public String getClienteName() {
        return this.clienteName;
    }

    public PedidoInterprete clienteName(String clienteName) {
        this.clienteName = clienteName;
        return this;
    }

    public void setClienteName(String clienteName) {
        this.clienteName = clienteName;
    }

    public String getClienteEmail() {
        return this.clienteEmail;
    }

    public PedidoInterprete clienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
        return this;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getFreelancerNumeroReserva() {
        return this.freelancerNumeroReserva;
    }

    public PedidoInterprete freelancerNumeroReserva(String freelancerNumeroReserva) {
        this.freelancerNumeroReserva = freelancerNumeroReserva;
        return this;
    }

    public void setFreelancerNumeroReserva(String freelancerNumeroReserva) {
        this.freelancerNumeroReserva = freelancerNumeroReserva;
    }

    public String getEmpresaTerciariaNumeroReserva() {
        return this.empresaTerciariaNumeroReserva;
    }

    public PedidoInterprete empresaTerciariaNumeroReserva(String empresaTerciariaNumeroReserva) {
        this.empresaTerciariaNumeroReserva = empresaTerciariaNumeroReserva;
        return this;
    }

    public void setEmpresaTerciariaNumeroReserva(String empresaTerciariaNumeroReserva) {
        this.empresaTerciariaNumeroReserva = empresaTerciariaNumeroReserva;
    }

    public Integer getPrecoReserva() {
        return this.precoReserva;
    }

    public PedidoInterprete precoReserva(Integer precoReserva) {
        this.precoReserva = precoReserva;
        return this;
    }

    public void setPrecoReserva(Integer precoReserva) {
        this.precoReserva = precoReserva;
    }

    public Boolean getReservarServico() {
        return this.reservarServico;
    }

    public PedidoInterprete reservarServico(Boolean reservarServico) {
        this.reservarServico = reservarServico;
        return this;
    }

    public void setReservarServico(Boolean reservarServico) {
        this.reservarServico = reservarServico;
    }

    public Boolean getConfirmacaoReserva() {
        return this.confirmacaoReserva;
    }

    public PedidoInterprete confirmacaoReserva(Boolean confirmacaoReserva) {
        this.confirmacaoReserva = confirmacaoReserva;
        return this;
    }

    public void setConfirmacaoReserva(Boolean confirmacaoReserva) {
        this.confirmacaoReserva = confirmacaoReserva;
    }

    public Freelancer getFreelancer() {
        return this.freelancer;
    }

    public PedidoInterprete freelancer(Freelancer Freelancer) {
        this.setFreelancer(Freelancer);
        return this;
    }

    public void setFreelancer(Freelancer Freelancer) {
        this.freelancer = Freelancer;
    }

    public Freelancer getFreelancer() {
        return this.freelancer;
    }

    public PedidoInterprete freelancer(Freelancer Freelancer) {
        this.setFreelancer(Freelancer);
        return this;
    }

    public void setFreelancer(Freelancer Freelancer) {
        this.freelancer = Freelancer;
    }

    public Freelancer getFreelancer() {
        return this.freelancer;
    }

    public PedidoInterprete freelancer(Freelancer Freelancer) {
        this.setFreelancer(Freelancer);
        return this;
    }

    public void setFreelancer(Freelancer Freelancer) {
        this.freelancer = Freelancer;
    }

    public Freelancer getFreelancer() {
        return this.freelancer;
    }

    public PedidoInterprete freelancer(Freelancer Freelancer) {
        this.setFreelancer(Freelancer);
        return this;
    }

    public void setFreelancer(Freelancer Freelancer) {
        this.freelancer = Freelancer;
    }

    public Freelancer getFreelancer() {
        return this.freelancer;
    }

    public PedidoInterprete freelancer(Freelancer Freelancer) {
        this.setFreelancer(Freelancer);
        return this;
    }

    public void setFreelancer(Freelancer Freelancer) {
        this.freelancer = Freelancer;
    }

    public Freelancer getFreelancer() {
        return this.freelancer;
    }

    public PedidoInterprete freelancer(Freelancer Freelancer) {
        this.setFreelancer(Freelancer);
        return this;
    }

    public void setFreelancer(Freelancer Freelancer) {
        this.freelancer = Freelancer;
    }

    public Freelancer getFreelancer() {
        return this.freelancer;
    }

    public PedidoInterprete freelancer(Freelancer Freelancer) {
        this.setFreelancer(Freelancer);
        return this;
    }

    public void setFreelancer(Freelancer Freelancer) {
        this.freelancer = Freelancer;
    }

    public EmpresaTerciaria getEmpresaTerciaria() {
        return this.empresaTerciaria;
    }

    public PedidoInterprete empresaTerciaria(EmpresaTerciaria EmpresaTerciaria) {
        this.setEmpresaTerciaria(EmpresaTerciaria);
        return this;
    }

    public void setEmpresaTerciaria(EmpresaTerciaria EmpresaTerciaria) {
        this.empresaTerciaria = EmpresaTerciaria;
    }

    public EmpresaTerciaria getEmpresaTerciaria() {
        return this.empresaTerciaria;
    }

    public PedidoInterprete empresaTerciaria(EmpresaTerciaria EmpresaTerciaria) {
        this.setEmpresaTerciaria(EmpresaTerciaria);
        return this;
    }

    public void setEmpresaTerciaria(EmpresaTerciaria EmpresaTerciaria) {
        this.empresaTerciaria = EmpresaTerciaria;
    }

    public EmpresaTerciaria getEmpresaTerciaria() {
        return this.empresaTerciaria;
    }

    public PedidoInterprete empresaTerciaria(EmpresaTerciaria EmpresaTerciaria) {
        this.setEmpresaTerciaria(EmpresaTerciaria);
        return this;
    }

    public void setEmpresaTerciaria(EmpresaTerciaria EmpresaTerciaria) {
        this.empresaTerciaria = EmpresaTerciaria;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PedidoInterprete)) {
            return false;
        }
        return id != null && id.equals(((PedidoInterprete) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PedidoInterprete{" +
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
            "}";
    }
}
