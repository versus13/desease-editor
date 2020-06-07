import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Register from "../components/Register.vue";
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        component: Login
    },
    {
        path: '/register',
        component: Register
    },
    {
        path: '/admin',
        name: 'admin',
        // lazy-loaded
        component: () => import('../components/Admin.vue')
    },

]
export default new VueRouter({
    mode: 'history',
    routes
})