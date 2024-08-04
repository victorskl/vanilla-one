# vanilla-one

Explore JSF for Web MVC, CDI for service layer and JAX-RS for RESTful web service from Jakarta EE.

## Technology Stack

* JSF - Mojarra
* CDI - Weld
* JAX-RS - RESTEasy using JAXB for XML and Jackson2 for JSON

## Frontend Frameworks

* PrimeFaces
* _Classic_ [JavaScript XHR AJAX REST Client](src/main/webapp/restClient.html)

## Docker

```
docker build -t vanilla-one -f Dockerfile .
```

```
docker run -it --rm -p 8080:8080 --name vanilla-one vanilla-one
```

```
open -a "Google Chrome" http://localhost:8080/vanilla-one
```

```
curl -s -H "Accept: application/json" "http://localhost:8080/vanilla-one/rest/prime/getPrimes" | jq
```
