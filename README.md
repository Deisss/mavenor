Mavenor
=======

Provide a graphical way to install custom library into your maven local repository.



### Screenshot ###

![image](http://www.kirikoo.net/images/14Anonyme-20131018-200437.png)



Installation
------------

The project is a maven project, build under Netbean 7.4 and Netbean 8.0.1 (using integrate maven build)

    mvn assembly:assembly

Where pom.xml is located should build the jar under ./target folder. Use it like any jar:

    java -jar custom-maven-library-0.0.2-jar-with-dependencies.jar

Now you may see the screenshot above running.



Usage
-----

You need few information for each library to integrate them into your local maven repository:

  * **file**: the path to find jar file to add to your repository
  * **groupId**: the file groupId (can be what you want)
  * **artifactId**: the file artifactId (can be what you want)
  * **version**: the file version (can be what you want)
  * **packaging**: usually jar or war, it's the package format you are importing

The data: groupId, artifactId, version and packaging can be auto-discover by program using
the auto discover button after setting a file to include.

With those, maven can now register any library you want into your local repository.

We also provide pom.xml dependency, and maven build if you need one day to go on command line...  
This can help you to quickly use the file added to maven into your project.



Customize
---------

If you need to add new feature/rework some part: the project is a simple
Netbean 7.*/8.* project using default maven template. So you just need maven
and Netbean to get it work, then open the project using file -> open project



Limitation(s)
-------------

The project has been build for windows user, so it use ``` cmd.exe ``` process to launch mvn program, 
you may need to change this into ``` com.klinq.maven.thread.Runner.java ``` file.

Also, you will of course need maven installed on your computer.

Should be the only needed things to run it on linux/osx.



License
-------

Release under MIT Licence.
