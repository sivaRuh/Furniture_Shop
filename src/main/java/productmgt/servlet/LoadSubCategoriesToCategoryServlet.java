
package productmgt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import productmgt.bean.CategoryBean;
import productmgt.service.ProductMgtService;

/**
 *
 * @author madushan_j
 */
public class LoadSubCategoriesToCategoryServlet extends HttpServlet {

    private ProductMgtService prductmgtservice;
    private List<CategoryBean> result;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            String category= request.getParameter("category");
            
            if(!category.equals("")){
                result=this.getSubCtategories(category);
                if(result != null){
                    out.print(result);
                }                          
            }
            
            // building the JSON response
            JSONObject jsonResponse = new JSONObject();
            
            JSONArray row = new JSONArray();
            
            for (CategoryBean t : result) {
                
                JSONObject object = new JSONObject();
                
                object.put("subcatid",t.getSubcategoryid() );
                object.put("subcatdes", t.getSubcategorydes());
                
                row.put(object);
                               
            }
            jsonResponse.put("aaData", row);

            response.setContentType("application/json");
            response.getWriter().print(jsonResponse.toString());
            
        }catch(Exception e){
            
        } finally {            
            out.close();
        }
        
    }
    
    private List<CategoryBean> getSubCtategories(String category) throws Exception {
        List<CategoryBean> results;
        try {
            prductmgtservice = new ProductMgtService();
            results = prductmgtservice.getSubCtategories(category);
        } catch (Exception ex) {
            throw ex;
        }
        return results;
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
