import axios from 'axios';
import { TaskPagamentoCaucaoContext } from './task-pagamento-caucao.model';

const baseApiUrl = 'api/pedido-interprete-processo/task-pagamento-caucao';

export default class TaskPagamentoCaucaoService {
  public loadContext(taskId: number): Promise<TaskPagamentoCaucaoContext> {
    return new Promise<TaskPagamentoCaucaoContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskPagamentoCaucaoContext> {
    return new Promise<TaskPagamentoCaucaoContext>((resolve, reject) => {
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

  public complete(taskPagamentoCaucaoContext: TaskPagamentoCaucaoContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskPagamentoCaucaoContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
