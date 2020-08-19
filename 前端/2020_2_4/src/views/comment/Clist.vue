<template>
  <div>
    <!-- 导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="height:30px">
      <el-breadcrumb-item>
        <a href="/" class="el-icon-s-promotion">导航菜单</a>
      </el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-chat-round">评论管理</el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-chat-line-round">评论信息管理</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 表格展示 -->
    <el-card class="box-card">
      <el-button size="mini" type="danger" @click="deleteAll()" class="el-icon-delete">批量删除</el-button>
      <el-table
        :data="pageInfo.list"
        style="width: 100%"
        border
        stripe
        @selection-change="handleSelectionChange"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="id" label="编号" align="center" width="100"></el-table-column>
        <el-table-column prop="blog.title" label="博客标题" align="center" width="300"></el-table-column>
        <el-table-column prop="userip" label="用户IP" align="center" width="138"></el-table-column>
        <el-table-column prop="content" label="评论内容" align="center" width="360"></el-table-column>
        <el-table-column prop="commentdate" label="评论日期" align="center" width="145"></el-table-column>
        <el-table-column prop="state" label="评论状态" align="center" width="145">
          <template slot-scope="scope">{{scope.row.state==2?"审核不通过":scope.row.state==1?"审核通过":"未审核"}}</template>
        </el-table-column>
      </el-table>
    </el-card>

    <!-- 分页 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="cvo.pageNum"
      :page-sizes="[1,3,5,7,9]"
      :page-size="cvo.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pageInfo.total"
      background
    ></el-pagination>
  </div>
</template>

<script>
import { ListForcom,deleteAllBycom } from "../../api";
export default {
  data() {
    return {
      cvo: {
        pageNum: 1,
        pageSize: 5
      },
      pageInfo: {},
      multipleSelection: [],
      dialogVisible: false
    };
  },
  methods: {
    async findAll() {
      let { data: baseResult } = await ListForcom(this.cvo);
      this.pageInfo = baseResult.data;
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
          let { data } = await deleteAllBycom(ids);
          this.cvo.pageNum = 1;
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
      this.cvo.pageSize = val;
      this.cvo.pageNum = 1;
      this.findAll();
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.cvo.pageNum = val;
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