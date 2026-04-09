package io.github.pradeeppk7.mvc;




import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/process")
public class ProcessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Read form data
        String name = request.getParameter("name");
        String favoriteFood = request.getParameter("favoriteFood");
        String ageParam = request.getParameter("age");

        int age;
        String category;
        String message;

        try {
            age = Integer.parseInt(ageParam);

            // 2. Business logic
            if (age < 18) {
                category = "minor";
            } else {
                category = "adult";
            }

            // 3. Create message
            message = name + " likes " + favoriteFood + ".";

            // 4. Store in request attributes
            request.setAttribute("name", name);
            request.setAttribute("favoriteFood", favoriteFood);
            request.setAttribute("age", age);
            request.setAttribute("category", category);
            request.setAttribute("message", message);

            // 5. Forward to JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Please enter a valid age.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}