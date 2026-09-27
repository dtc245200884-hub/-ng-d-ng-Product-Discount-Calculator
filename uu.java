package com.codegym;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String productDescription =
                request.getParameter("productDescription");

        double listPrice =
                Double.parseDouble(request.getParameter("listPrice"));

        double discountPercent =
                Double.parseDouble(request.getParameter("discountPercent"));

        // Công thức:
        // Discount Amount = List Price * Discount Percent * 0.01
        double discountAmount =
                listPrice * discountPercent * 0.01;

        double discountPrice =
                listPrice - discountAmount;

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='vi'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Discount Result</title>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");

        out.println("<body>");

        out.println("<div class='container'>");
        out.println("<div class='card result'>");

        out.println("<h1>Discount Result</h1>");

        out.println("<p><strong>Product Description:</strong> "
                + productDescription + "</p>");

        out.println("<p><strong>List Price:</strong> "
                + listPrice + "</p>");

        out.println("<p><strong>Discount Percent:</strong> "
                + discountPercent + "%</p>");

        out.println("<p class='discount'><strong>Discount Amount:</strong> "
                + discountAmount + "</p>");

        out.println("<p class='price'><strong>Discount Price:</strong> "
                + discountPrice + "</p>");

        out.println("<a href='index.jsp'>Calculate Again</a>");

        out.println("</div>");
        out.println("</div>");

        out.println("</body>");
        out.println("</html>");
    }
}