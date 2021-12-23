import axios from 'axios';
import { TaskPedidoEmpresaTerciariaContext } from './task-pedido-empresa-terciaria.model';

const baseApiUrl = 'api/pedido-interprete-processo/task-pedido-empresa-terciaria';

export default class TaskPedidoEmpresaTerciariaService {
  public loadContext(taskId: number): Promise<TaskPedidoEmpresaTerciariaContext> {
    return new Promise<TaskPedidoEmpresaTerciariaContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskPedidoEmpresaTerciariaContext> {
    return new Promise<TaskPedidoEmpresaTerciariaContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskPedidoEmpresaTerciariaContext: TaskPedidoEmpresaTerciariaContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskPedidoEmpresaTerciariaContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
