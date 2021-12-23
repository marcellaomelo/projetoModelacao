import { Component, Vue, Inject } from 'vue-property-decorator';

import { IPedidoInterprete } from '@/shared/model/pedido-interprete.model';
import PedidoInterpreteService from './pedido-interprete.service';

@Component
export default class PedidoInterpreteDetails extends Vue {
  @Inject('pedidoInterpreteService') private pedidoInterpreteService: () => PedidoInterpreteService;
  public pedidoInterprete: IPedidoInterprete = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.pedidoInterpreteId) {
        vm.retrievePedidoInterprete(to.params.pedidoInterpreteId);
      }
    });
  }

  public retrievePedidoInterprete(pedidoInterpreteId) {
    this.pedidoInterpreteService()
      .find(pedidoInterpreteId)
      .then(res => {
        this.pedidoInterprete = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
