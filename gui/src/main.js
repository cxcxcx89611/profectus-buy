import Vue from 'vue'
import App from './app.vue'
import router from './router'
import axios from 'axios'

Vue.config.productionTip = false;
Vue.prototype.$ajax = axios;


axios.defaults.withCredentials = false;


new Vue({
  router,
  render: h => h(App),
}).$mount('#app');

console.log("env：", process.env);
