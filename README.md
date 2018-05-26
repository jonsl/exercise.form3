# exercise.form3
Coding exercise for back-end developer at Form3.
## Design location
The design document is located at:
```
doc/form3-coding-exercise-design.pdf
```
## Prerequisites
For this project I have used the following during implementation:
### IDE
```
Intellij IDEA 2018.1.4 COMMUNITY  
```
### Operating Systems
```
Distributor ID:	Ubuntu
Description:	Ubuntu 18.04 LTS
Release:	18.04
Codename:	bionic
```
```
Edition: Windows 10 Home
Version: 1803
OS build: 17134.81
System type: 64-bit operating system, x64-based processor
```
### Java
```
java version "1.8.0_171"
Java(TM) SE Runtime Environment (build 1.8.0_171-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.171-b11, mixed mode)
```
### Open Source Libraries
```
compile group: 'io.dropwizard', name: 'dropwizard-core', version: dropwizardCoreVersion
compile group: 'io.dropwizard', name: 'dropwizard-jdbi3', version: dropwizardCoreVersion
compile group: 'io.dropwizard', name: 'dropwizard-jersey', version: dropwizardJerseyVersion
compile group: 'org.xerial', name: 'sqlite-jdbc', version: sqliteVersion
testCompile group: 'io.dropwizard', name: 'dropwizard-testing', version: dropwizardCoreVersion
testCompile group: 'org.mockito', name: 'mockito-core', version: mockitoVersion
testCompile group: 'junit', name: 'junit', version: junitVersion
```
### Command-line build
```
$ sudo apt install gradle
$ ./gradlew wrapper
$ ./gradlew build
$ ./gradlew run
```
### Database
I have used SQLite for the back-end database. This database is named dev.db, located in the project root, and is created on run if non-existent. I used http://sqlitebrowser.org/ to evaluate the database contents.
