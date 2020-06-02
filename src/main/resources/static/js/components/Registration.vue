<template>
    <div>
        <v-content>
            <v-container
                    class="fill-height"
                    fluid>
                <v-row
                        align="center"
                        justify="center">
                    <v-col
                            cols="12"
                            sm="8"
                            md="4">
                        <v-card class="elevation-12">
                            <v-toolbar
                                    color="primary"
                                    dark
                                    flat>
                                <v-toolbar-title>Registration</v-toolbar-title>
                                <v-spacer></v-spacer>
                            </v-toolbar>
                            <v-card-text>
                                <v-form>
                                    <v-text-field
                                            label="Login"
                                            name="login"
                                            v-model="user.username"
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

                                    <v-text-field
                                            id="confirmpassword"
                                            label="Confirm password"
                                            name="confirmpassword"
                                            v-model="user.passwordConfirm"
                                            prepend-icon="mdi-lock"
                                            type="password"
                                    ></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>

                                <v-spacer></v-spacer>
                                <v-btn @click="onRegister">Login</v-btn>
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
        name: "Registration",
        data: () => ({
            user:{
                username:"",
                password:"",
                passwordConfirm:""
            },
            confirmpassword:""
        }),
        methods: {
            onRegister(e) {
                this.$store.dispatch("register",this.user).then(data => {
                    if(data === "Вы зарегистрированы!"){
                        this.$router.push("/admin")
                    } else {
                        this.$router.push("/login");
                    }
                    // if(data === "user exists!"){
                    //     this.$router.push("/login");
                    // }
                })
            }
        }
    }
</script>

<style scoped>

</style>