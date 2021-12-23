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
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.dataPedido')">dataPedido</label>
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
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.localTuristicoPedido')"
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
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.clienteName')">clienteName</label>
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
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.clienteEmail')">clienteEmail</label>
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
              <label class="form-control-label" v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.freelancerNumeroReserva')"
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
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.freelancer')"
                for="task-melhor-freelancer-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.freelancer')"
                for="task-melhor-freelancer-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.freelancer')"
                for="task-melhor-freelancer-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.freelancer')"
                for="task-melhor-freelancer-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.freelancer')"
                for="task-melhor-freelancer-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskMelhorFreelancer.freelancer')"
                for="task-melhor-freelancer-freelancer"
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
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/PedidoInterpreteProcesso/task/TaskMelhorFreelancer/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-melhor-freelancer-details.component.ts"></script>
