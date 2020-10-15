package com.profectus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.profectus.business.model.Category;
import com.profectus.business.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchasedDto {

    private int id;

    private Product product;

    private String productName;

    private int categoryId;

    private int purchasedQuantity;

    private int purchasedPrice;

    private LocalDate purchasedDate;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getPurchasedQuantity() {
        return purchasedQuantity;
    }

    public void setPurchasedQuantity(int purchasedQuantity) {
        this.purchasedQuantity = purchasedQuantity;
    }

    public int getPurchasedPrice() {
        return purchasedPrice;
    }

    public void setPurchasedPrice(int purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDate purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", Product=").append(product);
        sb.append(", purchasedQuantity=").append(purchasedQuantity);
        sb.append(", purchasedPrice=").append(purchasedPrice);
        sb.append(", purchasedDate=").append(purchasedDate);
        sb.append("]");
        return sb.toString();
    }
}
