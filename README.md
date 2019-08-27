# neo-back-end
个人主页后台，使用spring boot开发,mybatis-plus&mysql作为数据库,spring security&jwt鉴权</br>
表结构简单，功能简陋，不断完善中
# 编译&部署
```shell script
Gradle bootjar
nohup java -jar xx.jar &
```
监听8080</br>
caddy转发/api到8080

