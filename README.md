# MVC Request Flow

This project demonstrates a basic MVC request flow using Java Servlet and JSP.

## Overview

The app collects user input from a form, sends it to a servlet for processing, and forwards the result to a JSP view using request attributes.

## Tech Stack

- Java 21
- Jakarta Servlet / JSP (Jakarta EE Web API 10)
- Maven (WAR packaging)

## Project Structure

```text
src/
  main/
    java/io/github/pradeeppk7/mvc/ProcessServlet.java
    webapp/index.jsp
    webapp/result.jsp
Assets/
  pic1.png
  pic2.png
```

## How to Run

1. Build the project:

```bash
mvn clean package
```

2. Deploy `target/mvc-request-flow.war` to a Jakarta-compatible servlet container (for example, Tomcat 10+).
3. Open the app in your browser and go to the input page.

## Request Flow (MVC)

1. User submits form data on `index.jsp` (`name`, `favoriteFood`, `age`).
2. `ProcessServlet` handles `POST /process`.
3. Servlet applies business logic:
   - Converts `age` to number
   - Classifies category as `minor` or `adult`
   - Builds a summary message
4. Servlet stores values in request attributes.
5. Request is forwarded to `result.jsp`.
6. `result.jsp` displays values using EL (`${name}`, `${category}`, etc.).

## Validation Behavior

- If age is not a valid number, the servlet sets `errorMessage` and forwards back to `index.jsp`.

## Results

### Result 1
![Result 1](Assets/pic1.png)

### Result 2
![Result 2](Assets/pic2.png)
