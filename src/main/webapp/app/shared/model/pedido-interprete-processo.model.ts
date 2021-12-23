import { IPedidoInterprete } from '@/shared/model/pedido-interprete.model';

export interface IPedidoInterpreteProcesso {
  id?: number;
  processInstance?: any | null;
  pedidoInterprete?: IPedidoInterprete | null;
}

export class PedidoInterpreteProcesso implements IPedidoInterpreteProcesso {
  constructor(public id?: number, public processInstance?: any | null, public pedidoInterprete?: IPedidoInterprete | null) {}
}
