package com.profectus.business.exception;

public enum BusinessExceptionCode {
    PURCHASED_QUANTITY_ERROR("purchased quantity should be number"),
    SOLD_QUANTITY_ERROR("sold quantity should be number"),
    PURCHASED_PRICE_ERROR("Price should be number"),
    SOLD_PRICE_ERROR("Sold price should be number"),
    ;

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
