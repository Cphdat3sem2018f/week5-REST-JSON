# REST (RESTful Webservices) with JAX-RS

## Learning Goals
After this week, you should:
  * Understand the principles of RESTful APIs.
  * Be able to implement a REST API using Java's JAX-RX API
  * Be able to implement a JSON API in java, using google's GSON library.
  * Be able to handle both success and error responses in a REST API

## Business competences
REST has become the current standard for designing web APIs, and is used for
virtually everything on the internet.

These lessons will provide the student with the necessary background to build
RESTful APIs in java.
## Plan

### Day1 - Rest principles and initial JAX setup and endpoints.

Remember to install [Postman](https://www.getpostman.com/)

### Day2 - Continuation from day 1, and data-transfer objects (DTOs)

### Day3 - Errorhandling with REST

## Resources: 

### General

### Day1 Introduction to REST

Read:
  * [RESTfull Web Services](http://www.drdobbs.com/web-development/restful-web-services-a-tutorial/240169069?pgno=1) (There are 3 pages)

When you need it, you can see a quick summary of the most important annotations
used with JAX here:
  * [link](http://docs.oracle.com/javaee/6/tutorial/doc/gilik.html)

If you need more in-depth information (in later projects for example), jersey
(the JAX implementation we use) has a user guide:
  * [jersey user guide](https://jersey.github.io/documentation/latest/index.html)

Dependencies
  * org.glassfish.jersey.bundles: jax-rs-ri  
    For the JAX-RS implementation we use (jersey)
  * com.google.code.gson: gson  
    For serializing and deserializing java objects to/from JSON.

### Day2 - Continuation from day 1, and data-transfer objects (DTOs)

Read:
  * [Wikipedia article about DTOs](https://en.wikipedia.org/wiki/Data_transfer_object)
  * [Jersey user-guide for jax resources](https://jersey.github.io/documentation/latest/jaxrs-resources.html) (Added after lecture)  
    We use 3.1 - 3.3, except 3.3 about sub-resources.  
    3.4 about life-cycle may be nice to know, but not strictly necessary for our purposes.

### Day3 - Errorhandling with REST

We map java exceptions to http error responses, as well as create responses
(errors included) from scratch.

Read:
  * [JERSEY documentation](https://jersey.github.io/documentation/latest/representations.html#d0e6352). section 7.3
    on creating error responses via exceptions and mapping existing exceptions to
    error responses.

  * The JAX class for representing responses (aptly named `Response`) is
    documented
    [here](http://docs.oracle.com/javaee/7/api/javax/ws/rs/core/Response.html).  
    Do not read through this, but use it as needed. It may be helpful to have
    Looked the method summary over briefly.

## Exercises 
  * [Exercise Day1]() Rest principles.
  * [Exercise Day2]() REST api with DTOs
  * [Exercise Day3]() Error handling
  * [StudyPoint Exercise]()