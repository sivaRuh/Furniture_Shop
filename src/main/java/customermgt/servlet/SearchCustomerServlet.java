
package customermgt.servlet;

import customermgt.bean.CustomerMgtBean;
import customermgt.service.CustomerMgtService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author madushan_j
 */
public class SearchCustomerServlet extends HttpServlet {
    
    private CustomerMgtBean customermgtbean ;
    private CustomerMgtService customermgtservice;
    private List<CustomerMgtBean> customerlist;
    private RequestDispatcher rd ;
    private String url = "customermgt/customermgthome.jsp";
    
    //private SessionVarList sessionVarlist;
    //private SessionUser sessionUser;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try{
            customermgtbean = new CustomerMgtBean();

//          customermgtbean.setCustomerId();
//          customermgtbean.setCustomerName();
//          customermgtbean.setEmail();
//          customermgtbean.setCustomerStatus();

            customerlist=this.getCustomerList(customermgtbean); 
            
            request.setAttribute("customerlist",customerlist);
            
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
    
    
    private List<CustomerMgtBean> getCustomerList(CustomerMgtBean searchbean) throws Exception {
        
        customermgtservice = new CustomerMgtService();
        String condition ="";
        
        if(searchbean.getCustomerId() != 0){
            condition = condition+" AND CUSTOMERID = "+ searchbean.getCustomerId();
        }
        if(searchbean.getCustomerName() != null && !searchbean.getCustomerName().equals("") ){
            condition = condition+" AND NAME = "+ searchbean.getCustomerName();
        }
        if(searchbean.getCustomerStatus() != null && !searchbean.getCustomerStatus().equals("") ){
            condition = condition+" AND STATUS = "+ searchbean.getCustomerStatus();
        }
        if(searchbean.getEmail() != null && !searchbean.getEmail().equals("") ){
            condition = condition+" AND EMAIL = "+ searchbean.getEmail();
        }
        if(searchbean.getTelNo() != null && !searchbean.getTelNo().equals("") ){
            condition = condition+" AND TELEPHONE = "+ searchbean.getTelNo();
        }
        
        customerlist = customermgtservice.getCustomerList(condition);
        
        return customerlist;
    }
}
