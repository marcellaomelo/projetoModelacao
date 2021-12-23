<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="projetoModelacaoApp.pedidoInterpreteStartForm.home.createOrEditLabel"
          data-cy="PedidoInterpreteStartFormCreateUpdateHeading"
          v-text="$t('projetoModelacaoApp.pedidoInterpreteStartForm.home.createOrEditLabel')"
        >
          Create or edit a PedidoInterpreteStartForm
        </h2>
        <div v-if="pedidoInterpreteProcesso.processInstance">
          <akip-show-process-definition :processDefinition="pedidoInterpreteProcesso.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="pedidoInterpreteProcesso.pedidoInterprete">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteStartForm.dataPedido')"
                    for="pedido-interprete-start-form-dataPedido"
                    >Data Pedido</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="pedido-interprete-start-form-dataPedido"
                        v-model="$v.pedidoInterpreteProcesso.pedidoInterprete.dataPedido.$model"
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
                      id="pedido-interprete-start-form-dataPedido"
                      data-cy="dataPedido"
                      type="text"
                      class="form-control"
                      name="dataPedido"
                      :class="{
                        valid: !$v.pedidoInterpreteProcesso.pedidoInterprete.dataPedido.$invalid,
                        invalid: $v.pedidoInterpreteProcesso.pedidoInterprete.dataPedido.$invalid,
                      }"
                      v-model="$v.pedidoInterpreteProcesso.pedidoInterprete.dataPedido.$model"
                    />
                  </b-input-group>
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteStartForm.localTuristicoPedido')"
                    for="pedido-interprete-start-form-localTuristicoPedido"
                    >Local Turistico Pedido</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="localTuristicoPedido"
                    id="pedido-interprete-start-form-localTuristicoPedido"
                    data-cy="localTuristicoPedido"
                    :class="{
                      valid: !$v.pedidoInterpreteProcesso.pedidoInterprete.localTuristicoPedido.$invalid,
                      invalid: $v.pedidoInterpreteProcesso.pedidoInterprete.localTuristicoPedido.$invalid,
                    }"
                    v-model="$v.pedidoInterpreteProcesso.pedidoInterprete.localTuristicoPedido.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteStartForm.clienteName')"
                    for="pedido-interprete-start-form-clienteName"
                    >Cliente Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="clienteName"
                    id="pedido-interprete-start-form-clienteName"
                    data-cy="clienteName"
                    :class="{
                      valid: !$v.pedidoInterpreteProcesso.pedidoInterprete.clienteName.$invalid,
                      invalid: $v.pedidoInterpreteProcesso.pedidoInterprete.clienteName.$invalid,
                    }"
                    v-model="$v.pedidoInterpreteProcesso.pedidoInterprete.clienteName.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteStartForm.clienteEmail')"
                    for="pedido-interprete-start-form-clienteEmail"
                    >Cliente Email</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="clienteEmail"
                    id="pedido-interprete-start-form-clienteEmail"
                    data-cy="clienteEmail"
                    :class="{
                      valid: !$v.pedidoInterpreteProcesso.pedidoInterprete.clienteEmail.$invalid,
                      invalid: $v.pedidoInterpreteProcesso.pedidoInterprete.clienteEmail.$invalid,
                    }"
                    v-model="$v.pedidoInterpreteProcesso.pedidoInterprete.clienteEmail.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.pedidoInterpreteProcesso.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./pedido-interprete-start-form-init.component.ts"></script>
