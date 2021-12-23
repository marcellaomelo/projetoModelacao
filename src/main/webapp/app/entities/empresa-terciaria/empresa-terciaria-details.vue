<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="empresaTerciaria">
        <h2 class="jh-entity-heading" data-cy="empresaTerciariaDetailsHeading">
          <span v-text="$t('projetoModelacaoApp.empresaTerciaria.detail.title')">EmpresaTerciaria</span> {{ empresaTerciaria.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('projetoModelacaoApp.empresaTerciaria.interpreteEmpresaName')">Interprete Empresa Name</span>
          </dt>
          <dd>
            <span>{{ empresaTerciaria.interpreteEmpresaName }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.empresaTerciaria.interpreteEmpresaDataDisponivel')"
              >Interprete Empresa Data Disponivel</span
            >
          </dt>
          <dd>
            <span>{{ empresaTerciaria.interpreteEmpresaDataDisponivel }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.empresaTerciaria.pedidoInterpreteEmpresa')">Pedido Interprete Empresa</span>
          </dt>
          <dd>
            <span>{{ empresaTerciaria.pedidoInterpreteEmpresa }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="empresaTerciaria.id"
          :to="{ name: 'EmpresaTerciariaEdit', params: { empresaTerciariaId: empresaTerciaria.id } }"
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

<script lang="ts" src="./empresa-terciaria-details.component.ts"></script>
