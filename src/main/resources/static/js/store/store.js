import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";
import { auth } from './auth/auth.module'
import Admin from './admin.module'
axios.defaults.headers.post["Content-Type"] = "text/json; charset=utf-8";
const API_URL = 'http://localhost:9000/api/auth/';
Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        auth,
        Admin
    }
})
