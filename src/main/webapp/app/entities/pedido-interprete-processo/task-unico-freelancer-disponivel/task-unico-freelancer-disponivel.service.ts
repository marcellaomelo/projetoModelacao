import axios from 'axios';
import { TaskUnicoFreelancerDisponivelContext } from './task-unico-freelancer-disponivel.model';

const baseApiUrl = 'api/pedido-interprete-processo/task-unico-freelancer-disponivel';

export default class TaskUnicoFreelancerDisponivelService {
  public loadContext(taskId: number): Promise<TaskUnicoFreelancerDisponivelContext> {
    return new Promise<TaskUnicoFreelancerDisponivelContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskUnicoFreelancerDisponivelContext> {
    return new Promise<TaskUnicoFreelancerDisponivelContext>((resolve, reject) => {
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

  public complete(taskUnicoFreelancerDisponivelContext: TaskUnicoFreelancerDisponivelContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskUnicoFreelancerDisponivelContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
