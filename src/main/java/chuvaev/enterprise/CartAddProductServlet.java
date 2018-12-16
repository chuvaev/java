package chuvaev.enterprise;

import chuvaev.enterprise.api.CartRepository;
import chuvaev.enterprise.api.ProductRepository;
import chuvaev.enterprise.constant.FieldConst;
import chuvaev.enterprise.entity.Product;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "CartAddProductServlet", urlPatterns = "/add_to_cart")
public class CartAddProductServlet extends HttpServlet {
    @Inject
    private CartRepository cartRepository;

    @Inject
    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter(FieldConst.ID);
        final Product product = productRepository.findById(id);
        if(product == null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        cartRepository.addProduct(product);
        resp.sendRedirect("catalog");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req, resp);
    }
}
