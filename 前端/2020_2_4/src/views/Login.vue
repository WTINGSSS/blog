<template>
  <div>
    <el-form :model="blogger" class="login-form" action="javascript:void(0);">
      <h1>Login</h1>
      <div class="form-field">
        <svg
          t="1580186443851"
          class="icon"
          viewBox="0 0 1024 1024"
          version="1.1"
          xmlns="http://www.w3.org/2000/svg"
          p-id="1262"
          width="20"
          height="20"
        >
          <path
            d="M512 1024C229.248 1024 0 794.752 0 512S229.248 0 512 0s512 229.248 512 512-229.248 512-512 512z m0-938.666667C276.352 85.333333 85.333333 276.352 85.333333 512s191.018667 426.666667 426.666667 426.666667 426.666667-191.018667 426.666667-426.666667S747.648 85.333333 512 85.333333z m0 768a340.650667 340.650667 0 0 1-266.24-128A340.650667 340.650667 0 0 1 512 597.333333a340.48 340.48 0 0 1 266.197333 128A340.48 340.48 0 0 1 512 853.333333z m0-298.666666a170.666667 170.666667 0 1 1 0-341.333334 170.666667 170.666667 0 0 1 0 341.333334z"
            p-id="1263"
            fill="#ffffff"
          />
        </svg>
        <input
          type="text"
          v-model="blogger.username"
          id="username"
          class="form-field"
          pattern="^[a-zA-Z0-9_-]{1,16}$"
          placeholder=" "
          required
        />
        <label for="username">Username</label>
      </div>
      <div class="form-field">
        <svg
          t="1580186496086"
          class="icon"
          viewBox="0 0 1024 1024"
          version="1.1"
          xmlns="http://www.w3.org/2000/svg"
          p-id="885"
          width="20"
          height="20"
        >
          <path
            d="M512 1024C229.248 1024 0 794.752 0 512S229.248 0 512 0s512 229.248 512 512-229.248 512-512 512z m0-938.666667C276.352 85.333333 85.333333 276.352 85.333333 512s191.018667 426.666667 426.666667 426.666667 426.666667-191.018667 426.666667-426.666667S747.648 85.333333 512 85.333333z m170.666667 725.333334H341.333333a170.666667 170.666667 0 0 1-170.666666-170.666667v-85.333333a170.538667 170.538667 0 0 1 139.050666-167.466667A105.386667 105.386667 0 0 1 298.666667 341.333333c0-70.698667 71.637333-128 160-128h106.666666C653.696 213.333333 725.333333 270.634667 725.333333 341.333333c0 15.018667-3.84 29.269333-9.813333 42.666667H682.666667a170.666667 170.666667 0 0 1 170.666666 170.666667v85.333333a170.666667 170.666667 0 0 1-170.666666 170.666667zM512 298.666667c-70.698667 0-128 38.186667-128 85.333333h256c0-47.146667-57.301333-85.333333-128-85.333333z m256 256a85.333333 85.333333 0 0 0-85.333333-85.333334H341.333333a85.333333 85.333333 0 0 0-85.333333 85.333334v85.333333a85.333333 85.333333 0 0 0 85.333333 85.333333h341.333334a85.333333 85.333333 0 0 0 85.333333-85.333333v-85.333333z"
            p-id="886"
            fill="#ffffff"
          />
        </svg>
        <input
          type="password"
          v-model="blogger.password"
          id="password"
          class="form-field"
          placeholder=" "
          required
        />
        <label for="password">Password</label>
      </div>
      <button @click="login()" value="Login" class="btn">Login</button>
    </el-form>
  </div>
</template>

<script>
import { login } from "../api";
export default {
  data() {
    return {
      blogger: {}
    };
  },
  methods: {
    async login() {
      let { data: baseResult } = await login(this.blogger);
      if (baseResult.code == 1) {
        sessionStorage.setItem("token", baseResult.other.token);
        sessionStorage.setItem("blogger", JSON.stringify(baseResult.other.blogger));
        this.$router.push("/welcome");
      } else {
        this.$message.error(baseResult.message);
      }
    }
  },
  mounted() {
    document.title = "那一天，你终于想起了自己的... ---柒";
  }
};
</script>

<style lang="scss">
@import url(https://fonts.googleapis.com/css?family=Lato);

body {
  display: flex;
  height: 100vh;
  justify-content: center;
  align-items: center;
  font-family: Lato, sans-serif;
  background: url(~@/assets/image/buDT4YS6zUMfHst.jpg) 0 / cover fixed;
}

.login-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 3em;
  color: white;
  background: rgba(0, 0, 0, 0.8);
  border-radius: 10px;
  box-shadow: 0 0.4px 0.6px rgba(0, 0, 0, 0.141),
    0 1px 1.3px rgba(0, 0, 0, 0.202), 0 1.9px 2.5px rgba(0, 0, 0, 0.25),
    0 3.4px 4.5px rgba(0, 0, 0, 0.298), 0 6.3px 8.4px rgba(0, 0, 0, 0.359),
    0 15px 20px rgba(0, 0, 0, 0.5);

  h1 {
    margin: 0 0 0.3em 0;
    padding: 12px 0;
    font-size: 2.5em;
  }

  .form-field {
    position: relative;
    margin: 22px 0 8px 0;
    font-size: 20px;
    border-bottom: 1px solid white;
    transition: 0.4s;

    &::after {
      position: absolute;
      content: "";
      bottom: -1px;
      left: 0;
      width: 100%;
      height: 2px;
      background: #3498db;
      transform-origin: left;
      transform: scaleX(0);
      transition: 0.4s ease;
    }

    &:focus-within::after {
      transform: scaleX(1);
    }

    input {
      padding-left: 10px;
      color: white;
      background: transparent;
      border: none;
      outline: none;

      // label will float in 2 situations based on its sibling input:
      // 1. input get focus
      // 2. input has text filled
      &:focus ~ label,
      &:not(:placeholder-shown) ~ label {
        transform: translateY(-24px) scale(0.75);
      }

      &:valid ~ label {
        color: #3498db;
      }

      &:invalid ~ label {
        color: #e74c3c;
      }
    }

    label {
      position: absolute;
      left: 32px;
      top: 22px;
      transform-origin: left;
      transition: 0.4s;
    }
  }

  .btn {
    position: relative;
    width: 100%;
    padding: 6px 0;
    margin: 36px 0 18px 0;
    font-size: 1.2em;
    color: white;
    background: transparent;
    border: 2px solid hsla(204, 70%, 53%, 1);
    outline: none;
    cursor: pointer;
    overflow: hidden;
    transition: 0.5s;

    &::before {
      position: absolute;
      content: "";
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: linear-gradient(
        120deg,
        transparent,
        hsla(204, 70%, 53%, 0.5),
        transparent
      );
      transform: translateX(-100%);
      transition: 0.5s;
    }

    &:hover {
      box-shadow: 0 0 20px 10px hsla(204, 70%, 53%, 0.5);
    }

    &:hover::before {
      transform: translateX(100%);
    }
  }
}
</style>