import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import 'jquery/dist/jquery.min'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'

import './element'

/**导入element相关自定义文件 */
import './assets/global.css'

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

import Router from 'vue-router'

