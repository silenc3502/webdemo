// focus.directive.js
Vue.directive('focus', {
  inserted: function (el) {
    el.focus()
  }
})
