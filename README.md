# MoneyMap-Backend
Backend application for MoneyMap iOS Application. This uses JWT Authentication. It has basic CRUD APIs for User. 

## Description of APIs

1. Create User.
2. Login User ( Receives the JWT token as response).

For Below APIs, pass JWT token as bearer token in the Request header.

3. Get User.
4. Create Transaction.
5. Get All Transactions By User.
6. Update a particular Transaction.
7. Delete a particular Transaction.
8. Update Profile picture(Images are stored in Base-64 String in DB).
9. Signout.


## How to run the project

1. You need to install MYSQL from the official site on your machine and run this command in SQL Shell.
```bash
  CREATE DATABASE moneymap
```

2. Download this repo and open it in IntelliJ IDE(You can download the free community version from the official site). Edit Application.properties to update your MYSQL port no. , username and password for DB User.
<img width="1159" alt="image" src="https://github.com/venugopalreddy701/MoneyMap-Backend/assets/72261416/a7704bcc-9bc6-49ca-815b-21afcf18f229">


3. Hit the build and run buttons on IBE and Your APIs are ready !!! 

<img width="238" alt="image" src="https://github.com/venugopalreddy701/MoneyMap-Backend/assets/72261416/ee7433d6-38c5-4d55-8722-8c8855cebf36">

Prefix for APIs - http://localhost:8082



## Postman Collection
You can import my postman collection file in this repo - [MoneyMap.postman_collection.json](https://github.com/venugopalreddy701/MoneyMap-Backend/blob/main/MoneyMap.postman_collection.json) and see the examples to know how to hit these APIs.

## Swagger Doc

Run the project locally and open url - http://localhost:8082/swagger-ui/index.html#/

<img width="1499" alt="image" src="https://github.com/venugopalreddy701/MoneyMap-Backend/assets/72261416/7f0e84e4-3481-4251-bfed-15ca195ea268">




