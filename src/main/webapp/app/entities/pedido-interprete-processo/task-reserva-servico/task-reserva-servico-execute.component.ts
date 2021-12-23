import { Component, Vue, Inject } from 'vue-property-decorator';

import FreelancerService from '@/entities/freelancer/freelancer.service';
import { IFreelancer } from '@/shared/model/freelancer.model';

import EmpresaTerciariaService from '@/entities/empresa-terciaria/empresa-terciaria.service';
import { IEmpresaTerciaria } from '@/shared/model/empresa-terciaria.model';

import TaskReservaServicoService from './task-reserva-servico.service';
import { TaskReservaServicoContext } from './task-reserva-servico.model';

const validations: any = {
  taskContext: {
    pedidoInterpreteProcesso: {
      pedidoInterprete: {
        dataPedido: {},
        localTuristicoPedido: {},
        clienteName: {},
        clienteEmail: {},
        freelancerNumeroReserva: {},
        empresaTerciariaNumeroReserva: {},
        precoReserva: {},
        reservarServico: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskReservaServicoExecuteComponent extends Vue {
  private taskReservaServicoService: TaskReservaServicoService = new TaskReservaServicoService();
  private taskContext: TaskReservaServicoContext = {};

  @Inject('freelancerService') private freelancerService: () => FreelancerService;

  public freelancers: IFreelancer[] = [];

  @Inject('EmpresaTerciariaService') private EmpresaTerciariaService: () => EmpresaTerciariaService;

  public EmpresaTerciarias: IEmpresaTerciaria[] = [];
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
      vm.initRelationships();
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskReservaServicoService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskReservaServicoService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {
    this.freelancerService()
      .retrieve()
      .then(res => {
        this.freelancers = res.data;
      });
    this.EmpresaTerciariaService()
      .retrieve()
      .then(res => {
        this.EmpresaTerciarias = res.data;
      });
  }
}
