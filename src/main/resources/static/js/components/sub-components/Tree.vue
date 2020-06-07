<template>
    <v-container>
        <v-row>

            <v-col>
            <v-text-field dense @change="update(item)"
                          v-model="item.titleInput"
                          :placeholder="item.title"
                          :append-outer-icon="deleteIcon"
                          :append-icon="addIcon"
                          @click:append="addSubOne(item.id)"
                          @click:append-outer="remove(item)"></v-text-field>
            <v-text-field dense @change="update(item)"
                          v-model="item.descriptionInput"
                          :placeholder="item.description"
                          :append-outer-icon="deleteIcon"
                          :append-icon="addIcon"
                          @click:append="addSubOne(item.id)"
                          @click:append-outer="remove(item)"></v-text-field>
                <ul v-if="item.children && item.children.length > 0">
                    <Tree v-for="(child, subIndex) in item.children"
                          v-bind:item="child"
                          :index="subIndex"
                          :key="child.id"
                          :parentItem="item"
                          @update="updateSubOne(child)"
                          @removeSubOne="removeSubOne"></Tree>
                </ul>
<!--                <v-btn small text v-if="parentItem" @click="removeSubOne(item)">удалить узел</v-btn>-->
<!--                <v-btn small text v-if="!parentItem" @click="removeOne(item)">удалить</v-btn>-->
<!--                <v-btn small text @click="addSubOne(item.id)">добавить симптом</v-btn>-->

        </v-col>
        </v-row>
    </v-container>
</template>

<script>
    export default {
        name: "Tree",
        props: {
            item: {
                type: Object,
                required: true
            },
            index: {
                type: Number,
                required: true
            },
            parentItem: {
                required: false
            }
        },
        computed:{
            deleteIcon:{
                get(){
                    if(this.item.children){
                        return this.item.children.length === 0 ?  "mdi-delete" : ""
                    } else {
                        return "mdi-delete";
                    }

                }
            },
            addIcon:{
                get(){
                    if(this.item.children){
                        return this.item.children.length === 0 ?  "mdi-plus" : ""
                    } else {
                        return "mdi-plus";
                    }
                }
            }
        },
        methods: {
            update(item){
              this.$emit("update", item)
            },
            addComponent(item){
                if(!this.parentItem) this.$emit("addComponent")
                    else this.addSubOne(item)
            },
            removeSubOne(item) {
                console.log(item)
                this.parentItem.children.splice(this.parentItem.children.indexOf(item), 1)
                this.$store.dispatch("admin/remove",item.id)
            },
            remove(item){
                if(!this.parentItem) this.removeOne(item)
                else this.removeSubOne(item)
            },
            removeOne(index) {
                this.$emit('delete', index)
            },
            addSubOne(pId) {
                console.log(pId)
                if(!this.parentItem) this.$emit("reload")
                const o = {
                    pId: pId,
                    title: 'Вопрос',
                    titleInput:'',
                    description:'Ответ',
                    descriptionInput:'',
                    children:[]
                }
                this.$store.dispatch("admin/add", o).then(data => {
                    console.log(data)
                    this.item.children = []
                    data.children = []
                    this.item.children.push(data)
                    console.log(this.item)
                })

            },
            updateSubOne(item) {
                console.log(item)
                this.$store.dispatch("admin/update", item).then(data => {
                    // this.treeData.splice(this.treeData.indexOf(item),1, data);
                })

            }
        }
    }
</script>

<style scoped>

</style>