import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0,
    weight: 2,
    random: 0
  },
  // Mutex(뮤텍스)
  mutations: {
    increment (state) {
      state.count++
    },
    decrement (state) {
      state.count--
    },
    successGenerateRandomNumber (state, payload) {
      state.random = payload
    },
    failGenerateRandomNumber () {
      console.log('Error')
    }
  },
  getters: {
    count (state, getters) {
      return Math.pow(state.count, getters.weight)
    },
    weight (state) {
      return state.weight
    },
    random (state) {
      return state.random
    }
  },
  actions: {
    generateRandomNumber ({ commit }) {
      axios.get('http://localhost:7777/random')
        .then((res) => {
          console.log('res = ' + res)
          commit('successGenerateRandomNumber', res.data.randNumber)
        })
    }
  },
  modules: {
  }
})
