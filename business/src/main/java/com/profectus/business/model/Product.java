package com.profectus.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Data
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

//    @OneToMany(mappedBy = "product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private List<Purchased> purchasedList;
//
//    @OneToMany(mappedBy = "product",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private List<Sold> soldList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public List<Purchased> getPurchasedList() {
//        return purchasedList;
//    }
//
//    public void setPurchasedList(List<Purchased> purchasedList) {
//        this.purchasedList = purchasedList;
//    }
//
//    public List<Sold> getSoldList() {
//        return soldList;
//    }
//
//    public void setSoldList(List<Sold> soldList) {
//        this.soldList = soldList;
//    }

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
