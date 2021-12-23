import { Component, Vue, Inject } from 'vue-property-decorator';

import { IFreelancer, Freelancer } from '@/shared/model/freelancer.model';
import FreelancerService from './freelancer.service';

const validations: any = {
  freelancer: {
    freelancerName: {},
    freelancerDataDisponivel: {},
    existeFreelancerDisponivel: {},
    existeMaisQueUmFreelancerDisponivel: {},
    anosExperienciaFreelancer: {},
    freelancerEscolhido: {},
    freelancerUnicoEscolhido: {},
  },
};

@Component({
  validations,
})
export default class FreelancerUpdate extends Vue {
  @Inject('freelancerService') private freelancerService: () => FreelancerService;
  public freelancer: IFreelancer = new Freelancer();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.freelancerId) {
        vm.retrieveFreelancer(to.params.freelancerId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.freelancer.id) {
      this.freelancerService()
        .update(this.freelancer)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('projetoModelacaoApp.freelancer.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.freelancerService()
        .create(this.freelancer)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('projetoModelacaoApp.freelancer.created', { param: param.id });
          this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    }
  }

  public retrieveFreelancer(freelancerId): void {
    this.freelancerService()
      .find(freelancerId)
      .then(res => {
        this.freelancer = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
