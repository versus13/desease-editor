<template>
    <div>
        <v-content>
            <v-alert v-if="message" :type="successful ? 'success' : 'error'">{{message.message}}</v-alert>
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
                                <v-toolbar-title>Зарегистрироваться</v-toolbar-title>
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
                                            id="email"
                                            label="E-mail"
                                            name="email"
                                            v-model="user.email"
                                            prepend-icon="mdi-lock"
                                    ></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>

                                <v-spacer></v-spacer>
                                <v-btn @click="handleRegister">Зарегистрироваться</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-col>
                </v-row>
            </v-container>
        </v-content>
    </div>
</template>

<script>
    import User from '../components/models/user'

    export default {
        name: 'Register',
        data() {
            return {
                user: new User('', '', ''),
                submitted: false,
                successful: false,
                message: ''
            };
        },
        computed: {
            loggedIn() {
                return this.$store.state.auth.status.loggedIn;
            }
        },
        mounted() {
            if (this.loggedIn) {
                this.$router.push('/admin');
            }
        },
        methods: {
            handleRegister() {
                if (this.user.username && this.user.password && this.user.email) {
                    this.$store.dispatch('auth/register', this.user).then(
                        data => {
                            this.message = data.message;
                            this.successful = true;
                            this.$router.push("/")
                        },
                        error => {
                            this.message =
                                (error.response && error.response.data) ||
                                error.message ||
                                error.toString();
                            this.successful = false;
                        }
                    );
                }
            }
        }
    };
</script>

<style scoped>
    label {
        display: block;
        margin-top: 10px;
    }

    .card-container.card {
        max-width: 350px !important;
        padding: 40px 40px;
    }

    .card {
        background-color: #f7f7f7;
        padding: 20px 25px 30px;
        margin: 0 auto 25px;
        margin-top: 50px;
        -moz-border-radius: 2px;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    }

    .profile-img-card {
        width: 96px;
        height: 96px;
        margin: 0 auto 10px;
        display: block;
        -moz-border-radius: 50%;
        -webkit-border-radius: 50%;
        border-radius: 50%;
    }
</style>