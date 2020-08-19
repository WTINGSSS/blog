<template>
  <div>
    <!-- 第一部分 顶部 -->
    <div class="hold">
      <div class="header">
        <div class="container">
          <div id="logo">
            <ul class="nav">
              <li v-for="(logo,index) in logo" :key="index">
                <img :src="logo.src" />
              </li>
              <li>
                <a href="http://www.czxy.com/">天空下的夜我一人行走</a>
              </li>
              <li>
                <a href="/login">登录</a>
              </li>
              <li>
                <a href="https://weibo.com/tingqianyunluo?is_all=1#_loginLayer_1578375951738">注册</a>
              </li>
            </ul>
          </div>

          <ul class="nav">
            <li>
              <a href="#">留言板</a>
            </li>
            <li>
              <a href="https://www.jianshu.com/u/a260a4c93d26/">庭-简书</a>
            </li>
            <li>
              <a href="https://my.oschina.net/tingqianyunluo/">庭-技术博客</a>
            </li>
            <li>
              <a href="https://www.zhihu.com/people/tingqianyunluo/posts/">庭-知乎</a>
            </li>
          </ul>
        </div>
      </div>
    </div>

    <!-- 第二部分 轮播图 -->
    <div class="section">
      <div class="container slidercontent">
        <el-carousel :interval="3000" indicator-position="outside" type="card">
          <el-carousel-item v-for="(item,index) in dataimg" :key="index">
            <img :src="item.src" />
          </el-carousel-item>
        </el-carousel>
      </div>
      <!-- </div> -->
    </div>

    <!-- 第三部分 部分功能 -->
    <div class="section">
      <div class="container">
        <div class="col four">
          <h1>
            <i class="el-icon-user-solid" style="color:#afc4d5"></i>
          </h1>
          <h1 class="service">
            <el-link type="info" href="/main">个人博客管理</el-link>
          </h1>
        </div>
        <div class="col four">
          <h1>
            <i class="el-icon-message-solid" style="color:#f3aa5b"></i>
          </h1>
          <h1 class="service">
            <el-link type="info">动态</el-link>
          </h1>
        </div>
        <!-- <div class="responsivegroup"></div>  -->
        <div class="col four">
          <h1>
            <i class="el-icon-sunny" style="color:#f3aa5b"></i>
          </h1>
          <h1 class="service">
            <el-link type="info">天气</el-link>
          </h1>
        </div>
        <div class="col four">
          <h1>
            <i class="el-icon-s-shop" style="color:#afc4d5"></i>
          </h1>
          <h1 class="service">
            <el-link type="info">书店</el-link>
          </h1>
        </div>
        <!-- <div class="group"></div> -->
      </div>
    </div>

    <!-- 第四部分  文章展示-->
    <div class="section bg">
      <div class="container">
        <h1>
          <i class="el-icon-tickets">推荐文章</i>
        </h1>
        <div class="col three bg nopad pointer">
          <div class="imgholder">
            <a href="https://www.jianshu.com/p/ae2db996cda1">
              <img class="imgholder" src="../assets/image/list/1.png" />
            </a>
          </div>
          <h1 class="feature">
            <a href="https://www.jianshu.com/p/ae2db996cda1" style="color:black">陷入那无限接近于灰的黑色中</a>
          </h1>
          <p>风钻进了我的衣服11月但并不觉得冷因为我的精神已麻...</p>
        </div>
        <div class="col three bg nopad pointer">
          <div class="imgholder">
            <a href="https://www.jianshu.com/p/032a29176080">
              <img class="imgholder" src="../assets/image/list/2.png" />
            </a>
          </div>
          <h1 class="feature">
            <a href="https://www.jianshu.com/p/032a29176080" style="color:black">提升思维方式</a>
          </h1>
          <p>1、素养 蓝斯登原则：在你往上爬的时候,一定要保持梯...</p>
        </div>
        <div class="col three bg nopad pointer">
          <div class="imgholder">
            <a href="https://www.jianshu.com/p/d1f7e2498a5c">
              <img class="imgholder" src="../assets/image/list/3.png" />
            </a>
          </div>
          <h1 class="feature">
            <a href="https://www.jianshu.com/p/d1f7e2498a5c" style="color:black">数学也可以这么浪漫?</a>
          </h1>
          <p>这人生无解 数学里有个特别执着的词：恒成立 数学里...</p>
        </div>
        <div class="group margin"></div>
        <div class="col three bg nopad pointer">
          <div class="imgholder">
            <a href="https://www.jianshu.com/p/2f2081d49774">
              <img class="imgholder" src="../assets/image/list/4.png" />
            </a>
          </div>
          <h1 class="feature">
            <a href="https://www.jianshu.com/p/2f2081d49774" style="color:black">在现实断裂的地方 梦 汇成了海</a>
          </h1>
          <p>独揽月下萤火，照亮一纸寂寞。 ​​​​泽国江山入战图，生...</p>
        </div>

        <div class="col three bg nopad pointer">
          <div class="imgholder">
            <a href="https://www.jianshu.com/p/44bb39993378">
              <img class="imgholder" src="../assets/image/list/5.png" />
            </a>
          </div>
          <h1 class="feature">
            <a href="https://www.jianshu.com/p/44bb39993378" style="color:black">忆起初见时间</a>
          </h1>
          <p>多希望有一天突然惊醒，发现自己在初中一年级的一节...</p>
        </div>

        <div class="col three bg nopad pointer">
          <div class="imgholder">
            <a href="https://www.jianshu.com/p/021ce5309a3a">
              <img class="imgholder" src="../assets/image/list/6.png" />
            </a>
          </div>
          <h1 class="feature">
            <a href="https://www.jianshu.com/p/021ce5309a3a" style="color:black">《完美世界》摘录</a>
          </h1>
          <p>完美世界并不完美，天道有缺，何况这世间本就完美...</p>
        </div>
        <div class="group"></div>
      </div>
    </div>

    <!-- 第五部分 -->
    <div class="section">
      <div class="container">
        <h1>
          鱼跃此时海
          <i class="el-icon-s-promotion"></i>
        </h1>
        <div class="col three">
          <h1 class="icon side">
            <a href="https://codepen.io/topic/react/templates">
              <img
                class="imgholder"
                src="../assets/image/list/7.png"
                style="width:52px;height:54px"
              />
            </a>
          </h1>
          <h1 class="feature side">
            <a href="https://codepen.io/topic/react/templates" style="color:black">
              <b>React</b>
            </a>
          </h1>
          <p class="side">一个用于构建用户界面的JavaScript库</p>
        </div>
        <div class="col three">
          <h1 class="icon side">
            <a href="https://codepen.io/topic/tailwind/picks">
              <img
                class="imgholder"
                src="../assets/image/list/8.png"
                style="width:52px;height:54px"
              />
            </a>
          </h1>
          <h1 class="feature side">
            <a href="https://codepen.io/topic/tailwind/picks" style="color:black">
              <b>Tailwind CSS</b>
            </a>
          </h1>
          <p class="side">使用程序优先的CSS框架，用于快速构建自定义用户界面</p>
        </div>
        <div class="col three">
          <h1 class="icon side">
            <a href="https://codepen.io/topic/d3/templates">
              <img
                class="imgholder"
                src="../assets/image/list/9.png"
                style="width:52px;height:54px"
              />
            </a>
          </h1>
          <h1 class="feature side">
            <a href="https://codepen.io/topic/d3/templates" style="color:black">
              <b>D3.js</b>
            </a>
          </h1>
          <p class="side">数据驱动的文件</p>
        </div>
        <div class="group margin"></div>
        <div class="col three">
          <h1 class="icon side">
            <a href="https://codepen.io/topic/tensorflow/templates">
              <img
                class="imgholder"
                src="../assets/image/list/10.png"
                style="width:52px;height:54px"
              />
            </a>
          </h1>
          <h1 class="feature side">
            <a href="https://codepen.io/topic/tensorflow/templates" style="color:black">
              <b>TensorFlow.js</b>
            </a>
          </h1>
          <p class="side">JavaScript中的机器学习</p>
        </div>
        <div class="col three">
          <h1 class="icon side">
            <a href="https://codepen.io/topic/sass/picks">
              <img
                class="imgholder"
                src="../assets/image/list/11.png"
                style="width:52px;height:54px"
              />
            </a>
          </h1>
          <h1 class="feature side">
            <a href="https://codepen.io/topic/sass/picks" style="color:black">
              <b>Sass</b>
            </a>
          </h1>
          <p class="side">一个成熟的css预处理器，具有变量、嵌套、循环，minxin，扩展和数学等功能</p>
        </div>
        <div class="col three">
          <h1 class="icon side">
            <a href="https://codepen.io/topic/anime/picks">
              <img
                class="imgholder"
                src="../assets/image/list/12.png"
                style="width:52px;height:54px"
              />
            </a>
          </h1>
          <h1 class="feature side">
            <a href="https://codepen.io/topic/anime/picks" style="color:black">
              <b>anime.js</b>
            </a>
          </h1>
          <p class="side">
            具有简单但功能强大的API的
            <br />轻量级JavaScript动画库
          </p>
        </div>
        <div class="group margin"></div>
      </div>
    </div>

    <!-- 第六部分 -->
    <div class="section bg">
      <div class="container">
        <h1>
          宠辱不惊，闲看庭前云落
          <i class="el-icon-partly-cloudy"></i>
        </h1>
        <el-card :body-style="{ padding: '0px' }">
          <a href="https://zhuanlan.zhihu.com/p/102042750">
            <img class="image" src="../assets/image/list/15.png" />
          </a>
          <div style="padding: 14px; text-align: left;">
            <span>心不清則無以见道，志不確則無以定功 ​​​​</span>
            <br />
            <p class="content">
              静心诀 冰寒千古，万物尤静，心宜气静，望我独神，心神合一，气宜相随，相间若余，万变不惊，无痴无嗔，无欲无求，无舍无弃，无为无我。
              清心诀 清心如水，清水即心。微...
            </p>
            <div class="bottom clearfix">
              <time class="time">- by 庭前云落 &nbsp; 发布于：2020-1-9 19:28</time>
              <a
                type="text"
                style="color:rgb(64, 158, 255)"
                href="https://zhuanlan.zhihu.com/p/102042750"
                class="button"
              >阅读全文>></a>
            </div>
          </div>
        </el-card>
        <br />
        <br />
        <el-card :body-style="{ padding: '0px' }">
          <a href="https://zhuanlan.zhihu.com/p/101518683">
            <img class="image" src="../assets/image/list/13.png" />
          </a>
          <div style="padding: 14px; text-align: left;">
            <span>刚入职公司该注意的事</span>
            <br />
            <p class="content">
              实习生铁律
              1. 早到三十分，晚九再动身；
              2. 少说不知道，多问行不行；
              3. 响应要及时，步步有反馈；
              4. 勿要发抱怨，每天要自省。=================================...
            </p>
            <div class="bottom clearfix">
              <time class="time">- by 庭前云落 &nbsp; 发布于：2020-1-8 17:22</time>
              <a
                type="text"
                style="color:rgb(64, 158, 255)"
                href="https://zhuanlan.zhihu.com/p/101518683"
                class="button"
              >阅读全文>></a>
            </div>
          </div>
        </el-card>
        <br />
        <br />
        <el-card :body-style="{ padding: '0px' }">
          <a href="https://zhuanlan.zhihu.com/p/101514546">
            <img class="image" src="../assets/image/list/14.png" />
          </a>
          <div style="padding: 14px; text-align: left;">
            <span>三十三个终身养成的好习惯</span>
            <br />
            <p class="content">
              1、锻炼左手
              2、长时间学习后立即睡觉
              3、倾听微弱的声音提高注意力，每天练习三分钟
              4、写下问题，越清楚，得到的答案也就越透彻
              5、预习学会20%,上课学会50%,回顾学...
            </p>
            <div class="bottom clearfix">
              <time class="time">- by 庭前云落 &nbsp; 发布于：2020-1-7 18:36</time>
              <a
                type="text"
                style="color:rgb(64, 158, 255)"
                href="https://zhuanlan.zhihu.com/p/101514546"
                class="button"
              >阅读全文>></a>
            </div>
          </div>
        </el-card>
      </div>
    </div>

    <!-- 第七部分 -->
    <div class="section">
      <div class="container">
        <div class="col two">
          <img class="image" src="../assets/image/list/16.png" />
          <h1 class="service">联系我 by-庭前云落</h1>
          <p>扫描上方二维码</p>
        </div>
        <div class="col two">
          <img class="image" src="../assets/image/list/17.png" />
          <h1 class="service">我的开源中国博客 by-庭前云落</h1>
          <p>扫描上方二维码</p>
        </div>
        <div class="group"></div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <h1 class="reset">凡是过去,皆为序章</h1>
      </div>
    </div>
    <div class="section">
      <div class="footer">
        <div class="container white">
          <div class="col four left">
            <h1>就这?</h1>
            <p>一开始我觉得随便找几个页面就行了，但是后来我发现照搬页面都会出错</p>
            <p>中间我"百度"找了很多资料，也安装了很多依赖，虽然大都没什么用</p>
            <p>
              很感谢这位大佬给我提供了很多的前端资料
              <a href="https://alphardex.github.io/">
                大の図書館
                勉強は俺に楽にさせる
              </a>
            </p>
          </div>
          <div class="col four left">
            <h1>怎么样?</h1>
            <p>虽然拖了很长时间，但是其实用的时间并没有多少</p>
            <p>页面的样式还是弄了很长时间，感谢各位在网上分享的前端大佬</p>
            <p>有时间，一一去研究，都给我等着</p>
          </div>
          <div class="col four left">
            <h1>为什么?</h1>
            <p>作为毕业设计，也有一直想做什么东西的冲动</p>
            <p>没办法，拖延症晚期，在学校就有人开始做了，16号开学，我2月4号搭的环境</p>
            <p>现在是3月5号23:08，主要页面不好看就没有做下去的动力，中间写写停停，终于完成了</p>
          </div>
          <div class="col four left">
            <h1>我是谁?</h1>
            <p>我是传智专修学院的一位在校生</p>
            <p>
              这是我的开源中国博客
              <a
                href="https://my.oschina.net/tingqianyunluo"
              >https://my.oschina.net/tingqianyunluo</a>
            </p>
            <p>
              或者通过邮箱联系我
              <a>WTINGSSS@outlook.com</a>
            </p>
          </div>
          <div class="group"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 轮播图地址
      dataimg: [
        {
          src: require("../assets/image/lb/1.png")
        },
        {
          src: require("../assets/image/lb/2.png")
        },
        {
          src: require("../assets/image/lb/3.png")
        },
        {
          src: require("../assets/image/lb/4.png")
        },
        {
          src: require("../assets/image/lb/5.png")
        }
      ],
      logo: [{ src: require("../assets/image/logo.png") }]
    };
  },
  methods: {},
  mounted() {
    window.onscroll = function() {
      var el = document.getElementsByClassName("header")[0];
      var className = "small";
      if (el.classList) {
        if (window.scrollY > 10) el.classList.add(className);
        else el.classList.remove(className);
      }
    };

    document.title = "不拼尽全力去试一下，又怎么知道不可以呢";
  }
};
</script>

