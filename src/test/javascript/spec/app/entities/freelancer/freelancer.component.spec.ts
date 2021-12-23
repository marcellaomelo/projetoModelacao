/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import FreelancerComponent from '@/entities/freelancer/freelancer.vue';
import FreelancerClass from '@/entities/freelancer/freelancer.component';
import FreelancerService from '@/entities/freelancer/freelancer.service';

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
  describe('Freelancer Management Component', () => {
    let wrapper: Wrapper<FreelancerClass>;
    let comp: FreelancerClass;
    let freelancerServiceStub: SinonStubbedInstance<FreelancerService>;

    beforeEach(() => {
      freelancerServiceStub = sinon.createStubInstance<FreelancerService>(FreelancerService);
      freelancerServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<FreelancerClass>(FreelancerComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          freelancerService: () => freelancerServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      freelancerServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllFreelancers();
      await comp.$nextTick();

      // THEN
      expect(freelancerServiceStub.retrieve.called).toBeTruthy();
      expect(comp.freelancers[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      freelancerServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: 123 });
      comp.removeFreelancer();
      await comp.$nextTick();

      // THEN
      expect(freelancerServiceStub.delete.called).toBeTruthy();
      expect(freelancerServiceStub.retrieve.callCount).toEqual(1);
    });
  });
});
