<template>
  <div>
    <h2 id="page-heading" data-cy="PedidoInterpreteHeading">
      <span v-text="$t('projetoModelacaoApp.pedidoInterprete.home.title')" id="pedido-interprete-heading">Pedido Interpretes</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('projetoModelacaoApp.pedidoInterprete.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && pedidoInterpretes && pedidoInterpretes.length === 0">
      <span v-text="$t('projetoModelacaoApp.pedidoInterprete.home.notFound')">No pedidoInterpretes found</span>
    </div>
    <div class="table-responsive" v-if="pedidoInterpretes && pedidoInterpretes.length > 0">
      <table class="table table-striped" aria-describedby="pedidoInterpretes">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.dataPedido')">Data Pedido</span></th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.pedidoInterprete.localTuristicoPedido')">Local Turistico Pedido</span>
            </th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.clienteName')">Cliente Name</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.clienteEmail')">Cliente Email</span></th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancerNumeroReserva')">Freelancer Numero Reserva</span>
            </th>
            <th scope="row">
              <span v-text="$t('projetoModelacaoApp.pedidoInterprete.empresaTerciariaNumeroReserva')"
                >Empresa Terciaria Numero Reserva</span
              >
            </th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.precoReserva')">Preco Reserva</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.reservarServico')">Reservar Servico</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.confirmacaoReserva')">Confirmacao Reserva</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.empresaTerciaria')">Empresa Terciaria</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.empresaTerciaria')">Empresa Terciaria</span></th>
            <th scope="row"><span v-text="$t('projetoModelacaoApp.pedidoInterprete.empresaTerciaria')">Empresa Terciaria</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="pedidoInterprete in pedidoInterpretes" :key="pedidoInterprete.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'PedidoInterpreteView', params: { pedidoInterpreteId: pedidoInterprete.id } }">{{
                pedidoInterprete.id
              }}</router-link>
            </td>
            <td>{{ pedidoInterprete.dataPedido }}</td>
            <td>{{ pedidoInterprete.localTuristicoPedido }}</td>
            <td>{{ pedidoInterprete.clienteName }}</td>
            <td>{{ pedidoInterprete.clienteEmail }}</td>
            <td>{{ pedidoInterprete.freelancerNumeroReserva }}</td>
            <td>{{ pedidoInterprete.empresaTerciariaNumeroReserva }}</td>
            <td>{{ pedidoInterprete.precoReserva }}</td>
            <td>{{ pedidoInterprete.reservarServico }}</td>
            <td>{{ pedidoInterprete.confirmacaoReserva }}</td>
            <td>
              <div v-if="pedidoInterprete.freelancer">
                <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                  pedidoInterprete.freelancer.freelancername
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterprete.freelancer">
                <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                  pedidoInterprete.freelancer.freelancerdataDisponivel
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterprete.freelancer">
                <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                  pedidoInterprete.freelancer.existeFreelancerDisponivel
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterprete.freelancer">
                <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                  pedidoInterprete.freelancer.existeMaisQueUmFreelancerDisponivel
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterprete.freelancer">
                <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                  pedidoInterprete.freelancer.anosExperienciaFreelancer
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterprete.freelancer">
                <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                  pedidoInterprete.freelancer.freelancerEscolhido
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterprete.freelancer">
                <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                  pedidoInterprete.freelancer.freelancerUnicoEscolhido
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterprete.empresaTerciaria">
                <router-link :to="{ name: 'EmpresaTerciariaView', params: { EmpresaTerciariaId: pedidoInterprete.empresaTerciaria.id } }">{{
                  pedidoInterprete.empresaTerciaria.interpreteEmpresaName
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterprete.empresaTerciaria">
                <router-link :to="{ name: 'EmpresaTerciariaView', params: { EmpresaTerciariaId: pedidoInterprete.empresaTerciaria.id } }">{{
                  pedidoInterprete.empresaTerciaria.interpreteEmpresaDataDisponivel
                }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="pedidoInterprete.empresaTerciaria">
                <router-link :to="{ name: 'EmpresaTerciariaView', params: { EmpresaTerciariaId: pedidoInterprete.empresaTerciaria.id } }">{{
                  pedidoInterprete.empresaTerciaria.pedidoInterpreteEmpresa
                }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link
                  :to="{ name: 'PedidoInterpreteView', params: { pedidoInterpreteId: pedidoInterprete.id } }"
                  custom
                  v-slot="{ navigate }"
                >
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="projetoModelacaoApp.pedidoInterprete.delete.question"
          data-cy="pedidoInterpreteDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-pedidoInterprete-heading" v-text="$t('projetoModelacaoApp.pedidoInterprete.delete.question', { id: removeId })">
          Are you sure you want to delete this Pedido Interprete?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-pedidoInterprete"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removePedidoInterprete()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./pedido-interprete.component.ts"></script>
