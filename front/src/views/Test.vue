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
    <input type="button" @click="randomNumber()" value="random"/>
  </div>
</template>

<script>

export default {
  data () {
    return {
      cnt: 0,
      count: 7,
      message: '안녕 난 뷰야 ~'
    }
  },
  methods: {
    reverseMsg: function () {
      // 현재 가지고 있는 메시지를 split을 통해서 다 쪼갠다.
      // 그리고 reverse를 통해서 전부 순서를 뒤집는다.
      // 최종적으로 join을 통해 다시 결합한다.
      this.message = this.message.split('').reverse().join()
      // $가 붙으면 Vue 내장 함수를 사용하겠다는 의미가 된다.
      // 객체가 파괴되면 우리가 어떠한 요청을 넣어도 응답하지 않게 된다.
      this.$destroy()
    },
    increment: function () {
      this.$store.commit('increment')
      // 먼저 기능을 연동하고 이후 상태값 저장하는 것을 한 번 살펴보도록 한다(F5)
    },
    decrement: function () {
      this.$store.commit('decrement')
    },
    randomNumber: function () {
      this.$store.dispatch('generateRandomNumber')
    }
  },
  // Vue의 경우엔 객체에 대한 변경을 감지하면 무조건 Rendering을 수행한다.
  // Rendering이란 화면을 그리는 작업이다.
  beforeCreate () {
    // alert('Before Create: ' + this.message)
  },
  created () {
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
