package com.profectus.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {

    private int id;

    private String categoryName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");        sb.append("id=").append(id);
        sb.append(", categoryName=").append(categoryName);
        sb.append("]");
        return sb.toString();
    }
}
