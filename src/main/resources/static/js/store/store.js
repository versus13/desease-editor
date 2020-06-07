import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";
import Auth  from './auth/auth.module'
import Admin from './admin.module'
axios.defaults.headers.post["Content-Type"] = "text/json; charset=utf-8";
const API_URL = 'http://localhost:8080/api/auth/';
Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        Auth,
        Admin
    }
})
