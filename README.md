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
