/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author tung
 */
public class Product {
    
    // Fields of product
    private String productID;
    private String productName;
    private double unitPrice;
    private int quantity;
    private String status;
    
    // Default Constructor
    public Product() {
        this.productID = "";
        this.productName = "";
        this.unitPrice = 0;
        this.quantity = 0;
        this.status = "";
    }

    // Constructors with parameters
    public Product(String productID, String productName, double unitPrice, int quantity, String status) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.status = status;
    }
    
    
    // Getter and Setter

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * A String has format  
     * @return 
     */
    @Override
    public String toString() {
        return String.format("|%15s|%16s|%15.2f|%16d|%16s|", productID,productName,unitPrice,quantity,status.toUpperCase());
    }
    /**
     * A string to save to File
     * @return 
     */
    public String fileToString(){
        return productID+", "+ productName +", "+ unitPrice +", "+ quantity +", "+ status;
    }
    
    
}
