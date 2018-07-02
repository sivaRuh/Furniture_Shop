
package customermgt.service;

import Common.DBconnection;
import customermgt.bean.CustomerMgtBean;
import customermgt.dao.CustomerMgtDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author madushan_j
 */

public class CustomerMgtService {
    
    private List<CustomerMgtBean> customerlist;
    private CustomerMgtDao customermgtdao;
    
     //get all the customers for initial view
    public List<CustomerMgtBean> getAllCustomerList() throws SQLException, Exception {
       customermgtdao = new CustomerMgtDao();
       Connection con = null; 
       
       try{
           con = DBconnection.getConnection();
           customerlist = customermgtdao.getAllCustomerList(con);
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
       
       return customerlist;
    }
    
    
     //get the customers list for the search result
    public List<CustomerMgtBean> getCustomerList(String condition) throws SQLException, Exception {
       customermgtdao = new CustomerMgtDao();
       Connection con = null; 
       
       try{
           con = DBconnection.getConnection();
           customerlist = customermgtdao.getCustomerList(con,condition);
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
       
       return customerlist;
    }
    
    
}
