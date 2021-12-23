<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="pedidoInterprete">
        <h2 class="jh-entity-heading" data-cy="pedidoInterpreteDetailsHeading">
          <span v-text="$t('projetoModelacaoApp.pedidoInterprete.detail.title')">PedidoInterprete</span> {{ pedidoInterprete.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.dataPedido')">Data Pedido</span>
          </dt>
          <dd>
            <span>{{ pedidoInterprete.dataPedido }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.localTuristicoPedido')">Local Turistico Pedido</span>
          </dt>
          <dd>
            <span>{{ pedidoInterprete.localTuristicoPedido }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.clienteName')">Cliente Name</span>
          </dt>
          <dd>
            <span>{{ pedidoInterprete.clienteName }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.clienteEmail')">Cliente Email</span>
          </dt>
          <dd>
            <span>{{ pedidoInterprete.clienteEmail }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancerNumeroReserva')">Freelancer Numero Reserva</span>
          </dt>
          <dd>
            <span>{{ pedidoInterprete.freelancerNumeroReserva }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.empresaTerciariaNumeroReserva')">Empresa Terciaria Numero Reserva</span>
          </dt>
          <dd>
            <span>{{ pedidoInterprete.empresaTerciariaNumeroReserva }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.precoReserva')">Preco Reserva</span>
          </dt>
          <dd>
            <span>{{ pedidoInterprete.precoReserva }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.reservarServico')">Reservar Servico</span>
          </dt>
          <dd>
            <span>{{ pedidoInterprete.reservarServico }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.confirmacaoReserva')">Confirmacao Reserva</span>
          </dt>
          <dd>
            <span>{{ pedidoInterprete.confirmacaoReserva }}</span>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.freelancer">
              <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                pedidoInterprete.freelancer.freelancername
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.freelancer">
              <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                pedidoInterprete.freelancer.freelancerdataDisponivel
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.freelancer">
              <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                pedidoInterprete.freelancer.existeFreelancerDisponivel
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.freelancer">
              <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                pedidoInterprete.freelancer.existeMaisQueUmFreelancerDisponivel
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.freelancer">
              <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                pedidoInterprete.freelancer.anosExperienciaFreelancer
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.freelancer">
              <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                pedidoInterprete.freelancer.freelancerEscolhido
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.freelancer')">Freelancer</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.freelancer">
              <router-link :to="{ name: 'FreelancerView', params: { FreelancerId: pedidoInterprete.freelancer.id } }">{{
                pedidoInterprete.freelancer.freelancerUnicoEscolhido
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.empresaTerciaria')">Empresa Terciaria</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.empresaTerciaria">
              <router-link :to="{ name: 'EmpresaTerciariaView', params: { EmpresaTerciariaId: pedidoInterprete.empresaTerciaria.id } }">{{
                pedidoInterprete.empresaTerciaria.interpreteEmpresaName
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.empresaTerciaria')">Empresa Terciaria</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.empresaTerciaria">
              <router-link :to="{ name: 'EmpresaTerciariaView', params: { EmpresaTerciariaId: pedidoInterprete.empresaTerciaria.id } }">{{
                pedidoInterprete.empresaTerciaria.interpreteEmpresaDataDisponivel
              }}</router-link>
            </div>
          </dd>
          <dt>
            <span v-text="$t('projetoModelacaoApp.pedidoInterprete.empresaTerciaria')">Empresa Terciaria</span>
          </dt>
          <dd>
            <div v-if="pedidoInterprete.empresaTerciaria">
              <router-link :to="{ name: 'EmpresaTerciariaView', params: { EmpresaTerciariaId: pedidoInterprete.empresaTerciaria.id } }">{{
                pedidoInterprete.empresaTerciaria.pedidoInterpreteEmpresa
              }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./pedido-interprete-details.component.ts"></script>
