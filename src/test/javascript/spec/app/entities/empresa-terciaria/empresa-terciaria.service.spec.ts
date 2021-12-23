/* tslint:disable max-line-length */
import axios from 'axios';
import sinon from 'sinon';
import dayjs from 'dayjs';

import { DATE_FORMAT } from '@/shared/date/filters';
import EmpresaTerciariaService from '@/entities/empresa-terciaria/empresa-terciaria.service';
import { EmpresaTerciaria } from '@/shared/model/empresa-terciaria.model';

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
  describe('EmpresaTerciaria Service', () => {
    let service: EmpresaTerciariaService;
    let elemDefault;
    let currentDate: Date;

    beforeEach(() => {
      service = new EmpresaTerciariaService();
      currentDate = new Date();
      elemDefault = new EmpresaTerciaria(0, 'AAAAAAA', currentDate, false);
    });

    describe('Service methods', () => {
      it('should find an element', async () => {
        const returnedFromService = Object.assign(
          {
            interpreteEmpresaDataDisponivel: dayjs(currentDate).format(DATE_FORMAT),
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

      it('should create a EmpresaTerciaria', async () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            interpreteEmpresaDataDisponivel: dayjs(currentDate).format(DATE_FORMAT),
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            interpreteEmpresaDataDisponivel: currentDate,
          },
          returnedFromService
        );

        axiosStub.post.resolves({ data: returnedFromService });
        return service.create({}).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not create a EmpresaTerciaria', async () => {
        axiosStub.post.rejects(error);

        return service
          .create({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should update a EmpresaTerciaria', async () => {
        const returnedFromService = Object.assign(
          {
            interpreteEmpresaName: 'BBBBBB',
            interpreteEmpresaDataDisponivel: dayjs(currentDate).format(DATE_FORMAT),
            pedidoInterpreteEmpresa: true,
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            interpreteEmpresaDataDisponivel: currentDate,
          },
          returnedFromService
        );
        axiosStub.put.resolves({ data: returnedFromService });

        return service.update(expected).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not update a EmpresaTerciaria', async () => {
        axiosStub.put.rejects(error);

        return service
          .update({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should partial update a EmpresaTerciaria', async () => {
        const patchObject = Object.assign(
          {
            pedidoInterpreteEmpresa: true,
          },
          new EmpresaTerciaria()
        );
        const returnedFromService = Object.assign(patchObject, elemDefault);

        const expected = Object.assign(
          {
            interpreteEmpresaDataDisponivel: currentDate,
          },
          returnedFromService
        );
        axiosStub.patch.resolves({ data: returnedFromService });

        return service.partialUpdate(patchObject).then(res => {
          expect(res).toMatchObject(expected);
        });
      });

      it('should not partial update a EmpresaTerciaria', async () => {
        axiosStub.patch.rejects(error);

        return service
          .partialUpdate({})
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should return a list of EmpresaTerciaria', async () => {
        const returnedFromService = Object.assign(
          {
            interpreteEmpresaName: 'BBBBBB',
            interpreteEmpresaDataDisponivel: dayjs(currentDate).format(DATE_FORMAT),
            pedidoInterpreteEmpresa: true,
          },
          elemDefault
        );
        const expected = Object.assign(
          {
            interpreteEmpresaDataDisponivel: currentDate,
          },
          returnedFromService
        );
        axiosStub.get.resolves([returnedFromService]);
        return service.retrieve().then(res => {
          expect(res).toContainEqual(expected);
        });
      });

      it('should not return a list of EmpresaTerciaria', async () => {
        axiosStub.get.rejects(error);

        return service
          .retrieve()
          .then()
          .catch(err => {
            expect(err).toMatchObject(error);
          });
      });

      it('should delete a EmpresaTerciaria', async () => {
        axiosStub.delete.resolves({ ok: true });
        return service.delete(123).then(res => {
          expect(res.ok).toBeTruthy();
        });
      });

      it('should not delete a EmpresaTerciaria', async () => {
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
