import { Component, Vue, Inject } from 'vue-property-decorator';

import { IEmpresaTerciaria } from '@/shared/model/empresa-terciaria.model';
import EmpresaTerciariaService from './empresa-terciaria.service';

@Component
export default class EmpresaTerciariaDetails extends Vue {
  @Inject('empresaTerciariaService') private empresaTerciariaService: () => EmpresaTerciariaService;
  public empresaTerciaria: IEmpresaTerciaria = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.empresaTerciariaId) {
        vm.retrieveEmpresaTerciaria(to.params.empresaTerciariaId);
      }
    });
  }

  public retrieveEmpresaTerciaria(empresaTerciariaId) {
    this.empresaTerciariaService()
      .find(empresaTerciariaId)
      .then(res => {
        this.empresaTerciaria = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
