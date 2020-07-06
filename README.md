# Second-Hand-House

二手房交易网站的设计与实现

# 使用的技术

- SpringBoot框架
- Mybatis框架
- MySQL数据库
- Layui框架
- Druid数据库连接池

# 注意事项

- 数据库脚本文件已经导出放到 `数据库脚本`目录下

- 邮件的授权码码需要进行修改成自己的授权码，教程链接如下：

  https://blog.csdn.net/weixin_45961774/article/details/105040536

- 支付宝支付功能，需要支付宝可以识别的公网，可以选择花生壳进行内网穿透，也可以使用阿里云服务器，当然使用阿里云服务器更快也更方便。学生机一月只需9.9，链接如下：

  https://www.aliyun.com/minisite/goods?userCode=49laxmw3

- 如果使用了阿里云服务器部署环境，那么只需将jar包上传置阿里云服务器，然后一键启动即可，链接如下：

  https://www.jianshu.com/p/a12506dad33a

  推荐使用：nohup java -jar 你的项目.jar >temp.txt &;

- 本地打包成jar包命令如下：mvn clean package 会在target生成jar包，直接上传到服务器即可，xftp上传工具。

  

  

  

  



