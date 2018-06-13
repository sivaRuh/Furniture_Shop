
package productmgt.service;

import Common.DBconnection;
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
    
}