<style lang="scss">
/*
  terrible.css
  Andrew Tunecliffe, 2015
  http://atunnecliffe.com
*/
/* uncomment to see outlines of stuff when you hover *-/
:hover {
  background:rgba(0, 0, 0, 0.1);
}/**/

html,
body {
  margin: 0;
  padding: 0;
}

// home页面样式
.section {
  width: 100%;
}

.container {
  position: relative;
  width: 1170px;
  margin: 0 auto;
  color: #444;
  font-size: 14px;
  font-weight: 300;
  font-family: Roboto, "Open Sans", Arial, sans-serif;
  overflow: hidden;
}

.section .container {
  padding: 30px 0 50px 0;
}

.section.bg {
  background: #f7f7f7;
}
/*
  Header
*/

.hold {
  height: 80px;
}

.header {
  line-height: 80px;
  width: 100%;
  transition: line-height 0.2s linear, box-shadow 0.2s linear;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 100;
  background: rgba(245, 245, 245, 0.97);
}

.header.small {
  line-height: 50px;
  box-shadow: 0px 1px 3px 0px rgba(50, 50, 50, 0.8);
}

.header.small > .container > #logo {
  height: 40px;
}

#logo {
  position: absolute;
  top: 30%;
  transform: translateY(-50%);
  float: left;
  height: 40px;
  width: 450px;
  margin-left: 5px;
}

