import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Register from "../components/Register.vue";
import Admin from "../components/Admin.vue";
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
        component: Admin
    },

]
export default new VueRouter({
    mode: 'history',
    routes
})