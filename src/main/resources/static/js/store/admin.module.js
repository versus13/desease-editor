import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";
axios.defaults.headers.post["Content-Type"] = "text/json; charset=utf-8";
const API_URL = 'http://localhost:9000/api/admin';
Vue.use(Vuex);

export const admin = {
    namespaced: true,
    state: {
        fields: []
    },
    mutations: {
        all(state, payload) {
            state.fields = payload;
        }
    },
    actions: {

        getAll: ({commit}, message) => {
            return axios.get(API_URL + "/getAll")
                .then(response => {
                    return response.data;
                })
        },
        add: ({commit}, message) => {
            return axios.post(API_URL + "/add", message)
                .then(response => {
                    console.log(response.data)
                    return response.data;
                })
        },
        update: ({commit}, field) => {
            return axios.put(API_URL + "/update" + field.id, field)
                .then(response => {
                    return response.data;
                })
        },
        remove: ({commit}, id) => {
            return axios.delete(API_URL + "/delete/" + id)
                .then(response => {
                    return response.data;
                })
        }
    },
}