ul.nav {
  float: right;
  list-style: none;
  margin: 0;
  padding: 0;
}

ul.nav li {
  float: left;
  position: relative;
}

ul.nav li a {
  transition: color 0.2s linear;
  font-size: 18px;
}

ul.nav li:hover a {
  color: red;
}

ul.nav li a {
  padding: 21px;
  color: initial;
  text-decoration: initial;
}
/*
  Slider
*/

.section .slider,
.section .footer {
  background: #333;
}

.footer {
  background: #333;
}

.slidercontent {
  text-align: center;
}

.hero {
  font-family: "Roboto Slab", sans-serif;
  color: white;
  font-weight: normal;
  letter-spacing: 1px;
}

h1.hero {
  font-size: 54px;
}

h2.hero {
  font-size: 30px;
  margin-bottom: 60px;
}

h1.hero:after {
  content: "";
  width: 300px;
  position: relative;
  border-bottom: 1px solid #aaa;
  text-align: center;
  margin: auto;
  margin-top: 15px;
}

.call {
  color: white;
  display: block;
  margin-bottom: 20px;
}

.call span {
  display: inline;
  border: 1px solid white;
  padding: 8px 13px;
  font-size: 20px;
  transition: background 0.15s linear;
}

.call span:hover {
  background: rgba(255, 255, 255, 0.1);
  cursor: pointer;
}
/* 
  Columns 
*/

