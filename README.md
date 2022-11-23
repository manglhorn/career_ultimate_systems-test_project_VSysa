# career_ultimate_systems-test_project_VSysa

Welcome to my mini test project!

1) According to the prescription, I created two classes Student and Teacher.
2) Connected them with a @JoinTable inheritance strategy, with a separate table for the id of these entities.
3) Connected H2 cloud database (all credentials are in application properties):

     - port for H2 - http://localhost:8080/h2-ui
     - username: test, password: 1234
     - URL: jdbc:h2:mem:testdb://localhost:9092/default
   
4) Created two endpoints to show all students and all teachers,

      Endpoints:
       http://localhost:8080/api/students
       http://localhost:8080/api/teachers

5) The possibility of sorting is also present.
6) Also used Spring Boot possibilities like Lombok and Spring-Boot-DevTools

The task was created according to the classic programming trends that I learned in the courses,
I apologize in advance for any roughness! =)
