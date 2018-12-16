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

@WebServlet (name = "ProductSaveServlet", urlPatterns = "/product-save")
public class ProductSaveServlet extends HttpServlet {

    @Inject
    private ProductRepository productRepository;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        final String id = req.getParameter(FieldConst.ID);
        if(id == null || id.isEmpty()){
            redirect(resp);
            return;
        }
        Product product = productRepository.findById(id);
        if(product == null){
            redirect(resp);
            return;
        }
        product.setName(req.getParameter(FieldConst.NAME));
        product.setDescription(req.getParameter(FieldConst.DESCRIPTION));
        product.setPrice(Double.parseDouble(req.getParameter(FieldConst.PRICE)));
        productRepository.merge(product);
        redirect(resp);
    }

    private void redirect(HttpServletResponse resp)throws IOException{
        resp.sendRedirect("catalog");
    }
}
