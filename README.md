The architecture:

Used Simple Architecture to not to make it complex .

Technology User:

Java 1.8 
Spring boot and JPA 
Used inMemory H2 database 

End Point :

GET /load/product/

This will load a product from file to a database 

GET /load/inventory/

This will load a inventory from file to a database 

Get /products/

Load All product from data base and its available quantity 

Post /products/{ID}/sell

This end point allow to sell product .

It will check available quantity first and based on that it will allow to sell or throw an exception if inventory is not available .

H2 database console url :

http://localhost:8080/h2/login.do

Note :

1: Not clear about a remove/sell product means its a allow a bulk sell or concurrent user sell 
if its concurrent user sell then we can handle race condition for selling products .








