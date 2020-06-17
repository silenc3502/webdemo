<template>
  <div class="home">
    <div id="header">
      <router-link :to="{ name: 'About' }" class="nav-link" active-class="active">
        About us
      </router-link>
      <router-link :to="{ name: 'Test' }" class="nav-link" active-class="active">
        Test
      </router-link>
    </div>
  </div>
</template>

<script>

export default {
  name: 'Home',
  components: {
  }
}
</script>

<style scoped>
div {
  border: 1px solid #ccc
}
#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
}
#contents {
  max-width: 64%;
  padding: 20px;
  margin-bottom: 20px;
  float: left;
}
#sidebar {
  width: 32%;
  padding: 20px;
  float: right;
  margin-bottom: 20px;
}
#footer {
  clear: both;
  padding: 20px;
}
</style>
