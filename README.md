# Getting Started

## sql section
* import file : db_home.sql in script_sql folder for running application
* import file : test_home.sql in script_sql for testing
* syntaks in mysql terminal : 
`create user 'springuser'@'localhost' identified by 'ThePassword';`

* then :
`grant all on db_home.* to 'springuser'@'localhost';`
* also :
`grant all on test_home.* to 'springuser'@'localhost';`

## how to run app
* mvn spring-boot:run
* open browser with url http://localhost:7030/swagger-ui.html

