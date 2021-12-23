/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import FreelancerDetailComponent from '@/entities/freelancer/freelancer-details.vue';
import FreelancerClass from '@/entities/freelancer/freelancer-details.component';
import FreelancerService from '@/entities/freelancer/freelancer.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Freelancer Management Detail Component', () => {
    let wrapper: Wrapper<FreelancerClass>;
    let comp: FreelancerClass;
    let freelancerServiceStub: SinonStubbedInstance<FreelancerService>;

    beforeEach(() => {
      freelancerServiceStub = sinon.createStubInstance<FreelancerService>(FreelancerService);

      wrapper = shallowMount<FreelancerClass>(FreelancerDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { freelancerService: () => freelancerServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundFreelancer = { id: 123 };
        freelancerServiceStub.find.resolves(foundFreelancer);

        // WHEN
        comp.retrieveFreelancer(123);
        await comp.$nextTick();

        // THEN
        expect(comp.freelancer).toBe(foundFreelancer);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFreelancer = { id: 123 };
        freelancerServiceStub.find.resolves(foundFreelancer);

        // WHEN
        comp.beforeRouteEnter({ params: { freelancerId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.freelancer).toBe(foundFreelancer);
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
