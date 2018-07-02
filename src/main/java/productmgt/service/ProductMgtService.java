
package productmgt.service;

import Common.DBconnection;
import productmgt.bean.CategoryBean;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import productmgt.bean.ProductMgtBean;
import productmgt.dao.ProductMgtDao;

/**
 *
 * @author Dinesh
 */
public class ProductMgtService {
    
    private List<ProductMgtBean> productlist;
    private ProductMgtDao productmgtdao;
    private List<CategoryBean> categorylist;
    private List<CategoryBean> subcategorylist;
    
    //get all the products for initial view
    public List<ProductMgtBean> getAllProductList() throws SQLException, Exception {
       productmgtdao = new ProductMgtDao();
       Connection con = null; 
       
       try{
           con = DBconnection.getConnection();
           productlist = productmgtdao.getAllProductList(con);
       }
       catch(Exception e){
           throw e;
       }finally{
           if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
       }
       
       return productlist;
    }
    
    //get the product list for a specific search
    public List<ProductMgtBean> getProductList(String condition) throws SQLException, Exception {
       productmgtdao = new ProductMgtDao();
       Connection con = null; 
       
       try{
           con = DBconnection.getConnection();
           productlist = productmgtdao.getProductList(con,condition);
       }
       catch(Exception e){
           throw e;
       }finally{
           if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
       }
       
       return productlist;
    }
    
    //get all the category list 
    public List<CategoryBean> getCategoryList() throws SQLException, Exception {
       productmgtdao = new ProductMgtDao();
       Connection con = null; 
       
       try{
           con = DBconnection.getConnection();
           categorylist = productmgtdao.getCategoryList(con);
       }
       catch(Exception e){
           throw e;
       }finally{
           if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
       }
       
       return categorylist;
    }
    
    //Load subcategories for selected main category
    public List<CategoryBean> getSubCtategories(String category) throws SQLException, Exception {
       productmgtdao = new ProductMgtDao();
       Connection con = null; 
       
       try{
           con = DBconnection.getConnection();
           subcategorylist = productmgtdao.getSubCategories(con,category);
       }
       catch(Exception e){
           throw e;
       }finally{
           if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
       }
       
       return subcategorylist;
    }

    public void deleteProduct(String productId) throws SQLException, Exception {
        
       productmgtdao = new ProductMgtDao();
       Connection con = null; 
       
       try{
           con = DBconnection.getConnection();
           productmgtdao.deleteProduct(con,productId);
       }
       catch(Exception e){
           throw e;
       }finally{
           if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw e;
                }
            }
       }

    }
    
}
