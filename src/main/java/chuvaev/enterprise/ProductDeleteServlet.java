package chuvaev.enterprise;

import chuvaev.enterprise.api.ProductRepository;
import chuvaev.enterprise.constant.FieldConst;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "DeleteProduct", urlPatterns = "/product_delete")
public class ProductDeleteServlet extends HttpServlet {

    @Inject
    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        final String id = req.getParameter(FieldConst.ID);
        if(id == null || id.isEmpty()){
            redirect(resp);
            return;
        }
        productRepository.removeById(id);
        redirect(resp);
    }

    private void redirect(HttpServletResponse resp)throws ServletException, IOException{
        resp.sendRedirect("catalog");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        doGet(req,resp);
    }
}
