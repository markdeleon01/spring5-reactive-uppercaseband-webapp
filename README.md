# Spring5 Reactive WebFlux REST backend web application for UPPERCASE band website

[![CircleCI](https://circleci.com/gh/markdeleon01/spring5-reactive-uppercaseband-webapp.svg?style=svg)](https://circleci.com/gh/markdeleon01/spring5-reactive-uppercaseband-webapp)

[![codecov](https://codecov.io/gh/markdeleon01/spring5-reactive-uppercaseband-webapp/branch/master/graph/badge.svg)](https://codecov.io/gh/markdeleon01/spring5-reactive-uppercaseband-webapp)

This repository is for a RESTful web application built on Spring5 Reactive WebFlux Framework for my band's website.

This is a Spring Boot web application that serves up articles regarding the UPPERCASE band.

The articles are categorized and displayed according to the various sections of the website,
such as highlights on the home page, events, discography section, and band information section;
they are stored and retrieved as documents from an embedded MongoDB NoSQL database.

The article resources are exposed with the API route:
http://localhost:8080/api/v1/articles

JUnit4 tests were written to assert functionalities of the repository, service, and controller classes.