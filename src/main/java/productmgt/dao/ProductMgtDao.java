
package productmgt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import productmgt.bean.ProductMgtBean;

/**
 *
 * @author Dinesh
 */
public class ProductMgtDao {
    
    private List<ProductMgtBean> productlist;
    private ProductMgtBean product;
    
    public List<ProductMgtBean> getAllProductList(Connection con)  throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        productlist = new ArrayList<>();
        
        try{
            String query = " SELECT "
                           + " PRODUCTID,PRODUCTNAME,CATEGORY,SUBCATEGORY,QUANTITY,STATUS,PRICE,DESCRIPTION,LISTEDDATE "
                           + " FROM PRODUCT ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                product = new ProductMgtBean();  
                
                product.setProductId(rs.getInt("PRODUCTID"));
                product.setProductName(rs.getString("PRODUCTNAME"));
                product.setCategory(rs.getString("CATEGORY"));
                product.setSubCategory(rs.getString("SUBCATEGORY"));
                product.setQuantity(rs.getInt("QUANTITY"));
                product.setStatus(rs.getString("STATUS"));
                product.setPrice(rs.getFloat("PRICE"));
                product.setDescription(rs.getString("DESCRIPTION"));
                product.setListeddate(rs.getDate("LISTEDDATE"));
                
                productlist.add(product);
            }
            
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    ps.close();
                } else if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw e;
            }
        }
        return productlist;
    }
    
    public List<ProductMgtBean> getProductList(Connection con, String condition) throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        productlist = new ArrayList<>();
        
        try{
            String query = " SELECT "
                           + " PRODUCTID,PRODUCTNAME,CATEGORY,SUBCATEGORY,QUANTITY,STATUS,PRICE,DESCRIPTION,LISTEDDATE "
                           + " FROM PRODUCT "
                           + " WHERE 1=1 "
                           + condition ;
            
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                product = new ProductMgtBean();  
                
                product.setProductId(rs.getInt("PRODUCTID"));
                product.setProductName(rs.getString("PRODUCTNAME"));
                product.setCategory(rs.getString("CATEGORY"));
                product.setSubCategory(rs.getString("SUBCATEGORY"));
                product.setQuantity(rs.getInt("QUANTITY"));
                product.setStatus(rs.getString("STATUS"));
                product.setPrice(rs.getFloat("PRICE"));
                product.setDescription(rs.getString("DESCRIPTION"));
                product.setListeddate(rs.getDate("LISTEDDATE"));
                
                productlist.add(product);
            }
            
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    ps.close();
                } else if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw e;
            }
        }
        return productlist;
    }
    
}
