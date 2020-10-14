package com.profectus.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="PRODUCT")
@SuppressWarnings("all")
public class Product {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(mappedBy = "Purchased",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Purchased> purchasedList;

    @OneToMany(mappedBy = "Sold",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Sold> soldList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", Category=").append(category.toString());
        sb.append(", productName=").append(productName);
        sb.append("]");
        return sb.toString();
    }
}
