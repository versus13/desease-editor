<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app id="app">
        <login></login>
    </v-app>
</template>

<script>
    // import MessagesList from 'components/messages/MessageList.vue'
    import Login from "./Login.vue";
    export default {
        components: {
            Login
            // MessagesList
        },
        data() {
            return {
                // messages: frontendData.messages,
                // profile: frontendData.profile
            }
        }
    }
</script>

<style>
</style>