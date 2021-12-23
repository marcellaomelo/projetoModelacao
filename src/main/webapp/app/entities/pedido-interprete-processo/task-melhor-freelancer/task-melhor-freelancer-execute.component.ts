import { Component, Vue, Inject } from 'vue-property-decorator';

import FreelancerService from '@/entities/freelancer/freelancer.service';
import { IFreelancer } from '@/shared/model/freelancer.model';

import TaskMelhorFreelancerService from './task-melhor-freelancer.service';
import { TaskMelhorFreelancerContext } from './task-melhor-freelancer.model';

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
export default class TaskMelhorFreelancerExecuteComponent extends Vue {
  private taskMelhorFreelancerService: TaskMelhorFreelancerService = new TaskMelhorFreelancerService();
  private taskContext: TaskMelhorFreelancerContext = {};

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
    this.taskMelhorFreelancerService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskMelhorFreelancerService.complete(this.taskContext).then(res => {
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
