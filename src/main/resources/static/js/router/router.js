import Vue from 'vue'
import VueRouter from 'vue-router'
import Admin from '../components/Admin.vue'
import Login from '../components/Login.vue'
import Registration from "../components/Registration.vue";
import Home from "../components/Home.vue";
Vue.use(VueRouter)

const routes = [
    {path: '/', component: Home},
    {path: '/login', component: Login},
    {path: '/registration', component: Registration},
    {path: '/admin', component: Admin}
]
export default new VueRouter({
    mode: 'history',
    routes
})