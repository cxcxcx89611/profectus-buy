package com.profectus.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfitSearchDto {

    private String productList;

    private String categoryList;

    private LocalDate searchFromDate;

    private LocalDate searchToDate;

    private Integer priceFrom;

    private Integer priceTo;

    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    public String getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(String categoryList) {
        this.categoryList = categoryList;
    }

    public LocalDate getSearchFromDate() {
        return searchFromDate;
    }

    public void setSearchFromDate(LocalDate searchFromDate) {
        this.searchFromDate = searchFromDate;
    }

    public LocalDate getSearchToDate() {
        return searchToDate;
    }

    public void setSearchToDate(LocalDate searchToDate) {
        this.searchToDate = searchToDate;
    }

    public Integer getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(int priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Integer getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(int priceTo) {
        this.priceTo = priceTo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productDtoList=").append(productList);
        sb.append(", categoryDtoList=").append(categoryList);
        sb.append(", searchFromDate=").append(searchFromDate);
        sb.append(", searchToDate=").append(searchToDate);
        sb.append(", priceFrom=").append(priceFrom);
        sb.append(", priceTo=").append(priceTo);
        sb.append("]");
        return sb.toString();
    }
}
