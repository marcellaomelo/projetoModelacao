import axios from 'axios';
import { TaskReservaServicoContext } from './task-reserva-servico.model';

const baseApiUrl = 'api/pedido-interprete-processo/task-reserva-servico';

export default class TaskReservaServicoService {
  public loadContext(taskId: number): Promise<TaskReservaServicoContext> {
    return new Promise<TaskReservaServicoContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskReservaServicoContext> {
    return new Promise<TaskReservaServicoContext>((resolve, reject) => {
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

  public complete(taskReservaServicoContext: TaskReservaServicoContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskReservaServicoContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
