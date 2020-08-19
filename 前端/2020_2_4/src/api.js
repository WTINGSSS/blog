/** ajax axios */
import axios from 'axios'
import { Message } from 'element-ui'
import Mock from 'mockjs'
import router from './router'

/** axios 基本项设置 */
axios.defaults.baseURL = 'http://localhost:9910/api'
axios.defaults.timeout = 3000




axios.interceptors.request.use(request => {
  //每一次请求头中，请求头需要携带token
  //获得token
  let token = sessionStorage.getItem('token')
  //有设置就放行
  if (token) {
    request.headers.authorization = token
  }
  return request
}, error => { });


axios.interceptors.response.use(response => {
      // 放行
      return response
      }, error => {
      // 错误判断
      if(error.response.status==403){
      router.push('/login')
      }
      return Promise.reject(error)
      })




/** 登录操作 */
export function login(blogger) {
    return axios.post('/bloggerservice/blogger/login', blogger)
}

/** 退出 */
export function layout() {
  return axios.get('/bloggerservice/blogger')
}

/** 修改个人信息 */
export function editbr(blogger){
  return axios.put('/bloggerservice/blogger',blogger)
}

/** 分类列表分页查询 */
export function ListForType(PageVo){
  return axios.get('/blogtypeservice/blogtype',{params:PageVo})
}

/** 分类列表无条件查询 */
export function findblist(){
  return axios.get('/blogtypeservice/blogtype/findblist')
}

/** 分类添加 */
export function add(blogtype){
  return axios.post('/blogtypeservice/blogtype',blogtype)
}

/** 查询出待修改的分类对象 */
export function findOneById(id){
  return axios.get('/blogtypeservice/blogtype/'+id)
}


/** 分类修改 */
export function edit(blogtype){
  return axios.put('/blogtypeservice/blogtype',blogtype)
}


/** 批量删除 */
export function deleteAll(ids){
  return axios.delete('/blogtypeservice/blogtype',{params:{ids}})
}

/** 根据typeid查询分类下博客 */
export function findByTid(ids){
  return axios.get('/blogservice/blog/findByTid',{params:{ids}})
}

/** 发布博客 */
export function addBlog(blog){
  return axios.post('/blogservice/blog',blog)
}

/** 博客列表 */
export function ListForBlog(blogvo){
  return axios.get('/blogservice/blog',{params:blogvo})
}

/** 查询待修改的博客 */
export function findBlogById(id){
  return axios.get('/blogservice/blog/'+id)
}

/** 修改博客 */
export function editByBlog(blog){
  return axios.put('/blogservice/blog',blog)
}

/** 博客的批量删除 */
export function deleteAllByBlog(ids){
  return axios.delete('/blogservice/blog',{params:{ids}})
}

/**  查询评论列表 */
export function ListForcom(cvo){
  return axios.get('/blogservice/comment',{params:cvo})
}

/** 评论的删除功能 */
export function deleteAllBycom(ids){
  return axios.delete('/blogservice/comment',{params:{ids}})
}

/** 待审核的评论列表查询 */
export function ListForstate(cvo){
  return axios.get('/blogservice/comment/ListForstate',{params:cvo})
}

/** 审核通过 */
export function examinet(ids){
  return axios.get('/blogservice/comment/examint',{params:{ids}})
}

/** 审核不通过 */
export function examinef(ids){
  return axios.get('/blogservice/comment/examinf',{params:{ids}})
}






