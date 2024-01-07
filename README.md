# MoneyMap-Backend
Backend application for MoneyMap iOS Application. This uses JWT Authentication. It has basic CRUD APIs for User. 

## Description of APIs

1. Create User.
2. Login User ( Receives the JWT token as response).
For Below APIs, pass JWT token as bearer token in Request header.
3. Get User.
4. Create Transaction.
5. Get All Transactions By User.
6. Update a particular Transaction.
7. Delete a particular Transaction.
8. Update Profile picture(Images are stored in Base-64 String in DB).
9. Signout.

## Postman Collection
You can import my postman collection file in this repo - MoneyMap.postman_collection.json and see the example to know how to hit these APIs.

## Swagger Doc

Run the project locally and open url - http://localhost:8082/swagger-ui/index.html#/

<img width="1499" alt="image" src="https://github.com/venugopalreddy701/MoneyMap-Backend/assets/72261416/7f0e84e4-3481-4251-bfed-15ca195ea268">




