
package productmgt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import productmgt.bean.ProductMgtBean;
import productmgt.service.ProductMgtService;

/**
 *
 * @author Dinesh
 */
public class LoadProductMgtHomeServlet extends HttpServlet {
    
    private ProductMgtService productmgtservice;
    private List<ProductMgtBean> productlist;
    private RequestDispatcher rd ;
    private String url = "productmgt/productmgthome.jsp";
    
    //private SessionVarList sessionVarlist;
    //private SessionUser sessionUser;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            //HttpSession sessionObj = request.getSession(false);
            //sessionVarlist = (SessionVarList) sessionObj.getAttribute(SessionObject);
            //sessionUser = sessionVarlist.getCMSSessionUser();
            
            productlist=this.getAllProductList();
            
        }catch(Exception e){
        }
       
        rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private List<ProductMgtBean> getAllProductList() throws Exception {
        productmgtservice = new ProductMgtService();
        productlist = productmgtservice.getAllProductList();
        
        return productlist;
    }
        
}
