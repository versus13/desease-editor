<template>
    <v-app-bar
            app
            color="primary"
            dark
            flat
    >
        <v-app-bar-nav-icon>

        </v-app-bar-nav-icon>

        <v-toolbar-title v-if="!editDiagnosEnabled">{{diagnosis}}</v-toolbar-title>
        <v-text-field
                v-if="editDiagnosEnabled"
                label="Введите диагноз"
                @change="diagnosEdit"
                v-model="inputDiagnos"
                single-line
                dense
        ></v-text-field>
        <v-btn text x-small color="secondary" fab dark  @click="changeDiagnos" v-if="!editDiagnosEnabled">
            <v-icon color="#fff ">mdi-pencil</v-icon>
        </v-btn>
    </v-app-bar>
</template>

<script>
    export default {
        name: "HeaderBar",
        methods: {
            diagnosEdit(e) {
                this.diagnosis = e;
                this.changeStatusEditDiagnos()
            },
            changeDiagnos() {
                this.inputDiagnos = this.diagnosis;
                this.changeStatusEditDiagnos()
            },
            changeStatusEditDiagnos(){
                this.editDiagnosEnabled = !this.editDiagnosEnabled;
            }

        },

        data: () => ({
            diagnosis: "",
            inputDiagnos: "",
            editDiagnosEnabled:true
        }),
    }
</script>

<style scoped>

</style>