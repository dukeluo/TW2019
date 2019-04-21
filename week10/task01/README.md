# MySQL基础
## 练习描述

本题要求使用 `MySQL` 来完成数据库数据表的创建，并使用查询语句完成基本的查询操作。
- 公司 `Company` 的字段有：`id`,`companyName`,`employeesNumber`
- 员工 `Employee` 的字段有：`id`,`name`,`age`,`gender`,`companyId`,`salary`
- 按照`practice1-practice4`的需求完成数据的查询

要求：
- 创建新的文件`result.txt`
- 将每个practice的查询结果都粘贴至`result.txt`文件中，例如：
  ```
   practice1
   +----+------------+-----+----------+-----------+--------+
   | id | name       | age | gender   | companyId | salary |
   +----+------------+-----+----------+-----------+--------+
   |  1 | '********' |  19 | 'female' |         1 |   7000 |
   +----+------------+-----+----------+-----------+--------+
   
   practice2
   +----+------------+-----+----------+
   | id | companyName| employeesNumber| 
   +----+------------+-----+----------+
   |  1 | 'baidu'    |     1000       |   
   +----+------------+-----+----------+  
  ```

## 环境要求
- MySQL:5.7

## 如何开始
- 本地启动`MySQL`
- 按照`practice1.sql`里的需求描述，完成数据库、数据表的搭建


## 输出规范
- 完成`practice1-practice4`文件中的所有需求
