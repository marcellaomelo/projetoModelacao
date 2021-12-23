import { Component, Vue, Inject } from 'vue-property-decorator';

import { IPedidoInterpreteProcesso } from '@/shared/model/pedido-interprete-processo.model';
import PedidoInterpreteProcessoService from './pedido-interprete-processo.service';

@Component
export default class PedidoInterpreteProcessoDetailsComponent extends Vue {
  @Inject('pedidoInterpreteProcessoService') private pedidoInterpreteProcessoService: () => PedidoInterpreteProcessoService;
  public pedidoInterpreteProcesso: IPedidoInterpreteProcesso = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrievePedidoInterpreteProcesso(to.params.processInstanceId);
      }
    });
  }

  public retrievePedidoInterpreteProcesso(pedidoInterpreteProcessoId) {
    this.isFetching = true;
    this.pedidoInterpreteProcessoService()
      .find(pedidoInterpreteProcessoId)
      .then(
        res => {
          this.pedidoInterpreteProcesso = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
