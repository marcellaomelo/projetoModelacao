import axios from 'axios';

import { IPedidoInterpreteProcesso } from '@/shared/model/pedido-interprete-processo.model';

const baseApiUrl = 'api/pedido-interprete-processos';

export default class PedidoInterpreteProcessoService {
  public find(id: number): Promise<IPedidoInterpreteProcesso> {
    return new Promise<IPedidoInterpreteProcesso>((resolve, reject) => {
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

  public create(entity: IPedidoInterpreteProcesso): Promise<IPedidoInterpreteProcesso> {
    return new Promise<IPedidoInterpreteProcesso>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
