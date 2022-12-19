# City List
Angular + Spring Boot enterprise-grade web application for browsing, searching and managing cities

## Run application
```bash
docker-compose up -d
```

## Access links

### Front-end
http://localhost:4200

### Back-end
http://localhost:8080/api/v1/cities [GET]  
http://localhost:8080/api/v1/cities/:id [GET] [PUT]  
http://localhost:8080/api/v1/cities/search?name=:name [GET]  

### Postgres
localhost:5432  
DB: citylistdb

### pgAdmin
http://localhost:8000  
username: admin@domain.com  
password: admin

## Pagination
For pagination use next http query parameters:
* page=:number (Page you want to retrieve)
* size=:number (Size of the page you want to retrieve)
