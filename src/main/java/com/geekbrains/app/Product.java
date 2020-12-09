package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "Product", urlPatterns = "/cart")
public class Product extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(Product.class);

    int id;
    String title;
    int cost;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        List<String> productList = new ArrayList(); // Корзина

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        int cost = Integer.parseInt(req.getParameter("cost"));

        // Циклом заполняем условную корзину
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                productList.add("vegetables");
            } else {
                productList.add("fruit");
            }
        }
        //
        if (!(id == 0 && title == null && cost == 0)) {

            //http://localhost:8080/jee/cart?id=19&title=Aaa&cost=100

            out.println("<html><body>" + "<h1>" + String.format("%d , %s , %d", id, title, cost) + "</h1>" + "</body></html>");
        } else {

            //http://localhost:8080/jee/cart?id=0&cost=0 -- если не добавляем товар, то отображается текущая карзина

            out.println("<html><body>" + "<h1>" +
                    productList + "</h1>" + "</body></html>");
        }

        out.close();
    }
}
