<template>
    <div>
        <v-btn @click="onLogin">
            to main
        </v-btn>
    </div>
</template>

<script>
    export default {
        name: "Home",
        methods:{
            onLogin(){
                this.$router.push("/login")
            }
        }
    }
</script>

<style scoped>

</style>