import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import vuex from 'vuex'
import vuetify from 'vuetify'
import cookies from 'vue-cookies'

Vue.config.productionTip = false
// state 관리를 하기 위한 vuex
Vue.use(vuex)
Vue.use(cookies)

new Vue({
  router,
  store,
  axios,
  vuex,
  vuetify,
  render: h => h(App),
  components: {
  }
}).$mount('#app')
