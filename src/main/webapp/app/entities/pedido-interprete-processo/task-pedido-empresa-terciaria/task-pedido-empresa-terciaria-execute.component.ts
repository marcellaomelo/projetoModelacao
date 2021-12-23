import { Component, Vue, Inject } from 'vue-property-decorator';

import FreelancerService from '@/entities/freelancer/freelancer.service';
import { IFreelancer } from '@/shared/model/freelancer.model';

import EmpresaTerciariaService from '@/entities/empresa-terciaria/empresa-terciaria.service';
import { IEmpresaTerciaria } from '@/shared/model/empresa-terciaria.model';

import TaskPedidoEmpresaTerciariaService from './task-pedido-empresa-terciaria.service';
import { TaskPedidoEmpresaTerciariaContext } from './task-pedido-empresa-terciaria.model';

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
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskPedidoEmpresaTerciariaExecuteComponent extends Vue {
  private taskPedidoEmpresaTerciariaService: TaskPedidoEmpresaTerciariaService = new TaskPedidoEmpresaTerciariaService();
  private taskContext: TaskPedidoEmpresaTerciariaContext = {};

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
    this.taskPedidoEmpresaTerciariaService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskPedidoEmpresaTerciariaService.complete(this.taskContext).then(res => {
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
