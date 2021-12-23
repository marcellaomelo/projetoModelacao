/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import Router from 'vue-router';

import * as config from '@/shared/config/config';
import FreelancerUpdateComponent from '@/entities/freelancer/freelancer-update.vue';
import FreelancerClass from '@/entities/freelancer/freelancer-update.component';
import FreelancerService from '@/entities/freelancer/freelancer.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
const router = new Router();
localVue.use(Router);
localVue.component('font-awesome-icon', {});
localVue.component('b-input-group', {});
localVue.component('b-input-group-prepend', {});
localVue.component('b-form-datepicker', {});
localVue.component('b-form-input', {});

describe('Component Tests', () => {
  describe('Freelancer Management Update Component', () => {
    let wrapper: Wrapper<FreelancerClass>;
    let comp: FreelancerClass;
    let freelancerServiceStub: SinonStubbedInstance<FreelancerService>;

    beforeEach(() => {
      freelancerServiceStub = sinon.createStubInstance<FreelancerService>(FreelancerService);

      wrapper = shallowMount<FreelancerClass>(FreelancerUpdateComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: {
          freelancerService: () => freelancerServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', async () => {
        // GIVEN
        const entity = { id: 123 };
        comp.freelancer = entity;
        freelancerServiceStub.update.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(freelancerServiceStub.update.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });

      it('Should call create service on save for new entity', async () => {
        // GIVEN
        const entity = {};
        comp.freelancer = entity;
        freelancerServiceStub.create.resolves(entity);

        // WHEN
        comp.save();
        await comp.$nextTick();

        // THEN
        expect(freelancerServiceStub.create.calledWith(entity)).toBeTruthy();
        expect(comp.isSaving).toEqual(false);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundFreelancer = { id: 123 };
        freelancerServiceStub.find.resolves(foundFreelancer);
        freelancerServiceStub.retrieve.resolves([foundFreelancer]);

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
