<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('projetoModelacaoApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskReservaServico.dataPedido')">dataPedido</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="dataPedido"
                id="pedido-interprete-dataPedido"
                data-cy="dataPedido"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.dataPedido"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskReservaServico.localTuristicoPedido')"
                >localTuristicoPedido</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="localTuristicoPedido"
                id="pedido-interprete-localTuristicoPedido"
                data-cy="localTuristicoPedido"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.localTuristicoPedido"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskReservaServico.clienteName')">clienteName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="clienteName"
                id="pedido-interprete-clienteName"
                data-cy="clienteName"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.clienteName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskReservaServico.clienteEmail')">clienteEmail</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="clienteEmail"
                id="pedido-interprete-clienteEmail"
                data-cy="clienteEmail"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.clienteEmail"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskReservaServico.freelancerNumeroReserva')"
                >freelancerNumeroReserva</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="freelancerNumeroReserva"
                id="pedido-interprete-freelancerNumeroReserva"
                data-cy="freelancerNumeroReserva"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancerNumeroReserva"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskReservaServico.empresaTerciariaNumeroReserva')"
                >empresaTerciariaNumeroReserva</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="empresaTerciariaNumeroReserva"
                id="pedido-interprete-empresaTerciariaNumeroReserva"
                data-cy="empresaTerciariaNumeroReserva"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciariaNumeroReserva"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskReservaServico.precoReserva')">precoReserva</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="precoReserva"
                id="pedido-interprete-precoReserva"
                data-cy="precoReserva"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.precoReserva"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskReservaServico.reservarServico')"
                >reservarServico</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="reservarServico"
                id="pedido-interprete-reservarServico"
                data-cy="reservarServico"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.reservarServico"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskReservaServico.freelancer')"
                for="task-reserva-servico-freelancer"
                >Freelancer</label
              >
              <input
                v-if="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                :value="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.freelancername"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                value=""
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskReservaServico.freelancer')"
                for="task-reserva-servico-freelancer"
                >Freelancer</label
              >
              <input
                v-if="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                :value="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.freelancerdataDisponivel"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                value=""
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskReservaServico.freelancer')"
                for="task-reserva-servico-freelancer"
                >Freelancer</label
              >
              <input
                v-if="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                :value="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.existeFreelancerDisponivel"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                value=""
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskReservaServico.freelancer')"
                for="task-reserva-servico-freelancer"
                >Freelancer</label
              >
              <input
                v-if="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                :value="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.existeMaisQueUmFreelancerDisponivel"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                value=""
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskReservaServico.freelancer')"
                for="task-reserva-servico-freelancer"
                >Freelancer</label
              >
              <input
                v-if="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                :value="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.anosExperienciaFreelancer"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                value=""
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskReservaServico.freelancer')"
                for="task-reserva-servico-freelancer"
                >Freelancer</label
              >
              <input
                v-if="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                :value="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.freelancerEscolhido"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="freelancer"
                id="pedido-interprete-freelancer"
                data-cy="freelancer"
                value=""
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskReservaServico.empresaTerciaria')"
                for="task-reserva-servico-empresaTerciaria"
                >Empresa Terciaria</label
              >
              <input
                v-if="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria"
                readonly
                type="text"
                class="form-control"
                name="empresaTerciaria"
                id="pedido-interprete-empresaTerciaria"
                data-cy="empresaTerciaria"
                :value="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria.interpreteEmpresaName"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="empresaTerciaria"
                id="pedido-interprete-empresaTerciaria"
                data-cy="empresaTerciaria"
                value=""
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskReservaServico.empresaTerciaria')"
                for="task-reserva-servico-empresaTerciaria"
                >Empresa Terciaria</label
              >
              <input
                v-if="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria"
                readonly
                type="text"
                class="form-control"
                name="empresaTerciaria"
                id="pedido-interprete-empresaTerciaria"
                data-cy="empresaTerciaria"
                :value="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria.interpreteEmpresaDataDisponivel"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="empresaTerciaria"
                id="pedido-interprete-empresaTerciaria"
                data-cy="empresaTerciaria"
                value=""
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskReservaServico.empresaTerciaria')"
                for="task-reserva-servico-empresaTerciaria"
                >Empresa Terciaria</label
              >
              <input
                v-if="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria"
                readonly
                type="text"
                class="form-control"
                name="empresaTerciaria"
                id="pedido-interprete-empresaTerciaria"
                data-cy="empresaTerciaria"
                :value="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria.pedidoInterpreteEmpresa"
              />
              <input
                v-else
                readonly
                type="text"
                class="form-control"
                name="empresaTerciaria"
                id="pedido-interprete-empresaTerciaria"
                data-cy="empresaTerciaria"
                value=""
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/PedidoInterpreteProcesso/task/TaskReservaServico/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-reserva-servico-details.component.ts"></script>
