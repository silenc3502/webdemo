<template>
  <div class="test">
    <h1>This is an test page</h1>
    <button v-on:click="reverseMsg">Reverse Message</button>
    <p>{{ message }}</p>
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
    }
  },
  // Vue의 경우엔 객체에 대한 변경을 감지하면 무조건 Rendering을 수행한다.
  // Rendering이란 화면을 그리는 작업이다.
  beforeCreate () {
    alert('Before Create: ' + this.message)
  },
  created () {
    alert('Created: ' + this.message)
  },
  beforeMount () {
    alert('Before Mount: ' + this.message)
  },
  mounted () {
    alert('mounted: ' + this.message)
  },
  beforeUpdate () {
    alert('Before Update: ' + this.message)
  },
  updated () {
    alert('updated: ' + this.message)
  }
}

</script>
