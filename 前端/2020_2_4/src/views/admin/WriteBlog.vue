<template>
  <div>
    <!-- 导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="height:30px">
      <el-breadcrumb-item>
        <a href="/" class="el-icon-s-promotion">导航菜单</a>
      </el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-tickets">博客管理</el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-edit-outline">写博客</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 卡片 -->
    <el-card class="box-card">
      <el-form :model="blog" style="width:1230px">
        <h5>博客标题：</h5>
        <br />
        <el-input v-model="blog.title" placeholder="文章标题，字数控制在100字以内"></el-input>
        <br />
        <br />
        <h5>博客分类：</h5>
        <br />
        <el-select v-model="blog.typeid" placeholder="请选择文章分类">
          <el-option
            v-for="(blogtype,index) in bList"
            :key="index"
            :label="blogtype.typename"
            :value="blogtype.orderno"
          ></el-option>
        </el-select>
        <br />
        <br />
        <h5>博客摘要：</h5>
        <br />
        <el-input v-model="blog.summary" placeholder="简单描述你的文章"></el-input>
        <br />
        <br />
        <h5>关键字：</h5>
        <br />
        <el-input v-model="blog.keyword" placeholder="别人可能通过关键字搜索到你的文章"></el-input>
        <br />
        <br />
        <h3>博客内容：</h3>
        <br />
        <div>
          <quill-editor v-model="blog.content" style="height:200px"></quill-editor>
        </div>
        <br />
        <br />
        <div align="center">
          <el-button type="primary" class="el-icon-position" @click="addBlog()">发布博客</el-button>
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
import { findblist, addBlog } from "../../api";
export default {
  components: {
    quillEditor
  },
  data() {
    return {
      blog: {},
      bList: []
    };
  },
  methods: {
    async addBlog() {
      let { data: baseResult } = await addBlog(this.blog);
      this.$message.success(baseResult.message);
      this.$router.push("/index");
    }
  },
  async created() {
    let { data: baseResult } = await findblist();
    this.bList = baseResult.data;
  }
};
</script>

<style>
</style>