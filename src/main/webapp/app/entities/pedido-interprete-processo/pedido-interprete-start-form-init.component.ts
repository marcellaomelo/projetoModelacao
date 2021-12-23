import { Component, Vue, Inject } from 'vue-property-decorator';

import { IPedidoInterpreteProcesso, PedidoInterpreteProcesso } from '@/shared/model/pedido-interprete-processo.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { PedidoInterprete } from '@/shared/model/pedido-interprete.model';
import PedidoInterpreteProcessoService from './pedido-interprete-processo.service';

const validations: any = {
  pedidoInterpreteProcesso: {
    pedidoInterprete: {
      dataPedido: {},
      localTuristicoPedido: {},
      clienteName: {},
      clienteEmail: {},
    },
  },
};

@Component({
  validations,
})
export default class PedidoInterpreteStartFormInitComponent extends Vue {
  @Inject('pedidoInterpreteProcessoService') private pedidoInterpreteProcessoService: () => PedidoInterpreteProcessoService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'PedidoInterpreteProcesso';
  public pedidoInterpreteProcesso: IPedidoInterpreteProcesso = new PedidoInterpreteProcesso();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initPedidoInterpreteStartForm();
      vm.initRelationships();
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

    this.pedidoInterpreteProcessoService()
      .create(this.pedidoInterpreteProcesso)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('projetoModelacaoApp.pedidoInterpreteStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initPedidoInterpreteStartForm(): void {
    this.pedidoInterpreteProcesso.pedidoInterprete = new PedidoInterprete();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.pedidoInterpreteProcesso.processInstance = new ProcessInstance();
      this.pedidoInterpreteProcesso.processInstance.processDefinition = res;
    });
  }
}
