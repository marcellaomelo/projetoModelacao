import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskPedidoEmpresaTerciariaService from './task-pedido-empresa-terciaria.service';
import { TaskPedidoEmpresaTerciariaContext } from './task-pedido-empresa-terciaria.model';

@Component
export default class TaskPedidoEmpresaTerciariaDetailsComponent extends Vue {
  private taskPedidoEmpresaTerciariaService: TaskPedidoEmpresaTerciariaService = new TaskPedidoEmpresaTerciariaService();
  private taskContext: TaskPedidoEmpresaTerciariaContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskPedidoEmpresaTerciariaService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
