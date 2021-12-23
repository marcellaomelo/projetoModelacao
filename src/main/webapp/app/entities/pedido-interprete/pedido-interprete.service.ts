import axios from 'axios';

import { IPedidoInterprete } from '@/shared/model/pedido-interprete.model';

const baseApiUrl = 'api/pedido-interpretes';

export default class PedidoInterpreteService {
  public find(id: number): Promise<IPedidoInterprete> {
    return new Promise<IPedidoInterprete>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
