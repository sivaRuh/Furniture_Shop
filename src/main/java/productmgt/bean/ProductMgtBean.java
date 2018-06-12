
package productmgt.bean;

import java.sql.Date;

/**
 *
 * @author Dinesh
 */
public class ProductMgtBean {
   
    private Number productId;
    private String productName;
    private String category;
    private String subcategory;
    private String description;
    private String status;
    private Number quantity;
    private Date listeddate;

    
    public Number getProductId() {
        return productId;
    }

    public void setProductId(Number productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Date getListeddate() {
        return listeddate;
    }

    public void setListeddate(Date listeddate) {
        this.listeddate = listeddate;
    }
    
}
