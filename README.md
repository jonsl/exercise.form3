# exercise.form3
Coding exercise for back-end developer.
## Design location
The design document is located:
```
doc/form3-coding-exercise-design.pdf
```
## Prerequisites
For this project I have used the following during implementation:
### IDE
```
Intellij IDEA 2018.1.4 COMMUNITY  
```
### OS
```
Distributor ID:	Ubuntu
Description:	Ubuntu 18.04 LTS
Release:	18.04
Codename:	bionic
```
### Java
```
java version "1.8.0_171"
Java(TM) SE Runtime Environment (build 1.8.0_171-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.171-b11, mixed mode)
```
### Open Source Libraries
```
'io.dropwizard:dropwizard-core:1.1.0'
'io.dropwizard:dropwizard-jdbi3:1.3.0'
'io.dropwizard:dropwizard-testing:1.1.2'
'org.jdbi:jdbi3-sqlite:3.2.1'
group: 'org.glassfish.jersey.bundles.repackaged', name: 'jersey-guava', version: '2.6'
'org.easytesting:fest-assert-core:2.0M5'
group: 'junit', name: 'junit', version: '4.12'
group: 'org.mockito', name: 'mockito-core', version: '2.1.0'
group: 'org.glassfish.jersey.test-framework.providers', name: 'jersey-test-framework-provider-grizzly2', version: '2.27'
```
### Dependencies (Jar)

The following Jar dependencies must be loaded at runtime:
```
jar/sqlite-jdbc-3.8.10.1.jar
```
### Command-line build
```
$ sudo apt install gradle
$ gradle wrapper
$ gradle build
$ gradle run -PappArgs="['server', 'configuration.yml']"
```
### Database
I have used SQLite for the back-end database. This database is named dev.db, located in the project root, and is created on run if non-existent. I used http://sqlitebrowser.org/ to evaluate the database contents.
