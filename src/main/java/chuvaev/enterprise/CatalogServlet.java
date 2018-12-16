package chuvaev.enterprise;

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
import java.util.Collection;

@WebServlet(name = "CatalogServlet",urlPatterns ={"/catalog"})
public class CatalogServlet extends HttpServlet {

    @Inject
    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        Collection<Product> products = productRepository.findAll();
        req.setAttribute(FieldConst.PRODUCTS, products);
        req.getRequestDispatcher("WEB-INF/views/catalog.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}