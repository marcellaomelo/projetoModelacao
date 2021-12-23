import axios from 'axios';
import { TaskDisponibilidadeFreelancerContext } from './task-disponibilidade-freelancer.model';

const baseApiUrl = 'api/pedido-interprete-processo/task-disponibilidade-freelancer';

export default class TaskDisponibilidadeFreelancerService {
  public loadContext(taskId: number): Promise<TaskDisponibilidadeFreelancerContext> {
    return new Promise<TaskDisponibilidadeFreelancerContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskDisponibilidadeFreelancerContext> {
    return new Promise<TaskDisponibilidadeFreelancerContext>((resolve, reject) => {
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

  public complete(taskDisponibilidadeFreelancerContext: TaskDisponibilidadeFreelancerContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskDisponibilidadeFreelancerContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
