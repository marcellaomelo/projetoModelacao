import axios from 'axios';
import { TaskMelhorFreelancerContext } from './task-melhor-freelancer.model';

const baseApiUrl = 'api/pedido-interprete-processo/task-melhor-freelancer';

export default class TaskMelhorFreelancerService {
  public loadContext(taskId: number): Promise<TaskMelhorFreelancerContext> {
    return new Promise<TaskMelhorFreelancerContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskMelhorFreelancerContext> {
    return new Promise<TaskMelhorFreelancerContext>((resolve, reject) => {
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

  public complete(taskMelhorFreelancerContext: TaskMelhorFreelancerContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskMelhorFreelancerContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
