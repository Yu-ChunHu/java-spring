# Spring RESTful Web Service #

### Quick summary ###
Spring Framework with following features
>- Spring Boot
>- Hot Swap- DevTools
>- Spring Cache
>- MessageConverter(支援JSon/XML)
>- Swagger

---
Version 0.0.1

### Problems ###
Unsolved issues
>1. XML parser 使用Generic會有問題
>> com.codingcat.happy.request.Request.java

### Run ###
Run **Spring Boot**
>For Json test
>>1. Use browser
>>2. Go to [http://localhost:8090/swagger-ui.html](http://localhost:8090/swagger-ui.html)
>
>For XML test
>>1. Use *Postman*
>>2. Http Header Add 
>>> + Content-Type=application/xml
>>> + Accept=application/xml