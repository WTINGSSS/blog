<template>
  <div>
    <el-dialog
      title="退出提示"
      :visible.sync="dialogVisible"
      width="30%"   
      :modal-append-to-body="false"
    >
      <h1>是否确认退出</h1>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="layout()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { layout } from "../../api";
export default {
  data() {
    return {
      dialogVisible: true
    };
  },
  methods: {
    async layout() {
      let { data: baseResult } = await layout();
      sessionStorage.clear();
      localStorage.clear();
      this.$message.success(baseResult.message);
      this.$router.push("/login");
    }
  }
};
</script>

<style>
</style>