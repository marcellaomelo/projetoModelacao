import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskDisponibilidadeFreelancerService from './task-disponibilidade-freelancer.service';
import { TaskDisponibilidadeFreelancerContext } from './task-disponibilidade-freelancer.model';

@Component
export default class TaskDisponibilidadeFreelancerDetailsComponent extends Vue {
  private taskDisponibilidadeFreelancerService: TaskDisponibilidadeFreelancerService = new TaskDisponibilidadeFreelancerService();
  private taskContext: TaskDisponibilidadeFreelancerContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskDisponibilidadeFreelancerService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
