import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IFreelancer } from '@/shared/model/freelancer.model';

import FreelancerService from './freelancer.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class Freelancer extends Vue {
  @Inject('freelancerService') private freelancerService: () => FreelancerService;
  private removeId: number = null;

  public freelancers: IFreelancer[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllFreelancers();
  }

  public clear(): void {
    this.retrieveAllFreelancers();
  }

  public retrieveAllFreelancers(): void {
    this.isFetching = true;

    this.freelancerService()
      .retrieve()
      .then(
        res => {
          this.freelancers = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IFreelancer): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeFreelancer(): void {
    this.freelancerService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('projetoModelacaoApp.freelancer.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllFreelancers();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
