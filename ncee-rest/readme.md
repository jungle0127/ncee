# how to make devtools work in IDEA
1- Add devtools dependencies to your pom.xml(if it's maven (spring-boot-devtools)). 
2- In your intellij IDEA go to: file->settings->build,execution,deployment. 
    Go to ->compiler->build project automatically. 
3-In your intellij IDEA: SHIFT+Ctrl+A ->registry-> compiler.automake.allow.when.app.running

# Can not find *mapper.xml issue
IDEA do NOT include XML files in src directory, add configuration in pom.xml
<build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
        </resources>
</build>
