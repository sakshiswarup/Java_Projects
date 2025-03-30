## POSTMAN

  Post - http://localhost:8080/api/v1/auth/user/sign-up
## JSON code
{
    "username": "mike",
    "email": "mike@gmail.com",
    "mobile":"your mobile no",
    "password":"testing"

}

POST http://localhost:8080/api/v1/auth/login
{
    "username":"mike",
    "password":"testing"
}

##it will generated token copy and past to 

GET http://localhost:8080/api/v1/car
Choose aAuthorization - select bearer token paste prev generated token (here in code some problem occured )
