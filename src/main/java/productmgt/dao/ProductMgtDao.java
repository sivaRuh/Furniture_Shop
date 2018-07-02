
package productmgt.dao;

import productmgt.bean.CategoryBean;
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
    private List<CategoryBean> categorylist;
    private List<CategoryBean> subcategorylist;
    private CategoryBean category;
    private CategoryBean subcategory;
    
    public List<ProductMgtBean> getAllProductList(Connection con)  throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        productlist = new ArrayList<>();
        
        try{
            String query = " SELECT "
                           + " P.PRODUCTID,P.PRODUCTNAME,C.DESCRIPTION AS CATEGORY,SC.DESCRIPTION AS SUBCATEGORY,P.QUANTITY,S.DESCRIPTION STATUSDES,"
                           + " P.PRICE,P.DESCRIPTION,P.CREATEDDATE AS LISTEDDATE "
                           + " FROM PRODUCT P"
                           + " LEFT JOIN STATUS S ON P.STATUS = S.STATUSID "
                           + " LEFT JOIN PRODUCTCATEGORY C ON C.CATEGORYID = P.CATEGORY "
                           + " LEFT JOIN PRODUCTSUBCATEGORY SC ON SC.SUBCATEGORYID = P.SUBCATEGORY ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                product = new ProductMgtBean();  
                
                product.setProductId(rs.getInt("PRODUCTID"));
                product.setProductName(rs.getString("PRODUCTNAME"));
                product.setCategory(rs.getString("CATEGORY"));
                product.setSubCategory(rs.getString("SUBCATEGORY"));
                product.setQuantity(rs.getInt("QUANTITY"));
                product.setStatus(rs.getString("STATUSDES"));
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
    
    public List<CategoryBean> getCategoryList(Connection con)  throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        categorylist = new ArrayList<>();
        
        try{
            String query = " SELECT CATEGORYID,DESCRIPTION FROM PRODUCTCATEGORY ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                category = new CategoryBean();  
                category.setCategoryid(rs.getString("CATEGORYID"));
                category.setCategorydes(rs.getString("DESCRIPTION"));
                categorylist.add(category);
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
        return categorylist;
    }
    
    public List<CategoryBean> getSubCategories(Connection con, String category)  throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        subcategorylist = new ArrayList<>();
        
        try{
            String query = " SELECT SUBCATEGORYID,DESCRIPTION FROM PRODUCTSUBCATEGORY"
                           + " WHERE CATEGORYID = ? ";
            ps = con.prepareStatement(query);
            
            ps.setString(1,category);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                subcategory = new CategoryBean();  
                subcategory.setSubcategoryid(rs.getString("SUBCATEGORYID"));
                subcategory.setSubcategorydes(rs.getString("DESCRIPTION"));
                subcategorylist.add(subcategory);
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
        return subcategorylist;
    }

    public void deleteProduct(Connection con, String productId) throws SQLException, Exception {
       
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            String query = " DELETE FROM FROM PRODUCT WHERE PRODUCTID = ? ";
            ps = con.prepareStatement(query);
            
            ps.setString(1,productId);
            ps.executeUpdate();

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
        
    }
   
}
