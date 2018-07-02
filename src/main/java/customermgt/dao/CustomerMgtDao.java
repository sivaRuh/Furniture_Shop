
package customermgt.dao;

import customermgt.bean.CustomerMgtBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madushan_j
 */
public class CustomerMgtDao {
    
    private List<CustomerMgtBean> customerlist;
    private CustomerMgtBean customer;
    
    //get all the customers
    public List<CustomerMgtBean> getAllCustomerList(Connection con)  throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        customerlist = new ArrayList<>();
        
        try{
            String query = "  ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                customer = new CustomerMgtBean();  
                
                customer.setCustomerId(rs.getInt("CUSTOMERID"));
                customer.setCustomerStatus(rs.getString("STATUS"));
                customer.setCustomerName(rs.getString("NAME"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setTitle(rs.getString("TITLE"));
                customer.setTelNo(rs.getString("TELEPHONE"));
                         
                customerlist.add(customer);
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
        return customerlist;
    }
    
    //get the customers list for search result
    public List<CustomerMgtBean> getCustomerList(Connection con,String condition)  throws SQLException, Exception {
        ResultSet rs = null;
        PreparedStatement ps = null;
        customerlist = new ArrayList<>();
        
        try{
            String query = "  ";
            
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                customer = new CustomerMgtBean();  
                
                customer.setCustomerId(rs.getInt("CUSTOMERID"));
                customer.setCustomerStatus(rs.getString("STATUS"));
                customer.setCustomerName(rs.getString("NAME"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setTitle(rs.getString("TITLE"));
                customer.setTelNo(rs.getString("TELEPHONE"));
                         
                customerlist.add(customer);
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
        return customerlist;
    }
    
}
