<template>
  <div>
    <h2 class="jh-entity-heading" data-cy="pedidoInterpreteProcessoDetailsHeading">
      <span v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.home.title')">PedidoInterpreteProcesso</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.home.refreshListLabel')">Refresh List</span>
        </button>

        <router-link :to="`/process-definition/PedidoInterpreteProcesso/init`" tag="button" class="btn btn-primary mr-2">
          <font-awesome-icon icon="plus"></font-awesome-icon>
          <span v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.home.createLabel')">
            Create a new Travel Plan Process Instance
          </span>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && pedidoInterpreteProcessoList && pedidoInterpreteProcessoList.length === 0">
      <span v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.home.notFound')">No pedidoInterpreteProcesso found</span>
    </div>
    <div class="table-responsive" v-if="pedidoInterpreteProcessoList && pedidoInterpreteProcessoList.length > 0">
      <table class="table table-striped" aria-describedby="pedidoInterpreteProcessoList">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span>Process Instance</span></th>
            <th scope="row"><span>Pedido Interprete</span></th>
            <th scope="row"><span>Status</span></th>
            <th scope="row"><span>Start Date</span></th>
            <th scope="row"><span>End Date</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="pedidoInterpreteProcesso in pedidoInterpreteProcessoList" :key="pedidoInterpreteProcesso.id" data-cy="entityTable">
            <td>{{ pedidoInterpreteProcesso.id }}</td>
            <td>
              <div v-if="pedidoInterpreteProcesso.processInstance">
                <router-link
                  :to="`/process-definition/PedidoInterpreteProcesso/instance/${pedidoInterpreteProcesso.processInstance.id}/view`"
                >
                  {{ pedidoInterpreteProcesso.processInstance.businessKey }}
                </router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterpreteProcesso.pedidoInterprete">
                <router-link
                  :to="{ name: 'PedidoInterpreteView', params: { pedidoInterpreteId: pedidoInterpreteProcesso.pedidoInterprete.id } }"
                  >{{ pedidoInterpreteProcesso.pedidoInterprete.id }}</router-link
                >
              </div>
            </td>
            <td>
              <akip-show-process-instance-status
                :status="pedidoInterpreteProcesso.processInstance.status"
              ></akip-show-process-instance-status>
            </td>
            <td>
              {{
                pedidoInterpreteProcesso.processInstance.startDate
                  ? $d(Date.parse(pedidoInterpreteProcesso.processInstance.startDate), 'short')
                  : ''
              }}
            </td>
            <td>
              {{
                pedidoInterpreteProcesso.processInstance.endDate
                  ? $d(Date.parse(pedidoInterpreteProcesso.processInstance.endDate), 'short')
                  : ''
              }}
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="`/process-definition/PedidoInterpreteProcesso/instance/${pedidoInterpreteProcesso.processInstance.id}/view`"
                  tag="button"
                  class="btn btn-info btn-sm details"
                  data-cy="entityDetailsButton"
                >
                  <font-awesome-icon icon="eye"></font-awesome-icon>
                  <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
      <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
    </button>
  </div>
</template>

<script lang="ts" src="./pedido-interprete-processo-list.component.ts"></script>
