package com.profectus.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfitSearchDto {

    private List<ProductDto> productDtoList;

    private List<CategoryDto> categoryDtoList;

    private Date searchFromDate;

    private Date searchToDate;

    private int priceFrom;

    private int priceTo;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productDtoList=").append(productDtoList);
        sb.append(", categoryDtoList=").append(categoryDtoList);
        sb.append(", searchFromDate=").append(searchFromDate);
        sb.append(", searchToDate=").append(searchToDate);
        sb.append(", priceFrom=").append(priceFrom);
        sb.append(", priceTo=").append(priceTo);
        sb.append("]");
        return sb.toString();
    }
}
