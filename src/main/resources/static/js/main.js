import Vue from 'vue'
import App from 'pages/App.vue'
import vuetify from 'plugins/vuetify'
import 'vuetify/dist/vuetify.min.css'
import router from 'router/router'
import '@babel/polyfill'
import store from 'store/store'
new Vue({
    el: '#app',
    vuetify,
    router,
    store,
    render: a => a(App)
})