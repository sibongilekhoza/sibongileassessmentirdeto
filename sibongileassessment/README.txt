Technologies
JAVA 8
Springboot framework
Hibernate
Swagger
Maven
Derby DB
lambok


instructions to access the application
-you can access the application stored via the provided github or googledrive
-make sure that you have lambok install for the setters and getter
-  application can be run using springboot or intellij IDE
- derby is a database that store information temporary or during run time
- download and run the application

documentation is being done by using swagger 
http://localhost:8080/swagger-ui.html#/

use this url to access the application Api or postman
http://localhost:8080/api/social-media/userlogin
==================================================
project structure
. config is where i configure our database to connect with the application our Rest connection and the swagger documentation
.Model is where i  have our Entity classes
.repositories is where i  make the connection of the database and the application 
.service is the interface for the application to list the services that we used for the application
.service implementation is where  implement all the services for the application( business logic)
.Controller is where i expose all the api of the project are exposed to the frontend
. views is where all the front end service id exposed

 


what the applican do
- register as a user (http://localhost:8080/api/social-media/userlogin)
- once registerd you can login to the application
- once login it will direct you to the post where you will see all posts posted by you and other user
(first you won't see any post because on has posted anything yet you can post something and the register other user) 
-once you have posted other users can be able to view you post and comment
-as a user you can see who commented on you and what was the comment and you can reply to the comment
-other users can like or dislike your post
-you can analyze the post to see how many people commented on the post
-you can analyze the post to see how many people liked on you post
-you can you can analyze how many user most active on the platform, most recent user  most liked postd













