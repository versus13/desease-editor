<template>
    <v-card
            flat
            class="py-12">
<!--                создается пустой объект для заполнения.
pId - parent id - получается при добавлении вложенности, либо если работаешь уже не с первой вложенностью -->
                    <v-btn small @click="addComponent">добавить симптом</v-btn>

    </v-card>
</template>

<script>
    export default {
        name: "SelectBtnPanel",
        data: () => ({
        }),
        methods: {
            addComponent() {
                this.$emit("addComponent")
            },
            addChildComponent() {
                this.$emit("addChildComponent")
            },
        }
    }
</script>

<style scoped>

</style>