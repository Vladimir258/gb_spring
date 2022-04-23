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

@WebServlet(name = "FirstServlet", urlPatterns = "/show")
public class FirstServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("My Servlet work!!!");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.printf("<html><body><h1>Its My Servlet First!!!</h1></body></html>");
        out.close();
    }
}
