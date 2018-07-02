
package productmgt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import productmgt.bean.ProductMgtBean;
import productmgt.service.ProductMgtService;

/**
 *
 * @author Dinesh
 */
public class SearchProductServlet extends HttpServlet {


    private ProductMgtBean productmgtbean ;
    private ProductMgtService productmgtservice;
    private List<ProductMgtBean> productlist;
    private RequestDispatcher rd ;
    private String url = "productmgt/productmgthome.jsp";
    
    //private SessionVarList sessionVarlist;
    //private SessionUser sessionUser;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            productmgtbean = new ProductMgtBean();

//          producmgtbean.setProductId();
//          producmgtbean.setProductName();
//          producmgtbean.setCategory();
//          producmgtbean.setSubCategory();
//          producmgtbean.setListedFromDate();
//          producmgtbean.setListedToDate();

            productlist=this.getProductList(productmgtbean); 
            
            request.setAttribute("productlist",productlist);

            
        }catch(Exception e){
            
        }
        
        rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
    
    private List<ProductMgtBean> getProductList(ProductMgtBean searchbean) throws Exception {
        productmgtservice = new ProductMgtService();
        String condition ="";
        
        if(searchbean.getProductId() != null){
            condition = condition+" AND PRODUCTID = "+ searchbean.getProductId();
        }
        if(searchbean.getProductName() != null && !searchbean.getProductName().equals("") ){
            condition = condition+" AND PRODUCTNAME = "+ searchbean.getProductName();
        }
        if(searchbean.getCategory() != null && !searchbean.getCategory().equals("") ){
            condition = condition+" AND CATEGORY = "+ searchbean.getCategory();
        }
        if(searchbean.getSubCategory() != null && !searchbean.getSubCategory().equals("") ){
            condition = condition+" AND SUBCATEGORY = "+ searchbean.getSubCategory();
        }
        if(searchbean.getListedFromDate() != null){
            condition = condition+" AND LISTEDDATE >= "+ searchbean.getListedFromDate();
        }
        if(searchbean.getListedToDate() != null ){
            condition = condition+" AND LISTEDDATE <= "+ searchbean.getListedToDate();
        }
        
        productlist = productmgtservice.getProductList(condition);
        
        return productlist;
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

}
