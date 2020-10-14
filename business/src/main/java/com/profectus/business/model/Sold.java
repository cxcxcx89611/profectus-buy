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
@Table(name="SOLD")
@SuppressWarnings("all")
public class Sold {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private int id;

    @Column(name="SOLD_QUANTITY")
    private int soldQuantity;

    @Column(name="SOLD_PRICE")
    private int soldPrice;

    @Column(name="SOLD_DATE")
    private Date soldDate;

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
        sb.append(", soldQuantity=").append(soldQuantity);
        sb.append(", soldPrice=").append(soldPrice);
        sb.append(", soldDate=").append(soldDate);
        sb.append("]");
        return sb.toString();
    }
}
