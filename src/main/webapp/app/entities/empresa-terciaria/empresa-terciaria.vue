<template>
  <div>
    <h2 id="page-heading" data-cy="EmpresaTerciariaHeading">
      <span v-text="$t('projetoModelacaoApp.empresaTerciaria.home.title')" id="empresa-terciaria-heading">Empresa Terciarias</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('projetoModelacaoApp.empresaTerciaria.home.refreshListLabel')">Refresh List</span>
        </button>
        <router-link :to="{ name: 'EmpresaTerciariaCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-empresa-terciaria"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span v-text="$t('projetoModelacaoApp.empresaTerciaria.home.createLabel')"> Create a new Empresa Terciaria </span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && empresaTerciarias && empresaTerciarias.length === 0">
      <span v-text="$t('projetoModelacaoApp.empresaTerciaria.home.notFound')">No empresaTerciarias found</span>
    </div>
    <div class="table-responsive" v-if="empresaTerciarias && empresaTerciarias.length > 0">
      <table class="table table-striped" aria-describedby="empresaTerciarias">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.empresaTerciaria.interpreteEmpresaName')">Interprete Empresa Name</span>
            </th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.empresaTerciaria.interpreteEmpresaDataDisponivel')"
                >Interprete Empresa Data Disponivel</span
              >
            </th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.empresaTerciaria.pedidoInterpreteEmpresa')">Pedido Interprete Empresa</span>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="empresaTerciaria in empresaTerciarias" :key="empresaTerciaria.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'EmpresaTerciariaView', params: { empresaTerciariaId: empresaTerciaria.id } }">{{
                empresaTerciaria.id
              }}</router-link>
            </td>
            <td>{{ empresaTerciaria.interpreteEmpresaName }}</td>
            <td>{{ empresaTerciaria.interpreteEmpresaDataDisponivel }}</td>
            <td>{{ empresaTerciaria.pedidoInterpreteEmpresa }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'EmpresaTerciariaView', params: { empresaTerciariaId: empresaTerciaria.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
                <router-link
                  :to="{ name: 'EmpresaTerciariaEdit', params: { empresaTerciariaId: empresaTerciaria.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                  </button>
                </router-link>
                <b-button
                  v-on:click="prepareRemove(empresaTerciaria)"
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
          id="projetoModelacaoApp.empresaTerciaria.delete.question"
          data-cy="empresaTerciariaDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-empresaTerciaria-heading" v-text="$t('projetoModelacaoApp.empresaTerciaria.delete.question', { id: removeId })">
          Are you sure you want to delete this Empresa Terciaria?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-empresaTerciaria"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeEmpresaTerciaria()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./empresa-terciaria.component.ts"></script>
