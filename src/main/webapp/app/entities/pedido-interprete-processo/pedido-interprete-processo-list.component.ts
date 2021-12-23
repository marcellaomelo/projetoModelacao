import { Component, Vue, Inject } from 'vue-property-decorator';
import { IPedidoInterpreteProcesso } from '@/shared/model/pedido-interprete-processo.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import PedidoInterpreteProcessoService from './pedido-interprete-processo.service';

@Component
export default class PedidoInterpreteProcessoListComponent extends Vue {
  @Inject('pedidoInterpreteProcessoService') private pedidoInterpreteProcessoService: () => PedidoInterpreteProcessoService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'PedidoInterpreteProcesso';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public pedidoInterpreteProcessoList: IPedidoInterpreteProcesso[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.pedidoInterpreteProcessoService()
      .retrieve()
      .then(
        res => {
          this.pedidoInterpreteProcessoList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
