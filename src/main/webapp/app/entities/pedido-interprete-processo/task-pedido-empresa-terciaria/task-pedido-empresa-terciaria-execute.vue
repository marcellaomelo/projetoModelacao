<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('projetoModelacaoApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.dataPedido')"
                for="task-pedido-empresa-terciaria-dataPedido"
                >Data Pedido</label
              >
              <b-input-group class="mb-3">
                <b-input-group-prepend>
                  <b-form-datepicker
                    aria-controls="task-pedido-empresa-terciaria-dataPedido"
                    v-model="$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.dataPedido.$model"
                    name="dataPedido"
                    class="form-control"
                    :locale="currentLanguage"
                    button-only
                    today-button
                    reset-button
                    close-button
                  >
                  </b-form-datepicker>
                </b-input-group-prepend>

                <b-form-input
                  id="task-pedido-empresa-terciaria-dataPedido"
                  data-cy="dataPedido"
                  type="text"
                  class="form-control"
                  name="dataPedido"
                  :class="{
                    valid: !$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.dataPedido.$invalid,
                    invalid: $v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.dataPedido.$invalid,
                  }"
                  v-model="$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.dataPedido.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.localTuristicoPedido')"
                for="task-pedido-empresa-terciaria-localTuristicoPedido"
                >Local Turistico Pedido</label
              >
              <input
                type="text"
                class="form-control"
                name="localTuristicoPedido"
                id="task-pedido-empresa-terciaria-localTuristicoPedido"
                data-cy="localTuristicoPedido"
                :class="{
                  valid: !$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.localTuristicoPedido.$invalid,
                  invalid: $v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.localTuristicoPedido.$invalid,
                }"
                v-model="$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.localTuristicoPedido.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.clienteName')"
                for="task-pedido-empresa-terciaria-clienteName"
                >Cliente Name</label
              >
              <input
                type="text"
                class="form-control"
                name="clienteName"
                id="task-pedido-empresa-terciaria-clienteName"
                data-cy="clienteName"
                :class="{
                  valid: !$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.clienteName.$invalid,
                  invalid: $v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.clienteName.$invalid,
                }"
                v-model="$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.clienteName.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.clienteEmail')"
                for="task-pedido-empresa-terciaria-clienteEmail"
                >Cliente Email</label
              >
              <input
                type="text"
                class="form-control"
                name="clienteEmail"
                id="task-pedido-empresa-terciaria-clienteEmail"
                data-cy="clienteEmail"
                :class="{
                  valid: !$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.clienteEmail.$invalid,
                  invalid: $v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.clienteEmail.$invalid,
                }"
                v-model="$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.clienteEmail.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.freelancerNumeroReserva')"
                for="task-pedido-empresa-terciaria-freelancerNumeroReserva"
                >Freelancer Numero Reserva</label
              >
              <input
                type="text"
                class="form-control"
                name="freelancerNumeroReserva"
                id="task-pedido-empresa-terciaria-freelancerNumeroReserva"
                data-cy="freelancerNumeroReserva"
                :class="{
                  valid: !$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancerNumeroReserva.$invalid,
                  invalid: $v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancerNumeroReserva.$invalid,
                }"
                v-model="$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancerNumeroReserva.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.empresaTerciariaNumeroReserva')"
                for="task-pedido-empresa-terciaria-empresaTerciariaNumeroReserva"
                >Empresa Terciaria Numero Reserva</label
              >
              <input
                type="text"
                class="form-control"
                name="empresaTerciariaNumeroReserva"
                id="task-pedido-empresa-terciaria-empresaTerciariaNumeroReserva"
                data-cy="empresaTerciariaNumeroReserva"
                :class="{
                  valid: !$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciariaNumeroReserva.$invalid,
                  invalid: $v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciariaNumeroReserva.$invalid,
                }"
                v-model="$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciariaNumeroReserva.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.freelancer')"
                for="task-pedido-empresa-terciaria-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pedido-empresa-terciaria-freelancer"
                data-cy="freelancer"
                name="freelancer"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer &&
                    freelancerOption.id === taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.id
                      ? taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer
                      : freelancerOption
                  "
                  v-for="freelancerOption in freelancers"
                  :key="freelancerOption.id"
                >
                  {{ freelancerOption.freelancername }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.freelancer')"
                for="task-pedido-empresa-terciaria-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pedido-empresa-terciaria-freelancer"
                data-cy="freelancer"
                name="freelancer"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer &&
                    freelancerOption.id === taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.id
                      ? taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer
                      : freelancerOption
                  "
                  v-for="freelancerOption in freelancers"
                  :key="freelancerOption.id"
                >
                  {{ freelancerOption.freelancerdataDisponivel }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.freelancer')"
                for="task-pedido-empresa-terciaria-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pedido-empresa-terciaria-freelancer"
                data-cy="freelancer"
                name="freelancer"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer &&
                    freelancerOption.id === taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.id
                      ? taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer
                      : freelancerOption
                  "
                  v-for="freelancerOption in freelancers"
                  :key="freelancerOption.id"
                >
                  {{ freelancerOption.existeFreelancerDisponivel }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.freelancer')"
                for="task-pedido-empresa-terciaria-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pedido-empresa-terciaria-freelancer"
                data-cy="freelancer"
                name="freelancer"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer &&
                    freelancerOption.id === taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.id
                      ? taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer
                      : freelancerOption
                  "
                  v-for="freelancerOption in freelancers"
                  :key="freelancerOption.id"
                >
                  {{ freelancerOption.existeMaisQueUmFreelancerDisponivel }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.freelancer')"
                for="task-pedido-empresa-terciaria-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pedido-empresa-terciaria-freelancer"
                data-cy="freelancer"
                name="freelancer"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer &&
                    freelancerOption.id === taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.id
                      ? taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer
                      : freelancerOption
                  "
                  v-for="freelancerOption in freelancers"
                  :key="freelancerOption.id"
                >
                  {{ freelancerOption.anosExperienciaFreelancer }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.freelancer')"
                for="task-pedido-empresa-terciaria-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pedido-empresa-terciaria-freelancer"
                data-cy="freelancer"
                name="freelancer"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer &&
                    freelancerOption.id === taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer.id
                      ? taskContext.pedidoInterpreteProcesso.pedidoInterprete.freelancer
                      : freelancerOption
                  "
                  v-for="freelancerOption in freelancers"
                  :key="freelancerOption.id"
                >
                  {{ freelancerOption.freelancerEscolhido }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.empresaTerciaria')"
                for="task-pedido-empresa-terciaria-empresaTerciaria"
                >Empresa Terciaria</label
              >
              <select
                class="form-control"
                id="task-pedido-empresa-terciaria-empresaTerciaria"
                data-cy="empresaTerciaria"
                name="empresaTerciaria"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria &&
                    EmpresaTerciariaOption.id === taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria.id
                      ? taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria
                      : EmpresaTerciariaOption
                  "
                  v-for="EmpresaTerciariaOption in EmpresaTerciarias"
                  :key="EmpresaTerciariaOption.id"
                >
                  {{ EmpresaTerciariaOption.interpreteEmpresaName }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.empresaTerciaria')"
                for="task-pedido-empresa-terciaria-empresaTerciaria"
                >Empresa Terciaria</label
              >
              <select
                class="form-control"
                id="task-pedido-empresa-terciaria-empresaTerciaria"
                data-cy="empresaTerciaria"
                name="empresaTerciaria"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria &&
                    EmpresaTerciariaOption.id === taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria.id
                      ? taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria
                      : EmpresaTerciariaOption
                  "
                  v-for="EmpresaTerciariaOption in EmpresaTerciarias"
                  :key="EmpresaTerciariaOption.id"
                >
                  {{ EmpresaTerciariaOption.interpreteEmpresaDataDisponivel }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPedidoEmpresaTerciaria.empresaTerciaria')"
                for="task-pedido-empresa-terciaria-empresaTerciaria"
                >Empresa Terciaria</label
              >
              <select
                class="form-control"
                id="task-pedido-empresa-terciaria-empresaTerciaria"
                data-cy="empresaTerciaria"
                name="empresaTerciaria"
                v-model="taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria"
              >
                <option v-bind:value="null"></option>
                <option
                  v-bind:value="
                    taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria &&
                    EmpresaTerciariaOption.id === taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria.id
                      ? taskContext.pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria
                      : EmpresaTerciariaOption
                  "
                  v-for="EmpresaTerciariaOption in EmpresaTerciarias"
                  :key="EmpresaTerciariaOption.id"
                >
                  {{ EmpresaTerciariaOption.pedidoInterpreteEmpresa }}
                </option>
              </select>
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-pedido-empresa-terciaria-execute.component.ts"></script>
