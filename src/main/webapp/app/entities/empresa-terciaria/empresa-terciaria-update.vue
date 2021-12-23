<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="projetoModelacaoApp.empresaTerciaria.home.createOrEditLabel"
          data-cy="EmpresaTerciariaCreateUpdateHeading"
          v-text="$t('projetoModelacaoApp.empresaTerciaria.home.createOrEditLabel')"
        >
          Create or edit a EmpresaTerciaria
        </h2>
        <div>
          <div class="form-group" v-if="empresaTerciaria.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="empresaTerciaria.id" readonly />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('projetoModelacaoApp.empresaTerciaria.interpreteEmpresaName')"
              for="empresa-terciaria-interpreteEmpresaName"
              >Interprete Empresa Name</label
            >
            <input
              type="text"
              class="form-control"
              name="interpreteEmpresaName"
              id="empresa-terciaria-interpreteEmpresaName"
              data-cy="interpreteEmpresaName"
              :class="{
                valid: !$v.empresaTerciaria.interpreteEmpresaName.$invalid,
                invalid: $v.empresaTerciaria.interpreteEmpresaName.$invalid,
              }"
              v-model="$v.empresaTerciaria.interpreteEmpresaName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('projetoModelacaoApp.empresaTerciaria.interpreteEmpresaDataDisponivel')"
              for="empresa-terciaria-interpreteEmpresaDataDisponivel"
              >Interprete Empresa Data Disponivel</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="empresa-terciaria-interpreteEmpresaDataDisponivel"
                  v-model="$v.empresaTerciaria.interpreteEmpresaDataDisponivel.$model"
                  name="interpreteEmpresaDataDisponivel"
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
                id="empresa-terciaria-interpreteEmpresaDataDisponivel"
                data-cy="interpreteEmpresaDataDisponivel"
                type="text"
                class="form-control"
                name="interpreteEmpresaDataDisponivel"
                :class="{
                  valid: !$v.empresaTerciaria.interpreteEmpresaDataDisponivel.$invalid,
                  invalid: $v.empresaTerciaria.interpreteEmpresaDataDisponivel.$invalid,
                }"
                v-model="$v.empresaTerciaria.interpreteEmpresaDataDisponivel.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('projetoModelacaoApp.empresaTerciaria.pedidoInterpreteEmpresa')"
              for="empresa-terciaria-pedidoInterpreteEmpresa"
              >Pedido Interprete Empresa</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="pedidoInterpreteEmpresa"
              id="empresa-terciaria-pedidoInterpreteEmpresa"
              data-cy="pedidoInterpreteEmpresa"
              :class="{
                valid: !$v.empresaTerciaria.pedidoInterpreteEmpresa.$invalid,
                invalid: $v.empresaTerciaria.pedidoInterpreteEmpresa.$invalid,
              }"
              v-model="$v.empresaTerciaria.pedidoInterpreteEmpresa.$model"
            />
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.empresaTerciaria.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./empresa-terciaria-update.component.ts"></script>
