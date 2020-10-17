package com.profectus.business.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.profectus.business.model.Category;
import com.profectus.business.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SoldDto {

    private int id;

    private Product product;

    private int soldQuantity;

    private int soldPrice;

    private LocalDate soldDate;

    private String productName;

    private int categoryId;

    @JsonFormat(pattern="yyyy-MM-dd")
    public LocalDate getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(LocalDate soldDate) {
        this.soldDate = soldDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");        sb.append("id=").append(id);
        sb.append(", Product=").append(product);
        sb.append(", soldQuantity=").append(soldQuantity);
        sb.append(", soldPrice=").append(soldPrice);
        sb.append(", soldDate=").append(soldDate);
        sb.append("]");
        return sb.toString();
    }
}
