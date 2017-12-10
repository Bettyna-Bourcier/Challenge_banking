# challenge_banking_back

**The goal of this API is to be able to login in and then see the expenses of the connected user.**

This project is an API and its frontend is here : https://github.com/Bettyna-Bourcier/challenge_banking_front.

It is hosted on Heroku : https://lit-savannah-91690.herokuapp.com.

There is only one user. His credentials are :
  - clientNumber: NH8569MP5
  - password: challenge

The main points of this project are :
- use Spring Boot framework (Spring Boot Security, Hibernate)
- use a H2 memory database
- use clientNumber / password to authenticate (/authenticate)
- use JWT for the authorization (/me)
- use fake data (created at launch) and you can not insert new one

## Routes

### /authenticate (POST)

Required params :
  - clientNumber
  - password
  
 It responds the token in the Authorization header if good credentials are given.
 Otherwise it responds a 403.
 
 ### /me (GET)
 
 Required header :
  - Authorization: Bearer JWT_TOKEN_HERE
  
  It responds the user info with its expenses.
  
  Response example :
  
  ```json
  {
   "id":1,
   "firstName":"Expertus",
   "lastName":"Technologies",
   "clientNumber":"NH8569MP5",
   "outgoingsList":[
      {
         "id":1,
         "date":1509623589949,
         "outgoingType":"Accomodation",
         "amount":875.0
      },
      {
         "id":2,
         "date":1510487589950,
         "outgoingType":"Food",
         "amount":86.23
      }
   ]
}
  ```
