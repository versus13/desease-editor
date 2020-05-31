import Vue from 'vue'
import VueRouter from 'vue-router'
import Admin from '../components/Admin.vue'
import Login from '../components/Login.vue'
Vue.use(VueRouter)

const routes = [
    {path: '/', component: Admin},
    {path: '/auth', component: Login}
]
export default new VueRouter({
    mode: 'history',
    routes
})