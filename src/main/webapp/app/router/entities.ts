import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const PedidoInterprete = () => import('@/entities/pedido-interprete/pedido-interprete.vue');
// prettier-ignore
const PedidoInterpreteDetails = () => import('@/entities/pedido-interprete/pedido-interprete-details.vue');
// prettier-ignore
const PedidoInterpreteProcessoDetails = () => import('@/entities/pedido-interprete-processo/pedido-interprete-processo-details.vue');
// prettier-ignore
const PedidoInterpreteProcessoList = () => import('@/entities/pedido-interprete-processo/pedido-interprete-processo-list.vue');
// prettier-ignore
const PedidoInterpreteStartFormInit = () => import('@/entities/pedido-interprete-processo/pedido-interprete-start-form-init.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskMelhorFreelancerDetails = () => import('@/entities/pedido-interprete-processo/task-melhor-freelancer/task-melhor-freelancer-details.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskMelhorFreelancerExecute = () => import('@/entities/pedido-interprete-processo/task-melhor-freelancer/task-melhor-freelancer-execute.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskUnicoFreelancerDisponivelDetails = () => import('@/entities/pedido-interprete-processo/task-unico-freelancer-disponivel/task-unico-freelancer-disponivel-details.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskUnicoFreelancerDisponivelExecute = () => import('@/entities/pedido-interprete-processo/task-unico-freelancer-disponivel/task-unico-freelancer-disponivel-execute.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskDisponibilidadeFreelancerDetails = () => import('@/entities/pedido-interprete-processo/task-disponibilidade-freelancer/task-disponibilidade-freelancer-details.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskDisponibilidadeFreelancerExecute = () => import('@/entities/pedido-interprete-processo/task-disponibilidade-freelancer/task-disponibilidade-freelancer-execute.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskPedidoEmpresaTerciariaDetails = () => import('@/entities/pedido-interprete-processo/task-pedido-empresa-terciaria/task-pedido-empresa-terciaria-details.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskPedidoEmpresaTerciariaExecute = () => import('@/entities/pedido-interprete-processo/task-pedido-empresa-terciaria/task-pedido-empresa-terciaria-execute.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskPagamentoCaucaoDetails = () => import('@/entities/pedido-interprete-processo/task-pagamento-caucao/task-pagamento-caucao-details.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskPagamentoCaucaoExecute = () => import('@/entities/pedido-interprete-processo/task-pagamento-caucao/task-pagamento-caucao-execute.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskReservaServicoDetails = () => import('@/entities/pedido-interprete-processo/task-reserva-servico/task-reserva-servico-details.vue');
// prettier-ignore
const PedidoInterpreteProcesso_TaskReservaServicoExecute = () => import('@/entities/pedido-interprete-processo/task-reserva-servico/task-reserva-servico-execute.vue');
// prettier-ignore
const Freelancer = () => import('@/entities/freelancer/freelancer.vue');
// prettier-ignore
const FreelancerUpdate = () => import('@/entities/freelancer/freelancer-update.vue');
// prettier-ignore
const FreelancerDetails = () => import('@/entities/freelancer/freelancer-details.vue');
// prettier-ignore
const EmpresaTerciaria = () => import('@/entities/empresa-terciaria/empresa-terciaria.vue');
// prettier-ignore
const EmpresaTerciariaUpdate = () => import('@/entities/empresa-terciaria/empresa-terciaria-update.vue');
// prettier-ignore
const EmpresaTerciariaDetails = () => import('@/entities/empresa-terciaria/empresa-terciaria-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/pedido-interprete',
    name: 'PedidoInterprete',
    component: PedidoInterprete,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/pedido-interprete/:pedidoInterpreteId/view',
    name: 'PedidoInterpreteView',
    component: PedidoInterpreteDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/instance/:processInstanceId/view',
    name: 'PedidoInterpreteProcessoView',
    component: PedidoInterpreteProcessoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/instances',
    name: 'PedidoInterpreteProcessoList',
    component: PedidoInterpreteProcessoList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/init',
    name: 'PedidoInterpreteStartFormInit',
    component: PedidoInterpreteStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskMelhorFreelancer/:taskInstanceId/view',
    name: 'PedidoInterpreteProcesso_TaskMelhorFreelancerDetails',
    component: PedidoInterpreteProcesso_TaskMelhorFreelancerDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskMelhorFreelancer/:taskInstanceId/execute',
    name: 'PedidoInterpreteProcesso_TaskMelhorFreelancerExecute',
    component: PedidoInterpreteProcesso_TaskMelhorFreelancerExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskUnicoFreelancerDisponivel/:taskInstanceId/view',
    name: 'PedidoInterpreteProcesso_TaskUnicoFreelancerDisponivelDetails',
    component: PedidoInterpreteProcesso_TaskUnicoFreelancerDisponivelDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskUnicoFreelancerDisponivel/:taskInstanceId/execute',
    name: 'PedidoInterpreteProcesso_TaskUnicoFreelancerDisponivelExecute',
    component: PedidoInterpreteProcesso_TaskUnicoFreelancerDisponivelExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskDisponibilidadeFreelancer/:taskInstanceId/view',
    name: 'PedidoInterpreteProcesso_TaskDisponibilidadeFreelancerDetails',
    component: PedidoInterpreteProcesso_TaskDisponibilidadeFreelancerDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskDisponibilidadeFreelancer/:taskInstanceId/execute',
    name: 'PedidoInterpreteProcesso_TaskDisponibilidadeFreelancerExecute',
    component: PedidoInterpreteProcesso_TaskDisponibilidadeFreelancerExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskPedidoEmpresaTerciaria/:taskInstanceId/view',
    name: 'PedidoInterpreteProcesso_TaskPedidoEmpresaTerciariaDetails',
    component: PedidoInterpreteProcesso_TaskPedidoEmpresaTerciariaDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskPedidoEmpresaTerciaria/:taskInstanceId/execute',
    name: 'PedidoInterpreteProcesso_TaskPedidoEmpresaTerciariaExecute',
    component: PedidoInterpreteProcesso_TaskPedidoEmpresaTerciariaExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskPagamentoCaucao/:taskInstanceId/view',
    name: 'PedidoInterpreteProcesso_TaskPagamentoCaucaoDetails',
    component: PedidoInterpreteProcesso_TaskPagamentoCaucaoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskPagamentoCaucao/:taskInstanceId/execute',
    name: 'PedidoInterpreteProcesso_TaskPagamentoCaucaoExecute',
    component: PedidoInterpreteProcesso_TaskPagamentoCaucaoExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskReservaServico/:taskInstanceId/view',
    name: 'PedidoInterpreteProcesso_TaskReservaServicoDetails',
    component: PedidoInterpreteProcesso_TaskReservaServicoDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/PedidoInterpreteProcesso/task/TaskReservaServico/:taskInstanceId/execute',
    name: 'PedidoInterpreteProcesso_TaskReservaServicoExecute',
    component: PedidoInterpreteProcesso_TaskReservaServicoExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/freelancer',
    name: 'Freelancer',
    component: Freelancer,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/freelancer/new',
    name: 'FreelancerCreate',
    component: FreelancerUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/freelancer/:freelancerId/edit',
    name: 'FreelancerEdit',
    component: FreelancerUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/freelancer/:freelancerId/view',
    name: 'FreelancerView',
    component: FreelancerDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/empresa-terciaria',
    name: 'EmpresaTerciaria',
    component: EmpresaTerciaria,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/empresa-terciaria/new',
    name: 'EmpresaTerciariaCreate',
    component: EmpresaTerciariaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/empresa-terciaria/:empresaTerciariaId/edit',
    name: 'EmpresaTerciariaEdit',
    component: EmpresaTerciariaUpdate,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/empresa-terciaria/:empresaTerciariaId/view',
    name: 'EmpresaTerciariaView',
    component: EmpresaTerciariaDetails,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
