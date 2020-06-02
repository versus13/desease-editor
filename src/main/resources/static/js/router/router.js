import Vue from 'vue'
import VueRouter from 'vue-router'
import Admin from '../components/Admin.vue'
import Login from '../components/Login.vue'
import Registration from "../components/Registration.vue";
Vue.use(VueRouter)

const routes = [
    {path: '/', component: Login},
    {path: '/registration', component: Registration},
    {path: '/login', component: Login},
    {path: '/admin', component: Admin}
]
export default new VueRouter({
    mode: 'history',
    routes
})