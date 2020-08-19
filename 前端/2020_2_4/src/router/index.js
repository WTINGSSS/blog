import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  /** 子路由 */
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: '用户登录',
      component: () => import('../views/Login.vue')
    },
    {
      path: '/welcome',
      name: '过渡页面',
      component: () => import('../views/Welcome.vue')
    },
    {
      path: '/home',
      name: '主页',
      component: () => import('../views/Home.vue'),
    },
    {
      path: '/main',
      redirect: '/index',
      name: '博客管理主页',
      component: () => import('../views/admin/main.vue'),
      children: [
        {
          path: '/index',
          name: '跳转博客管理欢迎页面',
          component: () => import('../views/admin/index.vue'),
        },
        {
          path: '/blogtype',
          name: '分类管理',
          component: () => import('../views/admin/BlogType.vue'),
        },
        {
          path: '/writeblog',
          name: '写博客 ',
          component: () => import('../views/admin/WriteBlog.vue'),
        },
        {
          path: '/blogList',
          name: '博客信息管理 ',
          component: () => import('../views/admin/BlogList.vue'),
        },
        {
          path: '/clist',
          name: '评论信息管理 ',
          component: () => import('../views/comment/Clist.vue'),
        },
        {
          path: '/examine',
          name: '评论审核管理 ',
          component: () => import('../views/comment/Examine.vue'),
        },
        {
          path: '/editblogger',
          name: '修改个人信息 ',
          component: () => import('../views/blogger/modify.vue'),
        },
        {
          path: '/editpassword',
          name: '修改登录密码 ',
          component: () => import('../views/system/EditPassword.vue'),
        },
        {
          path: '/layout',
          name: '安全退出 ',
          component: () => import('../views/system/layout.vue'),
        }
      ]
    },



  ]
})

/**
 * 重写路由的push方法
 */
const routerPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error => error)
}


/**配置拦截器 */
// router.beforeEach((to, from, next) => {
//   if (to.path == '/login') {
//     next()
//     return
//   }
//   /**如果有token表示登录，程序跳转，否则跳转到登录页面 */
//   let token = sessionStorage.getItem('token')
//   if (token) {
//     next()
//   } else {
//     next('/login')
//   }
// })



export default router