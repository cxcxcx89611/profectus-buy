package com.profectus.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="PURCHASED")
@SuppressWarnings("all")
public class Purchased {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="PURCHASED_QUANTITY")
    private int purchasedQuantity;

    @Column(name="PURCHASED_PRICE")
    private int purchasedPrice;

    @Column(name="PURCHASED_DATE")
    private Date purchasedDate;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="product_id")
    private Product product;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", Product=").append(product.toString());
        sb.append(", purchasedQuantity=").append(purchasedQuantity);
        sb.append(", purchasedPrice=").append(purchasedPrice);
        sb.append(", purchasedDate=").append(purchasedDate);
        sb.append("]");
        return sb.toString();
    }
}
