export interface IFreelancer {
  id?: number;
  freelancerName?: string | null;
  freelancerDataDisponivel?: Date | null;
  existeFreelancerDisponivel?: boolean | null;
  existeMaisQueUmFreelancerDisponivel?: boolean | null;
  anosExperienciaFreelancer?: number | null;
  freelancerEscolhido?: string | null;
  freelancerUnicoEscolhido?: string | null;
}

export class Freelancer implements IFreelancer {
  constructor(
    public id?: number,
    public freelancerName?: string | null,
    public freelancerDataDisponivel?: Date | null,
    public existeFreelancerDisponivel?: boolean | null,
    public existeMaisQueUmFreelancerDisponivel?: boolean | null,
    public anosExperienciaFreelancer?: number | null,
    public freelancerEscolhido?: string | null,
    public freelancerUnicoEscolhido?: string | null
  ) {
    this.existeFreelancerDisponivel = this.existeFreelancerDisponivel ?? false;
    this.existeMaisQueUmFreelancerDisponivel = this.existeMaisQueUmFreelancerDisponivel ?? false;
  }
}
