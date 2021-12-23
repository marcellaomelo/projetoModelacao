<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="freelancer">
        <h2 class="jh-entity-heading" data-cy="freelancerDetailsHeading">
          <span v-text="$t('projetoModelacaoApp.freelancer.detail.title')">Freelancer</span> {{ freelancer.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('projetoModelacaoApp.freelancer.freelancerName')">Freelancer Name</span>
          </dt>
          <dd>
            <span>{{ freelancer.freelancerName }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.freelancer.freelancerDataDisponivel')">Freelancer Data Disponivel</span>
          </dt>
          <dd>
            <span>{{ freelancer.freelancerDataDisponivel }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.freelancer.existeFreelancerDisponivel')">Existe Freelancer Disponivel</span>
          </dt>
          <dd>
            <span>{{ freelancer.existeFreelancerDisponivel }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.freelancer.existeMaisQueUmFreelancerDisponivel')"
              >Existe Mais Que Um Freelancer Disponivel</span
            >
          </dt>
          <dd>
            <span>{{ freelancer.existeMaisQueUmFreelancerDisponivel }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.freelancer.anosExperienciaFreelancer')">Anos Experiencia Freelancer</span>
          </dt>
          <dd>
            <span>{{ freelancer.anosExperienciaFreelancer }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.freelancer.freelancerEscolhido')">Freelancer Escolhido</span>
          </dt>
          <dd>
            <span>{{ freelancer.freelancerEscolhido }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.freelancer.freelancerUnicoEscolhido')">Freelancer Unico Escolhido</span>
          </dt>
          <dd>
            <span>{{ freelancer.freelancerUnicoEscolhido }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="freelancer.id"
          :to="{ name: 'FreelancerEdit', params: { freelancerId: freelancer.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./freelancer-details.component.ts"></script>
