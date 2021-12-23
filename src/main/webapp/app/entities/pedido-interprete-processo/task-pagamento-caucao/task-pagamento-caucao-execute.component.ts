import { Component, Vue, Inject } from 'vue-property-decorator';

import FreelancerService from '@/entities/freelancer/freelancer.service';
import { IFreelancer } from '@/shared/model/freelancer.model';

import EmpresaTerciariaService from '@/entities/empresa-terciaria/empresa-terciaria.service';
import { IEmpresaTerciaria } from '@/shared/model/empresa-terciaria.model';

import TaskPagamentoCaucaoService from './task-pagamento-caucao.service';
import { TaskPagamentoCaucaoContext } from './task-pagamento-caucao.model';

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
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskPagamentoCaucaoExecuteComponent extends Vue {
  private taskPagamentoCaucaoService: TaskPagamentoCaucaoService = new TaskPagamentoCaucaoService();
  private taskContext: TaskPagamentoCaucaoContext = {};

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
    this.taskPagamentoCaucaoService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskPagamentoCaucaoService.complete(this.taskContext).then(res => {
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
