Part 1

Functions 
➜ curl http://localhost:8080/uppercase -H "Content-Type:text/plain" -d carlos                 
CARLOS%                                                                                                                                                                                                                 
functions on  master [?] at 🔐  https://vault.seon.com 
➜ curl http://localhost:8080/reverseReactive -H "Content-Type:text/plain" -d carlos         
["solrac"]%                                                                                                                                                                                                             
functions on  master [?] at 🔐  https://vault.seon.com 
➜ curl http://localhost:8080/uppercasereverseReactive -H "Content-Type:text/plain" -d carlos
["SOLRAC"]%   

Part 2

curl -X POST http://localhost:8080/user/USER_CREATED_EVENT
curl -X POST http://localhost:8080/user/USER_UPDATED_EVENT
