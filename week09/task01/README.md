### Spring Boot基础

#### 练习描述

本题要求使用Spring boot来完成对Employee CURD(增删改查) API接口的实现。

- 要求每一个Employee包含 id、name、age、gender四个字段。
- 至少需要完成查询所有 Employee 的API接口，并返回一个包含所有Employee的JSON，要求接口路径：http://localhost:8080/employees
- 要求使用Postman来向目标接口路径发送请求，获取Response，Response JSON格式如下，将结果截图，并回复。
```javascript
      [
        {
          "id": 0,
          "name": "小明",
          "age": 20,
          "gender": "男"
        },
        {
          "id": 1,
          "name": "小红",
          "age": 19,
          "gender": "女"  
        },
        {
          "id": 2,
          "name": "小智",
          "age": 15,
          "gender": "男"
        },
        {
          "id": 3,
          "name": "小刚",
          "age": 16,
          "gender": "男"
        },
        {
          "id": 4,
          "name": "小霞",
          "age": 15,
          "gender": "女"
        }
      ]
```

- 有余力的同学可以尝试完成对Employee的 CURD(增删改查) 全部接口
- 代码通过小步提交，并且每次提交的描述都要有意义

#### 环境描述
- java8
- Intellij-IDEA

#### 如何开始
- 使用如下方式建立Spring boot项目，从 http://start.spring.io/ 生成一个项目包，并下载下来，解压，开始编码
- 在项目根目录下使用 `./gradlew bootRun` 启动服务器，若出现 `Tomcat started on port(s): 8080 (http)` 字样，说明项目启动成功。