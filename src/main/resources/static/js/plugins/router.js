import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Login',
        component: () => import('../components/Login.vue')
    },
    {
        path: '/admin',
        name: 'Admin',
        component: () => import('../components/Admin.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    publicPath:"/",
    routes
})

export default router
