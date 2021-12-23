import { IFreelancer } from '@/shared/model/freelancer.model';
import { IEmpresaTerciaria } from '@/shared/model/empresa-terciaria.model';

export interface IPedidoInterprete {
  id?: number;
  dataPedido?: Date | null;
  localTuristicoPedido?: string | null;
  clienteName?: string | null;
  clienteEmail?: string | null;
  freelancerNumeroReserva?: string | null;
  empresaTerciariaNumeroReserva?: string | null;
  precoReserva?: number | null;
  reservarServico?: boolean | null;
  confirmacaoReserva?: boolean | null;
  freelancer?: IFreelancer | null;
  freelancer?: IFreelancer | null;
  freelancer?: IFreelancer | null;
  freelancer?: IFreelancer | null;
  freelancer?: IFreelancer | null;
  freelancer?: IFreelancer | null;
  freelancer?: IFreelancer | null;
  empresaTerciaria?: IEmpresaTerciaria | null;
  empresaTerciaria?: IEmpresaTerciaria | null;
  empresaTerciaria?: IEmpresaTerciaria | null;
}

export class PedidoInterprete implements IPedidoInterprete {
  constructor(
    public id?: number,
    public dataPedido?: Date | null,
    public localTuristicoPedido?: string | null,
    public clienteName?: string | null,
    public clienteEmail?: string | null,
    public freelancerNumeroReserva?: string | null,
    public empresaTerciariaNumeroReserva?: string | null,
    public precoReserva?: number | null,
    public reservarServico?: boolean | null,
    public confirmacaoReserva?: boolean | null,
    public freelancer?: IFreelancer | null,
    public freelancer?: IFreelancer | null,
    public freelancer?: IFreelancer | null,
    public freelancer?: IFreelancer | null,
    public freelancer?: IFreelancer | null,
    public freelancer?: IFreelancer | null,
    public freelancer?: IFreelancer | null,
    public empresaTerciaria?: IEmpresaTerciaria | null,
    public empresaTerciaria?: IEmpresaTerciaria | null,
    public empresaTerciaria?: IEmpresaTerciaria | null
  ) {
    this.reservarServico = this.reservarServico ?? false;
    this.confirmacaoReserva = this.confirmacaoReserva ?? false;
  }
}
