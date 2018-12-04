# ncee

Springboot + MyBatis + Angular4

## maven surefire plugin 使用
1. mvn clean compile findbugs:findbugs    清理原有的字节码文件，并生成findbugs XML报告
   mvn findbugs:gui  打开findbugs GUI工具查看扫描结果
2. mvn clean compile surefire-report:report 生成findbugs HTML报告

## maven Jacoco
mvn clean package

## Java代码质量检测

http://blog.csdn.net/zzq900503/article/details/49616959

findbugs, PMD, CheckStyle

## Angular
https://material.angular.io/guide/getting-started
https://ng-bootstrap.github.io/#/getting-started

## 流量统计
https://www.cnblogs.com/wuchaodzxx/p/7172321.html?utm_source=itdadao&utm_medium=referral

## Spring Security & Oauth2
https://segmentfault.com/a/1190000012260914

    WebSecurityConfigurerAdapter用于保护oauth相关的endpoints，同时主要作用于用户的登录(form login,Basic auth)
    ResourceServerConfigurerAdapter用于保护oauth要开放的资源，同时主要作用于client端以及token的认证(Bearer auth)
