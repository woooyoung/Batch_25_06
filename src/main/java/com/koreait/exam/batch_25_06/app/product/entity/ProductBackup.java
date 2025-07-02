package com.koreait.exam.batch_25_06.app.product.entity;

import com.koreait.exam.batch_25_06.app.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ProductBackup extends BaseEntity {
    private String name;
    private int salePrice;
    private int price;
    private int wholesalePrice;
    private String makerShopName;

    private boolean isSoldOut; // 품절 여부

    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    public ProductBackup(Product product) {
        this.product = product;
        salePrice = product.getSalePrice();
        price = product.getPrice();
        wholesalePrice = product.getWholesalePrice();
        makerShopName = product.getMakerShopName();
        name = product.getName();
        isSoldOut = product.isSoldOut();
    }
}