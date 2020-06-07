import Vue from 'vue'
import App from 'pages/App.vue'
import vuetify from 'plugins/vuetify'
import 'vuetify/dist/vuetify.min.css'
import router from 'router/router'
import '@babel/polyfill'
import VeeValidate from 'vee-validate';
import store from 'store/store'
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import {
    faHome,
    faUser,
    faUserPlus,
    faSignInAlt,
    faSignOutAlt
} from '@fortawesome/free-solid-svg-icons';

library.add(faHome, faUser, faUserPlus, faSignInAlt, faSignOutAlt);

Vue.config.productionTip = false;
Vue.use(VeeValidate);
Vue.component('font-awesome-icon', FontAwesomeIcon);
new Vue({
    el: '#app',
    vuetify,
    router,
    store,
    render: a => a(App)
})