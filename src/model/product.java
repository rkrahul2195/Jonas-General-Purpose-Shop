/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DecimalFormat;

/**
 *
 * @author rkrah
 */
public class product {

    private int id;
    private String PCode;
    private String ProductName;
    private String ProductType;
    private String ProductBrand;
    private Double ProductPrice;
    private String ProductCapacity;

    public product() {
        
    }
    
    
    
    private DecimalFormat df = new DecimalFormat("#0.00");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPCode() {
        return PCode;
    }

    public void setPCode(String PCode) {
        this.PCode = PCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String ProductType) {
        this.ProductType = ProductType;
    }

    public String getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(String ProductBrand) {
        this.ProductBrand = ProductBrand;
    }

    public Double getProductPrice() {
        return Double.valueOf(df.format(ProductPrice));
    }

    public void setProductPrice(Double ProductPrice) {
        this.ProductPrice = Double.valueOf(df.format(ProductPrice));
    }

    public String getProductCapacity() {
        return ProductCapacity;
    }

    public void setProductCapacity(String ProductCapacity) {
        this.ProductCapacity = ProductCapacity;
    }

}
