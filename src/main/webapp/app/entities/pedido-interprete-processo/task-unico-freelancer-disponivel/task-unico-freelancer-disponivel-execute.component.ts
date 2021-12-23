import { Component, Vue, Inject } from 'vue-property-decorator';

import FreelancerService from '@/entities/freelancer/freelancer.service';
import { IFreelancer } from '@/shared/model/freelancer.model';

import TaskUnicoFreelancerDisponivelService from './task-unico-freelancer-disponivel.service';
import { TaskUnicoFreelancerDisponivelContext } from './task-unico-freelancer-disponivel.model';

const validations: any = {
  taskContext: {
    pedidoInterpreteProcesso: {
      pedidoInterprete: {
        dataPedido: {},
        localTuristicoPedido: {},
        clienteName: {},
        clienteEmail: {},
        freelancerNumeroReserva: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskUnicoFreelancerDisponivelExecuteComponent extends Vue {
  private taskUnicoFreelancerDisponivelService: TaskUnicoFreelancerDisponivelService = new TaskUnicoFreelancerDisponivelService();
  private taskContext: TaskUnicoFreelancerDisponivelContext = {};

  @Inject('freelancerService') private freelancerService: () => FreelancerService;

  public freelancers: IFreelancer[] = [];
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
    this.taskUnicoFreelancerDisponivelService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskUnicoFreelancerDisponivelService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {
    this.freelancerService()
      .retrieve()
      .then(res => {
        this.freelancers = res.data;
      });
  }
}
