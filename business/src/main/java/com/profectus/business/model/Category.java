package com.profectus.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CATEGORY")
@Entity
@SuppressWarnings("all")
public class Category {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="CATEGORY_NAME")
    private String categoryName;

    @OneToMany(mappedBy = "category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Product> productList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", productList=").append(productList);
        sb.append("]");
        return sb.toString();
    }
}