.col {
  float: left;
  padding: 0;
  margin: 0;
  position: relative;
}

.col.four {
  width: 23%;
  margin: 0 1%;
}

.col.three {
  width: 31.3%;
  margin: 0 1%;
}

.col.two {
  width: 40%;
  margin: 0 2.5%;
  padding: 0 2.5%;
}

.col.extrapad {
  padding-top: 20px;
  padding-bottom: 20px;
}

.col .service,
.col .feature {
  font-size: 21px;
  font-weight: 300;
  font-family: "Roboto Slab", sans-serif;
}

.col .service:after {
  content: "";
  width: 50px;
  position: relative;
  border-bottom: 1px solid #eee;
  display: block;
  text-align: center;
  margin: auto;
  margin-top: 15px;
}

.col .feature {
  font-size: 19px;
}

.col h1.side,
.col p.side,
.col span.side:first-of-type {
  margin-left: 50px;
  text-align: left;
}

.col .icon {
  border-radius: 50%;
  height: 85px;
  width: 85px;
  line-height: 85px;
  text-align: center;
  margin: 0 auto;
  transition: background 0.25s linear, color 0.25s linear;
}

.col .icon.side {
  position: absolute;
  padding: 0;
  margin: 0;
  top: -15px;
  height: 50px;
  width: 50px;
}

