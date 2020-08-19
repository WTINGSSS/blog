<template>
  <div>
    <el-container>
      <el-aside width="200px">
        <el-menu
          default-active="$route.path"
          class="el-menu-vertical-demo"
          router
          background-color="#2f3f56"
          text-color="#fff"
          :default-openeds="array"
          unique-opened
        >
          <!-- unique-opened -->
          <el-menu-item index="/home">
            <template slot="title">
              <el-link class="el-icon-s-home" type="primary"></el-link>
              <span>首页</span>
            </template>
          </el-menu-item>
          <!-- 导航菜单 -->
          <el-submenu index="0">
            <template slot="title">
              <el-link class="el-icon-s-promotion" type="success"></el-link>
              <span>导航菜单</span>
            </template>
            <!-- 博客管理 -->
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-tickets"></i>
                <span>博客管理</span>
              </template>
              <el-menu-item index="/writeblog" class="el-icon-edit-outline">&nbsp;写博客</el-menu-item>
              <el-menu-item index="/blogList" class="el-icon-document-copy">&nbsp;博客信息管理</el-menu-item>
            </el-submenu>
            <!-- 博客类别管理 -->
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-s-data"></i>
                <span>博客类别管理</span>
              </template>
              <el-menu-item index="/blogtype" class="el-icon-office-building">&nbsp;分类管理</el-menu-item>
            </el-submenu>
            <!-- 评论管理 -->
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-chat-round"></i>
                <span>评论管理</span>
              </template>
              <el-menu-item index="/examine" class="el-icon-s-check">&nbsp;评论审核</el-menu-item>
              <el-menu-item index="/clist" class="el-icon-chat-line-round">&nbsp;评论信息管理</el-menu-item>
            </el-submenu>
            <!-- 个人信息管理 -->
            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-user"></i>
                <span>个人信息管理</span>
              </template>
              <el-menu-item class="el-icon-refresh" index="/editblogger">&nbsp;修改个人信息</el-menu-item>
            </el-submenu>
            <!-- 系统管理 -->
            <el-submenu index="5">
              <template slot="title">
                <i class="el-icon-help"></i>
                <span>系统管理</span>
              </template>
              <el-menu-item index="/index" class="el-icon-link">&nbsp;分享链接管理</el-menu-item>
              <el-menu-item index="/editpassword" class="el-icon-lock">&nbsp;修改登录密码</el-menu-item>
              <el-menu-item index="/66" class="el-icon-refresh-left">&nbsp;刷新系统缓存</el-menu-item>
              <el-menu-item index="/layout" class="el-icon-switch-button">&nbsp;安全退出</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      array: ["0"]
    };
  },
  methods: {
    
  },
};
</script>

<style>
.el-aside {
  background-color: #2f3f56;
  color: #333;
  position: fixed;
  height: 100%;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  position: fixed;
  right: 10px;
  height: 100%;
}
</style>