<template>
  <div>
    <!-- 导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="height:30px">
      <el-breadcrumb-item>
        <a href="/" class="el-icon-s-promotion">导航菜单</a>
      </el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-help">系统管理</el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-lock">修改登录密码</el-breadcrumb-item>
    </el-breadcrumb>

    <el-card class="box-card">
      <el-form :model="blogger" style="width:1250px">
        <h5>旧的登录密码：</h5>
        <br />
        <el-input v-model="blogger.p0" placeholder="请输入旧的登录密码" type="password"></el-input>
        <br />
        <br />
        <h5>新密码：</h5>
        <br />
        <el-input v-model="blogger.p1" placeholder="请输入新密码" type="password"></el-input>
        <br />
        <br />
        <h5>确认新密码：</h5>
        <br />
        <el-input v-model="blogger.p2" placeholder="请再次输入新密码" type="password"></el-input>
        <br />
        <br />

        <div align="center">
          <el-button type="success" class="el-icon-position" @click="update()">修改密码</el-button>
        </div>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { editbr } from "../../api";
export default {
  data() {
    return {
      blogger: {
        p0: "",
        p1: "",
        p2: ""
      }
    };
  },
  methods: {
    async update() {
      if(this.blogger.p0==null){
       this.$message.error("登录密码不能为空")
      } else if (this.blogger.p0 != this.blogger.password) {
        this.$message.error("登录密码错误");
      } else if (this.blogger.p1 == null || this.blogger.p2 == null) {
        this.$message.error("两次输入密码不能为空");
      } else if (this.blogger.p1 != this.blogger.p2) {
        this.$message.error("两次输入密码不一致");
      } else if (this.blogger.p1 == this.blogger.password) {
        this.$message.error("与近期使用过的登录密码一致，请重新输入");
      } else {
        this.blogger.password = this.blogger.p1;
        let { data: baseResult } = await editbr(this.blogger);
        sessionStorage.setItem("blogger", JSON.stringify(baseResult.data));
        this.$message.success(baseResult.message);
        this.$router.push("/login");
      }
    }
  },
  async created() {
    let b = sessionStorage.getItem("blogger");
    this.blogger = JSON.parse(b);
  }
};
</script>

<style>
</style>