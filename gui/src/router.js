import Vue from "vue"
import Router from "vue-router"
import Admin from "./views/admin.vue"
import Purchased from "./views/admin/purchased.vue"
import Sold from "./views/admin/sold.vue"
import Profit from "./views/admin/profit.vue"

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [{
    path: "/",
    name: "admin",
    component: Admin,
    children: [{
      path: "business/purchased",
      name: "business/purchased",
      component: Purchased,
    }, {
      path: "business/sold",
      name: "business/sold",
      component: Sold,
    }, {
      path: "business/profit",
      name: "business/profit",
      component: Profit,
    }]
  }]
})
