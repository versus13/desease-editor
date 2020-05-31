import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";
axios.defaults.headers.post["Content-Type"] = "text/json; charset=utf-8";
Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        fields:[]
    },
    mutations: {
        all(state, payload){
            state.fields = payload;
        }
    },
    actions: {
        getAll: ({commit}, message) => {
            return axios.get("http://localhost:9000/admin/getAll")
                .then(response => {
                    return response.data;
                })
        },
        add: ({commit}, message) => {
            return axios.post("http://localhost:9000/admin/create", message)
                .then(response => {
                    console.log(response.data)
                    return response.data;
                })
        },
        update: ({commit}, field) => {
            return axios.put("http://localhost:9000/admin/"+ field.id, field)
                .then(response => {
                    return response.data;
                })
        },
        remove: ({commit}, id) => {
            return axios.delete("http://localhost:9000/admin/"+ id)
                .then(response => {
                    return response.data;
                })
        }
    },
    modules: {
    }
})
