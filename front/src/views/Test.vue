<template>
  <div class="test">
    <h1>This is an test page</h1>
    <button v-on:click="reverseMsg">Reverse Message</button>
    <p>{{ message }}</p>
    <b>count: {{ this.$store.state.count }}</b><br>
    <b>count^2: {{ this.$store.getters.count }}</b><br>
    <b>weight: {{ this.$store.getters.weight }}</b><br>
    <b>random: {{ this.$store.getters.random }}</b><br>
    <input type="button" @click="increment()" value="increment"/>
    <input type="button" @click="decrement()" value="decrement"/>
    <input type="button" @click="randomNumber()" value="random"/><br>
    <!-- Component를 만든다는 것은 결국 나만의 커스텀 HTML 태그를 만든다는 것을 의미한다. -->
    <local-component v-bind:num="value"></local-component>
    <button v-on:click="plus">Click!</button><br>
    <global-component v-bind:initial-counter="counter"></global-component>
  </div>
</template>

<script>

import Vue from 'vue'
import cookies from 'vue-cookies'
import LocalComponent from '../components/LocalComponent'
// 추가할 곳에서 Global Component에 해당하는 녀석을 import 해준다.
import GlobalComponent from '../components/GlobalComponent'

// 실제 Vue 객체에 전역적으로 사용하는 Component임을 알리도록 한다.
Vue.component(GlobalComponent.name, GlobalComponent)
Vue.use(cookies)

export default {
  data () {
    return {
      cnt: 0,
      count: 7,
      counter: 7000,
      value: 3000,
      message: '안녕 난 뷰야 ~'
    }
  },
  components: {
    // Local Component의 특징은 이런식으로
    // 등록한 녀석들만 사용할 수 있게 된다.
    // 즉 다른 녀석들은 사용이 불가능하다.
    // Global Component는 이런식으로 추가할 필요가 없다.
    // Vue 객체 전역에 자동으로 컴포넌트가 추가된다.
    'local-component': LocalComponent
  },
  methods: {
    reverseMsg: function () {
      // 현재 가지고 있는 메시지를 split을 통해서 다 쪼갠다.
      // 그리고 reverse를 통해서 전부 순서를 뒤집는다.
      // 최종적으로 join을 통해 다시 결합한다.
      this.message = this.message.split('').reverse().join()
      // $가 붙으면 Vue 내장 함수를 사용하겠다는 의미가 된다.
      // 객체가 파괴되면 우리가 어떠한 요청을 넣어도 응답하지 않게 된다.
      // this.$destroy()
    },
    increment: function () {
      this.$store.commit('increment')
      // 먼저 기능을 연동하고 이후 상태값 저장하는 것을 한 번 살펴보도록 한다(F5)
      this.$cookies.set('value', this.$store.state.count)
      console.log(this.$cookies.get('value'))
    },
    decrement: function () {
      this.$store.commit('decrement')
      this.$cookies.set('value', this.$store.state.count, '24h')
      console.log(this.$cookies.get('value'))
    },
    randomNumber: function () {
      this.$store.dispatch('generateRandomNumber')
    },
    plus: function () {
      this.value++
    }
  },
  // Vue의 경우엔 객체에 대한 변경을 감지하면 무조건 Rendering을 수행한다.
  // Rendering이란 화면을 그리는 작업이다.
  beforeCreate () {
    // alert('Before Create: ' + this.message)
  },
  created () {
    // this.$cookies에 'value' 키값 형태로 값이 저장되어 있다.
    // 하지만 이것을 store에 있는 count에 복원해주지 않았기 때문에
    // 상태값이 저장되지 않았던 것이다.
    this.$store.state.count = this.$cookies.get('value')
    // alert('Created: ' + this.message)
  },
  beforeMount () {
    // alert('Before Mount: ' + this.message)
  },
  mounted () {
    // alert('mounted: ' + this.message)
  },
  // 실제 렌더링은 updated()가 온전히 끝나는 시점에 진행된다.
  // 이 사이에서 값을 바꿔줄 필요가 있다면
  // beforeUpdate나 updated에서 수정해주면 렌더링에 적용을 할 수 있다.
  beforeUpdate () {
    // alert('Before Update: ' + this.message)
  },
  updated () {
    // alert('updated: ' + this.message)
  },
  beforeDestroy () {
    // alert('Before Destroy: ' + this.message)
  },
  destroyed () {
    // alert('destroyed: ' + this.message)
    // 동영상, 오디오 같은 대규모 접속 시스템에서
    // 대규모 대용량 스트림들이 지나다니게 되면 객체가 파괴될 가능성이 있다.
    // 만약 그렇게 객체가 파괴될 가능성이 있다면
    // 여기서 객체의 파괴를 감지하고
    // 다시 서비스를 재개할 수 있도록 준비해줘야 한다.
  }
}

</script>
