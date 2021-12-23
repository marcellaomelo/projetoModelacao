/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import FreelancerService from '@/entities/freelancer/freelancer.service';
import { Freelancer } from '@/shared/model/freelancer.model';

const error = {
  response: {
    status: null,
    data: {
      type: null,
    },
  },
};

const axiosStub = {
  get: sinon.stub(axios, 'get'),
  post: sinon.stub(axios, 'post'),
  put: sinon.stub(axios, 'put'),
  patch: sinon.stub(axios, 'patch'),
  delete: sinon.stub(axios, 'delete'),
};

describe('Service Tests', () => {
  describe('Freelancer Service', () => {
    let service: FreelancerService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new FreelancerService();
      currentDate = new Date();
      elemDefault = new Freelancer(0, 'AAAAAAA', currentDate, false, false, 0, 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            freelancerDataDisponivel: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        axiosStub.get.resolves({ data: returnedFromService });

        return service.find(123).then(res => {
          expect(res).toMatchObject(elemDefault);
        });
      });

      it('should not find an element', async () => {
        axiosStub.get.rejects(error);
        return service
          .find(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should create a Freelancer', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            freelancerDataDisponivel: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            freelancerDataDisponivel: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a Freelancer', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a Freelancer', async () => {
        const returnedFromService = Object.assign(
          {
            freelancerName: 'BBBBBB',
            freelancerDataDisponivel: dayjs(currentDate).format(DATE_FORMAT),
            existeFreelancerDisponivel: true,
            existeMaisQueUmFreelancerDisponivel: true,
            anosExperienciaFreelancer: 1,
            freelancerEscolhido: 'BBBBBB',
            freelancerUnicoEscolhido: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            freelancerDataDisponivel: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a Freelancer', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a Freelancer', async () => {
        const patchObject = Object.assign(
          {
            existeFreelancerDisponivel: true,
            freelancerEscolhido: 'BBBBBB',
            freelancerUnicoEscolhido: 'BBBBBB',
          },
          new Freelancer()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            freelancerDataDisponivel: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a Freelancer', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of Freelancer', async () => {
        const returnedFromService = Object.assign(
          {
            freelancerName: 'BBBBBB',
            freelancerDataDisponivel: dayjs(currentDate).format(DATE_FORMAT),
            existeFreelancerDisponivel: true,
            existeMaisQueUmFreelancerDisponivel: true,
            anosExperienciaFreelancer: 1,
            freelancerEscolhido: 'BBBBBB',
            freelancerUnicoEscolhido: 'BBBBBB',
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            freelancerDataDisponivel: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of Freelancer', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a Freelancer', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a Freelancer', async () => {
        axiosStub.delete.rejects(error);

        return service
          .delete(123)
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });
    });
  });
});
