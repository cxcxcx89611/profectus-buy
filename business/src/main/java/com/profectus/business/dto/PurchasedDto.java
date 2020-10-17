package com.profectus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.profectus.business.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasedDto {

    private int id;

    private Product product;

    private String productName;

    private int categoryId;

    private int purchasedQuantity;

    private int purchasedPrice;

    private LocalDate purchasedDate;

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
        sb.append(" [");        sb.append("id=").append(id);
        sb.append(", Product=").append(product);
        sb.append(", purchasedQuantity=").append(purchasedQuantity);
        sb.append(", purchasedPrice=").append(purchasedPrice);
        sb.append(", purchasedDate=").append(purchasedDate);
        sb.append("]");
        return sb.toString();
    }
}
