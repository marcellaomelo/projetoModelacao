<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="pedidoInterpreteProcesso.processInstance">
        <h2 class="jh-entity-heading" data-cy="pedidoInterpreteProcessoDetailsHeading">
          <span v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.detail.title')">PedidoInterpreteProcesso</span>
          {{ pedidoInterpreteProcesso.id }}
        </h2>
        <akip-show-process-instance :processInstance="pedidoInterpreteProcesso.processInstance">
          <template v-slot:title>
            <span v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.detail.title')">PedidoInterpreteProcesso</span> #{{
              pedidoInterpreteProcesso.id
            }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="pedidoInterpreteProcesso.pedidoInterprete">
              <h5 class="card-header">
                <span class="title"> Pedido Interprete #{{ pedidoInterpreteProcesso.pedidoInterprete.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.dataPedido')"
                    >dataPedido</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="dataPedido"
                    id="pedido-interprete-dataPedido"
                    data-cy="dataPedido"
                    v-model="pedidoInterpreteProcesso.pedidoInterprete.dataPedido"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.localTuristicoPedido')"
                    >localTuristicoPedido</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="localTuristicoPedido"
                    id="pedido-interprete-localTuristicoPedido"
                    data-cy="localTuristicoPedido"
                    v-model="pedidoInterpreteProcesso.pedidoInterprete.localTuristicoPedido"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.clienteName')"
                    >clienteName</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="clienteName"
                    id="pedido-interprete-clienteName"
                    data-cy="clienteName"
                    v-model="pedidoInterpreteProcesso.pedidoInterprete.clienteName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.clienteEmail')"
                    >clienteEmail</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="clienteEmail"
                    id="pedido-interprete-clienteEmail"
                    data-cy="clienteEmail"
                    v-model="pedidoInterpreteProcesso.pedidoInterprete.clienteEmail"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.freelancerNumeroReserva')"
                    >freelancerNumeroReserva</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancerNumeroReserva"
                    id="pedido-interprete-freelancerNumeroReserva"
                    data-cy="freelancerNumeroReserva"
                    v-model="pedidoInterpreteProcesso.pedidoInterprete.freelancerNumeroReserva"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.empresaTerciariaNumeroReserva')"
                    >empresaTerciariaNumeroReserva</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="empresaTerciariaNumeroReserva"
                    id="pedido-interprete-empresaTerciariaNumeroReserva"
                    data-cy="empresaTerciariaNumeroReserva"
                    v-model="pedidoInterpreteProcesso.pedidoInterprete.empresaTerciariaNumeroReserva"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.precoReserva')"
                    >precoReserva</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="precoReserva"
                    id="pedido-interprete-precoReserva"
                    data-cy="precoReserva"
                    v-model="pedidoInterpreteProcesso.pedidoInterprete.precoReserva"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.reservarServico')"
                    >reservarServico</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="reservarServico"
                    id="pedido-interprete-reservarServico"
                    data-cy="reservarServico"
                    v-model="pedidoInterpreteProcesso.pedidoInterprete.reservarServico"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.confirmacaoReserva')"
                    >confirmacaoReserva</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="confirmacaoReserva"
                    id="pedido-interprete-confirmacaoReserva"
                    data-cy="confirmacaoReserva"
                    v-model="pedidoInterpreteProcesso.pedidoInterprete.confirmacaoReserva"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.freelancer')"
                    for="pedido-interprete-processo-freelancer"
                    >Freelancer</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.freelancer.freelancername"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.freelancer')"
                    for="pedido-interprete-processo-freelancer"
                    >Freelancer</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.freelancer.freelancerdataDisponivel"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.freelancer')"
                    for="pedido-interprete-processo-freelancer"
                    >Freelancer</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.freelancer.existeFreelancerDisponivel"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.freelancer')"
                    for="pedido-interprete-processo-freelancer"
                    >Freelancer</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.freelancer.existeMaisQueUmFreelancerDisponivel"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.freelancer')"
                    for="pedido-interprete-processo-freelancer"
                    >Freelancer</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.freelancer.anosExperienciaFreelancer"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.freelancer')"
                    for="pedido-interprete-processo-freelancer"
                    >Freelancer</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.freelancer.freelancerEscolhido"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.freelancer')"
                    for="pedido-interprete-processo-freelancer"
                    >Freelancer</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.freelancer"
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.freelancer.freelancerUnicoEscolhido"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="freelancer"
                    id="pedido-interprete-freelancer"
                    data-cy="freelancer"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.empresaTerciaria')"
                    for="pedido-interprete-processo-empresaTerciaria"
                    >Empresa Terciaria</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria"
                    readonly
                    type="text"
                    class="form-control"
                    name="empresaTerciaria"
                    id="pedido-interprete-empresaTerciaria"
                    data-cy="empresaTerciaria"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria.interpreteEmpresaName"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="empresaTerciaria"
                    id="pedido-interprete-empresaTerciaria"
                    data-cy="empresaTerciaria"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.empresaTerciaria')"
                    for="pedido-interprete-processo-empresaTerciaria"
                    >Empresa Terciaria</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria"
                    readonly
                    type="text"
                    class="form-control"
                    name="empresaTerciaria"
                    id="pedido-interprete-empresaTerciaria"
                    data-cy="empresaTerciaria"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria.interpreteEmpresaDataDisponivel"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="empresaTerciaria"
                    id="pedido-interprete-empresaTerciaria"
                    data-cy="empresaTerciaria"
                    value=""
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('projetoModelacaoApp.pedidoInterpreteProcesso.empresaTerciaria')"
                    for="pedido-interprete-processo-empresaTerciaria"
                    >Empresa Terciaria</label
                  >
                  <input
                    v-if="pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria"
                    readonly
                    type="text"
                    class="form-control"
                    name="empresaTerciaria"
                    id="pedido-interprete-empresaTerciaria"
                    data-cy="empresaTerciaria"
                    :value="pedidoInterpreteProcesso.pedidoInterprete.empresaTerciaria.pedidoInterpreteEmpresa"
                  />
                  <input
                    v-else
                    readonly
                    type="text"
                    class="form-control"
                    name="empresaTerciaria"
                    id="pedido-interprete-empresaTerciaria"
                    data-cy="empresaTerciaria"
                    value=""
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./pedido-interprete-processo-details.component.ts"></script>
