import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUnicoFreelancerDisponivelService from './task-unico-freelancer-disponivel.service';
import { TaskUnicoFreelancerDisponivelContext } from './task-unico-freelancer-disponivel.model';

@Component
export default class TaskUnicoFreelancerDisponivelDetailsComponent extends Vue {
  private taskUnicoFreelancerDisponivelService: TaskUnicoFreelancerDisponivelService = new TaskUnicoFreelancerDisponivelService();
  private taskContext: TaskUnicoFreelancerDisponivelContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskUnicoFreelancerDisponivelService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
