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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.dataPedido')"
                for="task-pagamento-caucao-dataPedido"
                >Data Pedido</label
              >
              <b-input-group class="mb-3">
                <b-input-group-prepend>
                  <b-form-datepicker
                    aria-controls="task-pagamento-caucao-dataPedido"
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
                  id="task-pagamento-caucao-dataPedido"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.localTuristicoPedido')"
                for="task-pagamento-caucao-localTuristicoPedido"
                >Local Turistico Pedido</label
              >
              <input
                type="text"
                class="form-control"
                name="localTuristicoPedido"
                id="task-pagamento-caucao-localTuristicoPedido"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.clienteName')"
                for="task-pagamento-caucao-clienteName"
                >Cliente Name</label
              >
              <input
                type="text"
                class="form-control"
                name="clienteName"
                id="task-pagamento-caucao-clienteName"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.clienteEmail')"
                for="task-pagamento-caucao-clienteEmail"
                >Cliente Email</label
              >
              <input
                type="text"
                class="form-control"
                name="clienteEmail"
                id="task-pagamento-caucao-clienteEmail"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.freelancerNumeroReserva')"
                for="task-pagamento-caucao-freelancerNumeroReserva"
                >Freelancer Numero Reserva</label
              >
              <input
                type="text"
                class="form-control"
                name="freelancerNumeroReserva"
                id="task-pagamento-caucao-freelancerNumeroReserva"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.empresaTerciariaNumeroReserva')"
                for="task-pagamento-caucao-empresaTerciariaNumeroReserva"
                >Empresa Terciaria Numero Reserva</label
              >
              <input
                type="text"
                class="form-control"
                name="empresaTerciariaNumeroReserva"
                id="task-pagamento-caucao-empresaTerciariaNumeroReserva"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.precoReserva')"
                for="task-pagamento-caucao-precoReserva"
                >Preco Reserva</label
              >
              <input
                type="number"
                class="form-control"
                name="precoReserva"
                id="task-pagamento-caucao-precoReserva"
                data-cy="precoReserva"
                :class="{
                  valid: !$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.precoReserva.$invalid,
                  invalid: $v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.precoReserva.$invalid,
                }"
                v-model.number="$v.taskContext.pedidoInterpreteProcesso.pedidoInterprete.precoReserva.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.freelancer')"
                for="task-pagamento-caucao-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pagamento-caucao-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.freelancer')"
                for="task-pagamento-caucao-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pagamento-caucao-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.freelancer')"
                for="task-pagamento-caucao-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pagamento-caucao-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.freelancer')"
                for="task-pagamento-caucao-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pagamento-caucao-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.freelancer')"
                for="task-pagamento-caucao-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pagamento-caucao-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.freelancer')"
                for="task-pagamento-caucao-freelancer"
                >Freelancer</label
              >
              <select
                class="form-control"
                id="task-pagamento-caucao-freelancer"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.empresaTerciaria')"
                for="task-pagamento-caucao-empresaTerciaria"
                >Empresa Terciaria</label
              >
              <select
                class="form-control"
                id="task-pagamento-caucao-empresaTerciaria"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.empresaTerciaria')"
                for="task-pagamento-caucao-empresaTerciaria"
                >Empresa Terciaria</label
              >
              <select
                class="form-control"
                id="task-pagamento-caucao-empresaTerciaria"
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
                v-text="$t('projetoModelacaoApp.taskPagamentoCaucao.empresaTerciaria')"
                for="task-pagamento-caucao-empresaTerciaria"
                >Empresa Terciaria</label
              >
              <select
                class="form-control"
                id="task-pagamento-caucao-empresaTerciaria"
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

<script lang="ts" src="./task-pagamento-caucao-execute.component.ts"></script>
