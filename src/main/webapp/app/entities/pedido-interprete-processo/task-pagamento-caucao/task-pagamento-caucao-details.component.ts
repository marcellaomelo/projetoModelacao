import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskPagamentoCaucaoService from './task-pagamento-caucao.service';
import { TaskPagamentoCaucaoContext } from './task-pagamento-caucao.model';

@Component
export default class TaskPagamentoCaucaoDetailsComponent extends Vue {
  private taskPagamentoCaucaoService: TaskPagamentoCaucaoService = new TaskPagamentoCaucaoService();
  private taskContext: TaskPagamentoCaucaoContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskPagamentoCaucaoService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
