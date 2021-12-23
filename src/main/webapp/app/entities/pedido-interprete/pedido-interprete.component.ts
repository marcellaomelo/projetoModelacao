import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IPedidoInterprete } from '@/shared/model/pedido-interprete.model';

import PedidoInterpreteService from './pedido-interprete.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class PedidoInterprete extends Vue {
  @Inject('pedidoInterpreteService') private pedidoInterpreteService: () => PedidoInterpreteService;
  private removeId: number = null;

  public pedidoInterpretes: IPedidoInterprete[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllPedidoInterpretes();
  }

  public clear(): void {
    this.retrieveAllPedidoInterpretes();
  }

  public retrieveAllPedidoInterpretes(): void {
    this.isFetching = true;

    this.pedidoInterpreteService()
      .retrieve()
      .then(
        res => {
          this.pedidoInterpretes = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
