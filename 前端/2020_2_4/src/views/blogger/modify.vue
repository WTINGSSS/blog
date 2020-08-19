<template>
  <div>
    <!-- 导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="height:30px">
      <el-breadcrumb-item>
        <a href="/" class="el-icon-s-promotion">导航菜单</a>
      </el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-user">个人信息管理</el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-refresh">修改个人信息</el-breadcrumb-item>
    </el-breadcrumb>

    <el-card class="box-card">
      <el-form :model="blogger" style="width:1230px">
        <h5>用户名：</h5>
        <br />
        <el-input v-model="blogger.username"></el-input>
        <br />
        <br />
        <h5>昵称：</h5>
        <br />
        <el-input v-model="blogger.nickname"></el-input>
        <br />
        <br />
        <h5>个性签名：</h5>
        <br />
        <el-input v-model="blogger.sign"></el-input>
        <br />
        <br />
        <h3>个人简介：</h3>
        <br />
        <div>
          <quill-editor v-model="blogger.profile" style="height:200px"></quill-editor>
        </div>
        <br />
        <br />
        <div align="center">
          <el-button type="primary" class="el-icon-position" @click="edit()">修改个人信息</el-button>
        </div>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import { quillEditor } from "vue-quill-editor";
import "quill/dist/quill.core.css";
import "quill/dist/quill.snow.css";
import "quill/dist/quill.bubble.css";
import { editbr } from "../../api";
export default {
  components: {
    quillEditor
  },
  data() {
    return {
      blogger: {}
    };
  },
  methods: {
    async edit() {
      let { data: baseResult } = await editbr(this.blogger);
      sessionStorage.setItem("blogger", JSON.stringify(baseResult.data));
      this.$message.success(baseResult.message);
      this.$router.push("/index");
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