import { Component, Vue, Inject } from 'vue-property-decorator';

import { IFreelancer } from '@/shared/model/freelancer.model';
import FreelancerService from './freelancer.service';

@Component
export default class FreelancerDetails extends Vue {
  @Inject('freelancerService') private freelancerService: () => FreelancerService;
  public freelancer: IFreelancer = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.freelancerId) {
        vm.retrieveFreelancer(to.params.freelancerId);
      }
    });
  }

  public retrieveFreelancer(freelancerId) {
    this.freelancerService()
      .find(freelancerId)
      .then(res => {
        this.freelancer = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
