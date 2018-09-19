package chuvaev.enterprise;

import chuvaev.enterprise.api.CartRepository;
import chuvaev.enterprise.constant.FieldConst;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "CartDeleteProductServlet", urlPatterns = "delete_from_cart")
public class CartDeleteProductServlet extends HttpServlet {

    @Inject
    private CartRepository cartRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter(FieldConst.ID);
        if(id == null || id.isEmpty()){
            redirect(resp);
            return;
        }
        cartRepository.deleteProduct(id);
        redirect(resp);
    }

    private void redirect(HttpServletResponse resp)throws IOException{
        resp.sendRedirect("cart");
    }

    @Override
    protected void  doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }

}
