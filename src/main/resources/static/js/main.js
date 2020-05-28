import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import router from './plugins/router'
Vue.use(VueResource)

new Vue({
    el: '#app',
    router,
    render: a => a(App)
})