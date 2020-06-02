<template>
    <div>
        <v-btn small @click="addComponent">добавить симптом</v-btn>
        <v-spacer></v-spacer>
        <v-btn small @click="logout">Logout</v-btn>
        <Tree @reload="reload"
              @update="update"
              @addComponent="addComponent"
              :item="item"
              :index="index"
              v-for="(item, index) in treeData"
              :key="item.id"
              @delete="removeOne"/>
    </div>
</template>

<script>
    import Tree from "./sub-components/Tree.vue";

    export default {
        name: 'Admin',
        components: {
            Tree
        },

        data: () => ({
            treeData: [],
            flat: [],
            description: [],
            ids: []
        }),
        created() {
            this.$store.dispatch("getAll").then(data => {
                console.log(data)
                this.treeData = this.buildTree(data)
                console.log(this.treeData)
            })
        },
        methods: {
            buildTree(arr) {
                var tree = [],
                    mappedArr = {},
                    arrElem,
                    mappedElem;

                // First map the nodes of the array to an object -> create a hash table.
                for (var i = 0, len = arr.length; i < len; i++) {
                    arrElem = arr[i];
                    mappedArr[arrElem.id] = arrElem;
                    mappedArr[arrElem.id]['children'] = [];
                }


                for (var id in mappedArr) {
                    if (mappedArr.hasOwnProperty(id)) {
                        mappedElem = mappedArr[id];
                        // If the element is not at the root level, add it to its parent array of children.
                        if (mappedElem.pId) {
                            mappedArr[mappedElem['pId']]['children'].push(mappedElem);
                        }
                        // If the element is at the root level, add it to first level elements array.
                        else {
                            tree.push(mappedElem);
                        }
                    }
                }
                console.log(tree)
                return tree;
            },
            addComponent() {

                const task = {
                    pId: null,
                    title: 'Вопрос',
                    titleInput: '',
                    description: 'Ответ',
                    descriptionInput: '',
                    children: []
                }
                this.$store.dispatch("add", task).then(data => {
                    data.children = []
                    this.treeData.push(data)
                })
                console.log(this.treeData)
            },
            update(item) {
                this.$store.dispatch("update", item).then(data => {
                    this.treeData.splice(this.treeData.indexOf(item), 1, data);
                })
            },
            removeOne(index) {
                console.log(index)

                this.$store.dispatch("remove", index.id).then(data => {
                    this.treeData.splice(this.treeData.indexOf(index), 1)
                })
            },
            reload() {
                this.$store.dispatch("getAll")
            },
            logout() {
                this.$store.dispatch("logout")
            }
        }
    }
</script>
<style lang="scss">
</style>
