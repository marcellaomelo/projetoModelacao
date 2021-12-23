<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="projetoModelacaoApp.freelancer.home.createOrEditLabel"
          data-cy="FreelancerCreateUpdateHeading"
          v-text="$t('projetoModelacaoApp.freelancer.home.createOrEditLabel')"
        >
          Create or edit a Freelancer
        </h2>
        <div>
          <div class="form-group" v-if="freelancer.id">
            <label for="id" v-text="$t('global.field.id')">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="freelancer.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" v-text="$t('projetoModelacaoApp.freelancer.freelancerName')" for="freelancer-freelancerName"
              >Freelancer Name</label
            >
            <input
              type="text"
              class="form-control"
              name="freelancerName"
              id="freelancer-freelancerName"
              data-cy="freelancerName"
              :class="{ valid: !$v.freelancer.freelancerName.$invalid, invalid: $v.freelancer.freelancerName.$invalid }"
              v-model="$v.freelancer.freelancerName.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('projetoModelacaoApp.freelancer.freelancerDataDisponivel')"
              for="freelancer-freelancerDataDisponivel"
              >Freelancer Data Disponivel</label
            >
            <b-input-group class="mb-3">
              <b-input-group-prepend>
                <b-form-datepicker
                  aria-controls="freelancer-freelancerDataDisponivel"
                  v-model="$v.freelancer.freelancerDataDisponivel.$model"
                  name="freelancerDataDisponivel"
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
                id="freelancer-freelancerDataDisponivel"
                data-cy="freelancerDataDisponivel"
                type="text"
                class="form-control"
                name="freelancerDataDisponivel"
                :class="{
                  valid: !$v.freelancer.freelancerDataDisponivel.$invalid,
                  invalid: $v.freelancer.freelancerDataDisponivel.$invalid,
                }"
                v-model="$v.freelancer.freelancerDataDisponivel.$model"
              />
            </b-input-group>
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('projetoModelacaoApp.freelancer.existeFreelancerDisponivel')"
              for="freelancer-existeFreelancerDisponivel"
              >Existe Freelancer Disponivel</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="existeFreelancerDisponivel"
              id="freelancer-existeFreelancerDisponivel"
              data-cy="existeFreelancerDisponivel"
              :class="{
                valid: !$v.freelancer.existeFreelancerDisponivel.$invalid,
                invalid: $v.freelancer.existeFreelancerDisponivel.$invalid,
              }"
              v-model="$v.freelancer.existeFreelancerDisponivel.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('projetoModelacaoApp.freelancer.existeMaisQueUmFreelancerDisponivel')"
              for="freelancer-existeMaisQueUmFreelancerDisponivel"
              >Existe Mais Que Um Freelancer Disponivel</label
            >
            <input
              type="checkbox"
              class="form-check"
              name="existeMaisQueUmFreelancerDisponivel"
              id="freelancer-existeMaisQueUmFreelancerDisponivel"
              data-cy="existeMaisQueUmFreelancerDisponivel"
              :class="{
                valid: !$v.freelancer.existeMaisQueUmFreelancerDisponivel.$invalid,
                invalid: $v.freelancer.existeMaisQueUmFreelancerDisponivel.$invalid,
              }"
              v-model="$v.freelancer.existeMaisQueUmFreelancerDisponivel.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('projetoModelacaoApp.freelancer.anosExperienciaFreelancer')"
              for="freelancer-anosExperienciaFreelancer"
              >Anos Experiencia Freelancer</label
            >
            <input
              type="number"
              class="form-control"
              name="anosExperienciaFreelancer"
              id="freelancer-anosExperienciaFreelancer"
              data-cy="anosExperienciaFreelancer"
              :class="{
                valid: !$v.freelancer.anosExperienciaFreelancer.$invalid,
                invalid: $v.freelancer.anosExperienciaFreelancer.$invalid,
              }"
              v-model.number="$v.freelancer.anosExperienciaFreelancer.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('projetoModelacaoApp.freelancer.freelancerEscolhido')"
              for="freelancer-freelancerEscolhido"
              >Freelancer Escolhido</label
            >
            <input
              type="text"
              class="form-control"
              name="freelancerEscolhido"
              id="freelancer-freelancerEscolhido"
              data-cy="freelancerEscolhido"
              :class="{ valid: !$v.freelancer.freelancerEscolhido.$invalid, invalid: $v.freelancer.freelancerEscolhido.$invalid }"
              v-model="$v.freelancer.freelancerEscolhido.$model"
            />
          </div>
          <div class="form-group">
            <label
              class="form-control-label"
              v-text="$t('projetoModelacaoApp.freelancer.freelancerUnicoEscolhido')"
              for="freelancer-freelancerUnicoEscolhido"
              >Freelancer Unico Escolhido</label
            >
            <input
              type="text"
              class="form-control"
              name="freelancerUnicoEscolhido"
              id="freelancer-freelancerUnicoEscolhido"
              data-cy="freelancerUnicoEscolhido"
              :class="{ valid: !$v.freelancer.freelancerUnicoEscolhido.$invalid, invalid: $v.freelancer.freelancerUnicoEscolhido.$invalid }"
              v-model="$v.freelancer.freelancerUnicoEscolhido.$model"
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
            :disabled="$v.freelancer.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./freelancer-update.component.ts"></script>
