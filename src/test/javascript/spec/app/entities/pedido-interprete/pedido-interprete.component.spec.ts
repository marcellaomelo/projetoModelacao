/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import PedidoInterpreteComponent from '@/entities/pedido-interprete/pedido-interprete.vue';
import PedidoInterpreteClass from '@/entities/pedido-interprete/pedido-interprete.component';
import PedidoInterpreteService from '@/entities/pedido-interprete/pedido-interprete.service';

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
  describe('PedidoInterprete Management Component', () => {
    let wrapper: Wrapper<PedidoInterpreteClass>;
    let comp: PedidoInterpreteClass;
    let pedidoInterpreteServiceStub: SinonStubbedInstance<PedidoInterpreteService>;

    beforeEach(() => {
      pedidoInterpreteServiceStub = sinon.createStubInstance<PedidoInterpreteService>(PedidoInterpreteService);
      pedidoInterpreteServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<PedidoInterpreteClass>(PedidoInterpreteComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          pedidoInterpreteService: () => pedidoInterpreteServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      pedidoInterpreteServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllPedidoInterpretes();
      await comp.$nextTick();

      // THEN
      expect(pedidoInterpreteServiceStub.retrieve.called).toBeTruthy();
      expect(comp.pedidoInterpretes[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
