module.exports = {
    devServer: {
      port: 80
    },
    chainWebpack: config => {
      config.module.rule('pug')
        .test(/\.pug$/)
        .use('pug-html-loader')
        .loader('pug-html-loader')
        .end()
  }
  }