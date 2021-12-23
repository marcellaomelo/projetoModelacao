import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskReservaServicoService from './task-reserva-servico.service';
import { TaskReservaServicoContext } from './task-reserva-servico.model';

@Component
export default class TaskReservaServicoDetailsComponent extends Vue {
  private taskReservaServicoService: TaskReservaServicoService = new TaskReservaServicoService();
  private taskContext: TaskReservaServicoContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskReservaServicoService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
