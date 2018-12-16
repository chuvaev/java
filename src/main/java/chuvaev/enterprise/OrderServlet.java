package chuvaev.enterprise;

import chuvaev.enterprise.api.CartRepository;
import chuvaev.enterprise.constant.FieldConst;
import chuvaev.enterprise.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "OrderServlet", urlPatterns={"/order"})
public class OrderServlet extends HttpServlet {
    @Inject
    private CartRepository cartRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Collection<Product> cart = cartRepository.getAll();
        req.setAttribute(FieldConst.CART, cart);
        req.getRequestDispatcher("WEB-INF/views/order.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }
}
