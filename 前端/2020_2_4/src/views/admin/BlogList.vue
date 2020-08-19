<template>
  <div>
    <!-- 导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="height:30px">
      <el-breadcrumb-item>
        <a href="/" class="el-icon-s-promotion">导航菜单</a>
      </el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-tickets">博客管理</el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-document-copyg">博客信息管理</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 表格展示 -->
    <el-card class="box-card">
      <el-form :inline="true" :model="blogvo" class="demo-form-inline">
        <el-form-item label="标题">
          <el-input v-model="blogvo.title"></el-input>
        </el-form-item>
        <el-button type="primary" @click="findAll()">搜索</el-button>
      </el-form>
      <el-button size="mini" type="danger" @click="deleteAll()" class="el-icon-delete">批量删除</el-button>

      <el-table
        :data="pageInfo.list"
        style="width: 100%"
        border
        stripe
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="id" label="编号" align="center" width="138"></el-table-column>
        <el-table-column prop="title" label="标题" align="center" width="350"></el-table-column>
        <el-table-column prop="releasedate" label="发布日期" align="center" width="300"></el-table-column>
        <el-table-column label="博客类别" prop="blogtype.typename" width="200" align="center"></el-table-column>
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope">
            <el-button size="mini" @click="toEdit(scope.row.id)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <!-- 分页 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="blogvo.pageNum"
      :page-sizes="[1,3,5,7,9]"
      :page-size="blogvo.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pageInfo.total"
      background
    ></el-pagination>
    <el-dialog title="博客修改" :visible.sync="dialogVisible" width="50%" :modal-append-to-body="false">
      <el-form :model="blog">
        博客标题：
        <br />
        <el-input v-model="blog.title" placeholder="文章标题，字数控制在100字以内"></el-input>
        <br />
        <br />博客分类：
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
        <br />博客摘要：
        <br />
        <el-input v-model="blog.summary" placeholder="简单描述你的文章"></el-input>
        <br />
        <br />关键字：
        <br />
        <el-input v-model="blog.keyword" placeholder="别人可能通过关键字搜索到你的文章"></el-input>
        <br />
        <br />博客内容：
        <br />
        <div>
          <quill-editor v-model="blog.content" style="height:300px"></quill-editor>
        </div>
        <br />
        <br />
      </el-form>
      <div align="center">
        <el-button type="primary" class="el-icon-position" @click="Edit()">修改博客</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { quillEditor } from "vue-quill-editor";
import "quill/dist/quill.core.css";
import "quill/dist/quill.snow.css";
import "quill/dist/quill.bubble.css";
import {
  ListForBlog,
  findBlogById,
  editByBlog,
  findblist,
  deleteAllByBlog
} from "../../api";
export default {
  components: {
    quillEditor
  },
  data() {
    return {
      blogvo: {
        pageNum: 1,
        pageSize: 5
      },
      pageInfo: {},
      blog: {},
      bList: [],
      multipleSelection: [],
      dialogVisible: false
    };
  },
  methods: {
    async findAll() {
      let { data: baseResult } = await ListForBlog(this.blogvo);
      this.pageInfo = baseResult.data;
    },
    async toEdit(id) {
      this.dialogVisible = true;
      let { data: baseResult } = await findBlogById(id);
      this.blog = baseResult.data;

      let { data: baseResult2 } = await findblist();
      this.bList = baseResult2.data;
    },
    async Edit() {
      let { data: baseResult } = await editByBlog(this.blog);
      this.$message.success(baseResult.message);
      this.blogvo.pageNum = 1;
      this.dialogVisible = false;
      this.findAll();
    },
    // 批量删除
    deleteAll() {
      if (this.multipleSelection.length == 0) {
        this.$message.warning("请先选择需要删除内容?");
        return;
      }
      this.$confirm("您确定要删除吗?", "删除提示", { type: "warning" })
        .then(async () => {
          let ids = this.multipleSelection.map(item => item.id).join(",");
          let { data } = await deleteAllByBlog(ids);
          this.blogvo.pageNum = 1;
          this.findAll();
          this.$message.success(data.message);
        })
        .catch(() => {
          this.$message.info("取消删除");
        });
    },
    //多选框
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    //分页
    handleSizeChange(val) {
      this.blogvo.pageSize = val;
      this.blogvo.pageNum = 1;
      this.findAll();
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.blogvo.pageNum = val;
      this.findAll();
      console.log(`当前页: ${val}`);
    }
  },
  async created() {
    this.findAll();
  }
};
</script>

<style>
</style>