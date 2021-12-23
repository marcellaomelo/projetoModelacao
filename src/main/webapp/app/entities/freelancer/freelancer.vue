<template>
  <div>
    <h2 id="page-heading" data-cy="FreelancerHeading">
      <span v-text="$t('projetoModelacaoApp.freelancer.home.title')" id="freelancer-heading">Freelancers</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('projetoModelacaoApp.freelancer.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'FreelancerCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-freelancer"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('projetoModelacaoApp.freelancer.home.createLabel')"> Create a new Freelancer </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && freelancers && freelancers.length === 0">
      <span v-text="$t('projetoModelacaoApp.freelancer.home.notFound')">No freelancers found</span>
    </div>
    <div class="table-responsive" v-if="freelancers && freelancers.length > 0">
      <table class="table table-striped" aria-describedby="freelancers">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.freelancer.freelancerName')">Freelancer Name</span></th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.freelancer.freelancerDataDisponivel')">Freelancer Data Disponivel</span>
            </th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.freelancer.existeFreelancerDisponivel')">Existe Freelancer Disponivel</span>
            </th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.freelancer.existeMaisQueUmFreelancerDisponivel')"
                >Existe Mais Que Um Freelancer Disponivel</span
              >
            </th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.freelancer.anosExperienciaFreelancer')">Anos Experiencia Freelancer</span>
            </th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.freelancer.freelancerEscolhido')">Freelancer Escolhido</span></th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.freelancer.freelancerUnicoEscolhido')">Freelancer Unico Escolhido</span>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="freelancer in freelancers" :key="freelancer.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'FreelancerView', params: { freelancerId: freelancer.id } }">{{ freelancer.id }}</router-link>
            </td>
            <td>{{ freelancer.freelancerName }}</td>
            <td>{{ freelancer.freelancerDataDisponivel }}</td>
            <td>{{ freelancer.existeFreelancerDisponivel }}</td>
            <td>{{ freelancer.existeMaisQueUmFreelancerDisponivel }}</td>
            <td>{{ freelancer.anosExperienciaFreelancer }}</td>
            <td>{{ freelancer.freelancerEscolhido }}</td>
            <td>{{ freelancer.freelancerUnicoEscolhido }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'FreelancerView', params: { freelancerId: freelancer.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'FreelancerEdit', params: { freelancerId: freelancer.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(freelancer)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="projetoModelacaoApp.freelancer.delete.question"
          data-cy="freelancerDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-freelancer-heading" v-text="$t('projetoModelacaoApp.freelancer.delete.question', { id: removeId })">
          Are you sure you want to delete this Freelancer?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-freelancer"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeFreelancer()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./freelancer.component.ts"></script>
