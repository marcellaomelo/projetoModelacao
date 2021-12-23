import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IEmpresaTerciaria } from '@/shared/model/empresa-terciaria.model';

import EmpresaTerciariaService from './empresa-terciaria.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class EmpresaTerciaria extends Vue {
  @Inject('empresaTerciariaService') private empresaTerciariaService: () => EmpresaTerciariaService;
  private removeId: number = null;

  public empresaTerciarias: IEmpresaTerciaria[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllEmpresaTerciarias();
  }

  public clear(): void {
    this.retrieveAllEmpresaTerciarias();
  }

  public retrieveAllEmpresaTerciarias(): void {
    this.isFetching = true;

    this.empresaTerciariaService()
      .retrieve()
      .then(
        res => {
          this.empresaTerciarias = res.data;
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

  public prepareRemove(instance: IEmpresaTerciaria): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeEmpresaTerciaria(): void {
    this.empresaTerciariaService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('projetoModelacaoApp.empresaTerciaria.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllEmpresaTerciarias();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
