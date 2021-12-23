/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import PedidoInterpreteDetailComponent from '@/entities/pedido-interprete/pedido-interprete-details.vue';
import PedidoInterpreteClass from '@/entities/pedido-interprete/pedido-interprete-details.component';
import PedidoInterpreteService from '@/entities/pedido-interprete/pedido-interprete.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('PedidoInterprete Management Detail Component', () => {
    let wrapper: Wrapper<PedidoInterpreteClass>;
    let comp: PedidoInterpreteClass;
    let pedidoInterpreteServiceStub: SinonStubbedInstance<PedidoInterpreteService>;

    beforeEach(() => {
      pedidoInterpreteServiceStub = sinon.createStubInstance<PedidoInterpreteService>(PedidoInterpreteService);

      wrapper = shallowMount<PedidoInterpreteClass>(PedidoInterpreteDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { pedidoInterpreteService: () => pedidoInterpreteServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundPedidoInterprete = { id: 123 };
        pedidoInterpreteServiceStub.find.resolves(foundPedidoInterprete);

        // WHEN
        comp.retrievePedidoInterprete(123);
        await comp.$nextTick();

        // THEN
        expect(comp.pedidoInterprete).toBe(foundPedidoInterprete);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundPedidoInterprete = { id: 123 };
        pedidoInterpreteServiceStub.find.resolves(foundPedidoInterprete);

        // WHEN
        comp.beforeRouteEnter({ params: { pedidoInterpreteId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.pedidoInterprete).toBe(foundPedidoInterprete);
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
