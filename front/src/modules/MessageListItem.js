// MessageListItem.js

export default {
  name: 'MessageListItem',
  template: '<li>{{ item.text }} - {{ item.createAt }} ' +
    '<button @click="deleteClicked"></button></li>',

  props: {
    item: {
      type: Object,
      required: true
    }
  },
  methods: {
    deleteClicked () {
      this.$emit('delete')
    }
  }
}
