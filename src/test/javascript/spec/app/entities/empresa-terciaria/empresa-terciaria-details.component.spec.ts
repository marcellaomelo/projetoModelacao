/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import EmpresaTerciariaDetailComponent from '@/entities/empresa-terciaria/empresa-terciaria-details.vue';
import EmpresaTerciariaClass from '@/entities/empresa-terciaria/empresa-terciaria-details.component';
import EmpresaTerciariaService from '@/entities/empresa-terciaria/empresa-terciaria.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('EmpresaTerciaria Management Detail Component', () => {
    let wrapper: Wrapper<EmpresaTerciariaClass>;
    let comp: EmpresaTerciariaClass;
    let empresaTerciariaServiceStub: SinonStubbedInstance<EmpresaTerciariaService>;

    beforeEach(() => {
      empresaTerciariaServiceStub = sinon.createStubInstance<EmpresaTerciariaService>(EmpresaTerciariaService);

      wrapper = shallowMount<EmpresaTerciariaClass>(EmpresaTerciariaDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { empresaTerciariaService: () => empresaTerciariaServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundEmpresaTerciaria = { id: 123 };
        empresaTerciariaServiceStub.find.resolves(foundEmpresaTerciaria);

        // WHEN
        comp.retrieveEmpresaTerciaria(123);
        await comp.$nextTick();

        // THEN
        expect(comp.empresaTerciaria).toBe(foundEmpresaTerciaria);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundEmpresaTerciaria = { id: 123 };
        empresaTerciariaServiceStub.find.resolves(foundEmpresaTerciaria);

        // WHEN
        comp.beforeRouteEnter({ params: { empresaTerciariaId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.empresaTerciaria).toBe(foundEmpresaTerciaria);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
