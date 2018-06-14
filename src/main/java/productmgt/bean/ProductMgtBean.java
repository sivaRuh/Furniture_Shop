
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
    private String subCategory;
    private String description;
    private String status;
    private Number quantity;
    private Date listeddate;
    private float price;
    
    private Date listedFromDate;
    private Date listedToDate;

    
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

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getListedFromDate() {
        return listedFromDate;
    }

    public void setListedFromDate(Date listedFromDate) {
        this.listedFromDate = listedFromDate;
    }

    public Date getListedToDate() {
        return listedToDate;
    }

    public void setListedToDate(Date listedToDate) {
        this.listedToDate = listedToDate;
    }
    
}
