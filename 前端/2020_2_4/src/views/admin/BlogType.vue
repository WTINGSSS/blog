<template>
  <div>
    <!-- 导航 -->
    <el-breadcrumb separator-class="el-icon-arrow-right" style="height:30px">
      <el-breadcrumb-item>
        <a href="/" class="el-icon-s-promotion">导航菜单</a>
      </el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-s-data">博客类别管理</el-breadcrumb-item>
      <el-breadcrumb-item class="el-icon-office-building">分类管理</el-breadcrumb-item>
    </el-breadcrumb>

    <!-- 表格展示 -->
    <el-card class="box-card">
      <!-- 添加 -->
      <el-button
        type="success"
        class="el-icon-circle-plus-outline"
        size="mini"
        @click="toAdd()"
      >添加分类</el-button>
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
        <el-table-column prop="typename" label="博客类型名称" align="center" width="450"></el-table-column>
        <el-table-column prop="orderno" label="排序序号" align="center" width="300"></el-table-column>
        <el-table-column label="操作" width="300" align="center">
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
      :current-page="PageVo.pageNum"
      :page-sizes="[1,3,5,7,9]"
      :page-size="PageVo.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pageInfo.total"
      background
    ></el-pagination>

    <!-- 添加分类的弹出框 -->
    <el-dialog title="添加分类" :visible.sync="dialogVisible" width="30%" :modal-append-to-body="false">
      <el-form label-position="top" label-width="80px" :model="blogType">
        <el-form-item label="分类名称">
          <el-input v-model="blogType.typename" placeholder="请输入分类名称"></el-input>
        </el-form-item>
        <el-form-item label="排序值">
          <el-input v-model="blogType.orderno" placeholder="请输入排序值"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="success" @click="add()">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 修改分类的弹出框 -->
    <el-dialog
      title="修改分类"
      :visible.sync="dialogVisible2"
      width="30%"
      :modal-append-to-body="false"
    >
      <el-form label-position="top" label-width="80px" :model="blogType2">
        <el-form-item label="分类名称">
          <el-input v-model="blogType2.typename"></el-input>
        </el-form-item>
        <el-form-item label="排序值">
          <el-input v-model="blogType2.orderno"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible2 = false">取 消</el-button>
        <el-button type="success" @click="edit()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {
  ListForType,
  add,
  findOneById,
  edit,
  deleteAll,
  findByTid
} from "../../api";
export default {
  data() {
    return {
      PageVo: {
        pageNum: 1,
        pageSize: 9
      },
      pageInfo: {},
      blogType: {},
      blogType2: {},
      multipleSelection: [],
      dialogVisible: false,
      dialogVisible2: false
    };
  },
  methods: {
    // 查询所有
    async findAll() {
      let { data: baseResult } = await ListForType(this.PageVo);
      this.pageInfo = baseResult.data;
    },
    //添加
    toAdd() {
      this.dialogVisible = true;
    },
    async add() {
      let { data: baseResult } = await add(this.blogType);
      this.$message.success(baseResult.message);
      this.PageVo.pageNum = 1;
      this.findAll();
      this.dialogVisible = false;
      this.blogType = {};
    },
    //修改
    async toEdit(id) {
      this.dialogVisible2 = true;
      let { data: baseResult } = await findOneById(id);
      this.blogType2 = baseResult.data;
    },
    async edit() {
      let { data: baseResult } = await edit(this.blogType2);
      this.$message.success(baseResult.message);
      this.PageVo.pageNum = 1;
      this.findAll();
      this.dialogVisible2 = false;
    },

    // 批量删除
    deleteAll() {
      if (this.multipleSelection.length == 0) {
        this.$message.warning("请先选择需要删除内容?");
        return;
      }
      this.$confirm("您确定要删除吗?", "删除提示", { type: "warning" })
        .then(async () => {
          var ids = this.multipleSelection.map(item => item.id).join(",");
          let { data: baseResult } = await findByTid(ids);
          if (baseResult.data.length != 0) {
            console.info(baseResult.data);
            this.$message.warning("该分类下有文章，无法删除");
            return;
          }
          let { data } = await deleteAll(ids);
          this.PageVo.pageNum = 1;
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
      this.PageVo.pageSize = val;
      this.PageVo.pageNum = 1;
      this.findAll();
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.PageVo.pageNum = val;
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