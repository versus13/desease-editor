<template>
    <v-app>
        <router-view></router-view>
    </v-app>
</template>
<script>
    export default {
        computed: {
            currentUser() {
                return this.$store.state.auth.user;
            },
            showAdminBoard() {
                if (this.currentUser && this.currentUser.roles) {
                    return this.currentUser.roles.includes('ROLE_ADMIN');
                }

                return false;
            }
        },
        methods: {
            logOut() {
                this.$store.dispatch('auth/logout');
                this.$router.push('/login');
            }
        }
    };
</script>