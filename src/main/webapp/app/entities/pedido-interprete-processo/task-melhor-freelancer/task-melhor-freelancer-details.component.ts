import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskMelhorFreelancerService from './task-melhor-freelancer.service';
import { TaskMelhorFreelancerContext } from './task-melhor-freelancer.model';

@Component
export default class TaskMelhorFreelancerDetailsComponent extends Vue {
  private taskMelhorFreelancerService: TaskMelhorFreelancerService = new TaskMelhorFreelancerService();
  private taskContext: TaskMelhorFreelancerContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskMelhorFreelancerService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
