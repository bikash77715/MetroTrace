# MetroTrace
Transport tracking system that tracks transports in different routes.

The client is developed as an android application implemented in Java. The transports that are moving in one direction are filtered by the client application using cosine filter. 
The client application also filters the transports that are heading towards the selected user's destination. 

The server is developed as a Spring-boot REST API. The server API is documented in Swagger-2 using Springfox implementation.
