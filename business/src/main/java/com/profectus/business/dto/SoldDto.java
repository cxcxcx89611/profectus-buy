package com.profectus.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SoldDto {

    private int id;

    private String CategoryName;

    private String ProductName;

    private int soldQuantity;

    private int soldPrice;

    private Date soldDate;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", CategoryName=").append(CategoryName);
        sb.append(", ProductName=").append(ProductName);
        sb.append(", soldQuantity=").append(soldQuantity);
        sb.append(", soldPrice=").append(soldPrice);
        sb.append(", soldDate=").append(soldDate);
        sb.append("]");
        return sb.toString();
    }
}
