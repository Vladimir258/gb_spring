package ry.gb;

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

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);
    List<Product> products = new ArrayList<>();

    @Override
    public void init() {
        products.add(new Product(1, "Monitor", 15000F));
        products.add(new Product(2, "System block", 45000F));
        products.add(new Product(3, "Keyboard", 500F));
        products.add(new Product(4, "Mouse", 100F));
        products.add(new Product(5, "Sound", 1500F));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Welcome to my shop");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        for (Product p:products) {
            out.println("<html><body><h1>" + p + "</h1></body></html>");
        }
        out.close();
    }

}
