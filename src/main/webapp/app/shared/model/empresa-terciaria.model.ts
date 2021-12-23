export interface IEmpresaTerciaria {
  id?: number;
  interpreteEmpresaName?: string | null;
  interpreteEmpresaDataDisponivel?: Date | null;
  pedidoInterpreteEmpresa?: boolean | null;
}

export class EmpresaTerciaria implements IEmpresaTerciaria {
  constructor(
    public id?: number,
    public interpreteEmpresaName?: string | null,
    public interpreteEmpresaDataDisponivel?: Date | null,
    public pedidoInterpreteEmpresa?: boolean | null
  ) {
    this.pedidoInterpreteEmpresa = this.pedidoInterpreteEmpresa ?? false;
  }
}
