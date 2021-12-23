/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import EmpresaTerciariaComponent from '@/entities/empresa-terciaria/empresa-terciaria.vue';
import EmpresaTerciariaClass from '@/entities/empresa-terciaria/empresa-terciaria.component';
import EmpresaTerciariaService from '@/entities/empresa-terciaria/empresa-terciaria.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('EmpresaTerciaria Management Component', () => {
    let wrapper: Wrapper<EmpresaTerciariaClass>;
    let comp: EmpresaTerciariaClass;
    let empresaTerciariaServiceStub: SinonStubbedInstance<EmpresaTerciariaService>;

    beforeEach(() => {
      empresaTerciariaServiceStub = sinon.createStubInstance<EmpresaTerciariaService>(EmpresaTerciariaService);
      empresaTerciariaServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<EmpresaTerciariaClass>(EmpresaTerciariaComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          empresaTerciariaService: () => empresaTerciariaServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      empresaTerciariaServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllEmpresaTerciarias();
      await comp.$nextTick();

      // THEN
      expect(empresaTerciariaServiceStub.retrieve.called).toBeTruthy();
      expect(comp.empresaTerciarias[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      empresaTerciariaServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeEmpresaTerciaria();
      await comp.$nextTick();

      // THEN
      expect(empresaTerciariaServiceStub.delete.called).toBeTruthy();
      expect(empresaTerciariaServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
