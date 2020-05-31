<template>
    <div>
        <v-content>
            <v-container
                    class="fill-height"
                    fluid
            >
                <v-row
                        align="center"
                        justify="center"
                >
                    <v-col
                            cols="12"
                            sm="8"
                            md="4"
                    >
                        <v-card class="elevation-12">
                            <v-toolbar
                                    color="primary"
                                    dark
                                    flat
                            >
                                <v-toolbar-title>Login</v-toolbar-title>
                                <v-spacer></v-spacer>
                            </v-toolbar>
                            <v-card-text>
                                <v-form>
                                    <v-text-field
                                            label="Login"
                                            name="login"
                                            v-model="user.login"
                                            prepend-icon="mdi-account-tie"
                                            type="text"
                                    ></v-text-field>

                                    <v-text-field
                                            id="password"
                                            label="Password"
                                            name="password"
                                            v-model="user.password"
                                            prepend-icon="mdi-lock"
                                            type="password"
                                    ></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>

                                <v-spacer></v-spacer>
                                <v-row>
                                    <v-btn @click="onRegister">Зарегистрироваться</v-btn>
                                    <v-btn @click="login">Login</v-btn>
                                </v-row>

                            </v-card-actions>
                        </v-card>
                    </v-col>
                </v-row>
            </v-container>
        </v-content>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data: () => ({
            user:{
                login:"",
                password:""
            }
        }),
        methods: {
            login(e) {
                this.$store.dispatch("login",this.user).then(data => {
                    // if(data === "")
                })
            },
            onRegister(e){
                this.$router.push("/registration")
            }
        }
    }
</script>

<style scoped>

</style>