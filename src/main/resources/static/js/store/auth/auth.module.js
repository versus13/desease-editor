import axios from "axios";

export default {
    state: {},
    getters: {},
    mutations: {},
    actions: {
        register: ({commit}, credentials) => {
            return axios.post("http://localhost:9000/registration", credentials).then(response => {
                return response.data;
            })
        },
        login: ({ commit }, payload) => {
            return new Promise((resolve, reject) => {
                axios.post("/signin", payload)
                    .then(response => {
                        if (response.data.accessToken) {
                            localStorage.setItem('user', JSON.stringify(response.data));
                        }

                        return response.data;
                    });
            })
        },
        logout:() => {
            localStorage.removeItem('user');
        }
    }
}