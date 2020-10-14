package com.profectus.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchasedDto {

    private int id;

    private String CategoryName;

    private String ProductName;

    private int purchasedQuantity;

    private int purchasedPrice;

    private Date purchasedDate;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", CategoryName=").append(CategoryName);
        sb.append(", ProductName=").append(ProductName);
        sb.append(", purchasedQuantity=").append(purchasedQuantity);
        sb.append(", purchasedPrice=").append(purchasedPrice);
        sb.append(", purchasedDate=").append(purchasedDate);
        sb.append("]");
        return sb.toString();
    }
}