// .col:hover > .icon {
//   background: #f44336;
//   color: white;
// }

.col:hover > .icon.side {
  background: initial;
  color: initial;
}

.responsivegroup {
  display: none;
}
/*
  Column specifics
*/

.col p,
.col h1 {
  padding: 0 1%;
  text-align: center;
}

.group.margin {
  margin-bottom: 20px;
}

.col .imgholder {
  height: 300px;
  width: 100%;
  transition: background 0.3s linear;
}

.col.bg {
  background: #fff;
}

.col.pointer {
  cursor: pointer;
}

.col.bg:hover .imgholder {
  background: #555;
}

.col span.feature {
  font-size: 20px;
}
/*
  Text
*/

.container > h1:not(.hero) {
  margin-bottom: 30px;
  text-align: center;
}

.container > h1:after {
  content: "";
  width: 30px;
  position: relative;
  border-bottom: 1px solid #aaa;
  display: block;
  text-align: center;
  margin: auto;
  margin-top: 15px;
}

h2 {
  font-family: "Roboto Slab", sans-serif;
  text-align: center;
  font-weight: 400;
  font-size: 18px;
}

.left,
.left > h1,
.left > p {
  text-align: left;
}

.reset {
  text-align: left !important;
}

.reset:after {
  display: none !important;
}
/* 
  Slider with Content
*/

.white h1,
.white h2,
.white p,
.white div,
.white a {
  color: #fff;
}
/*
  Responsive
*/

.group:after {
  content: "";
  display: table;
  clear: both;
}

@media all and (max-width: 768px) {
  .container {
    width: 95%;
  }
  .col.four {
    width: 48%;
    margin: 1%;
  }
  .col.three {
    display: block;
    width: 95%;
    padding: 0;
    margin: 0 auto;
    float: none;
  }
  .header {
    height: auto;
    background: #eee;
  }
  #logo {
    position: initial;
    float: none;
    display: block;
    transform: none;
    margin: 10px auto 0 auto;
  }
  ul.nav {
    float: none;
    display: block;
    text-align: center;
    margin: 0 auto;
  }
  ul.nav li {
    // float: initial;
    display: inline-block;
  }
  .responsivegroup {
    display: block;
  }
  .responsivegroup:after {
    content: "";
    display: table;
    clear: both;
  }
}

@media all and (min-width: 768px) {
  .container {
    width: 750px;
  }
}

@media all and (min-width: 992px) {
  .container {
    width: 970px;
  }
}

@media all and (min-width: 1200px) {
  .container {
    width: 1170px;
  }
}

@media all and (max-width: 450px) {
  .col,
  .col.four,
  .col.three,
  .col.two {
    display: block;
    width: 95%;
    padding: 0;
    margin: 0 auto;
    float: none;
  }
  .col.extrapad {
    padding: 1%;
    margin-bottom: 10px;
  }
  .group {
    display: none;
  }
}

.content {
  overflow: hidden;
  -ms-text-overflow: ellipsis;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.button {
  padding: 0px;
  float: right;
}

.image {
  width: 100%;
  display: block;
  height: 300px;
  cursor: pointer;
}

.time {
  font-size: 13px;
  color: #999;
}
</style>