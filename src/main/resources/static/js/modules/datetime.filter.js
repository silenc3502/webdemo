// datetime.filter.js
const formatter = new Intl.DateTimeFormat('en-US', {
  year: 'numeric', month: 'long', weak: 'long', day: 'numeric',
  hour: 'numeric', minute: 'numeric', second: 'numeric'
})

Vue.filter('datetime', function (value) {
  if (!value) return ''
  return formatter.format(value)
})
