import { Component, Vue, Inject } from 'vue-property-decorator';

import { IEmpresaTerciaria, EmpresaTerciaria } from '@/shared/model/empresa-terciaria.model';
import EmpresaTerciariaService from './empresa-terciaria.service';

const validations: any = {
  empresaTerciaria: {
    interpreteEmpresaName: {},
    interpreteEmpresaDataDisponivel: {},
    pedidoInterpreteEmpresa: {},
  },
};

@Component({
  validations,
})
export default class EmpresaTerciariaUpdate extends Vue {
  @Inject('empresaTerciariaService') private empresaTerciariaService: () => EmpresaTerciariaService;
  public empresaTerciaria: IEmpresaTerciaria = new EmpresaTerciaria();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.empresaTerciariaId) {
        vm.retrieveEmpresaTerciaria(to.params.empresaTerciariaId);
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
    if (this.empresaTerciaria.id) {
      this.empresaTerciariaService()
        .update(this.empresaTerciaria)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('projetoModelacaoApp.empresaTerciaria.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.empresaTerciariaService()
        .create(this.empresaTerciaria)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('projetoModelacaoApp.empresaTerciaria.created', { param: param.id });
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

  public retrieveEmpresaTerciaria(empresaTerciariaId): void {
    this.empresaTerciariaService()
      .find(empresaTerciariaId)
      .then(res => {
        this.empresaTerciaria = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
