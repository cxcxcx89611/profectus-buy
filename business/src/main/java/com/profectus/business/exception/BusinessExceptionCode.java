package com.profectus.business.exception;

public enum BusinessExceptionCode {
    NO_PARTIAL_PRODUCT_ERROR("Your searched product list contains product which not existing in System, please check!"),
    NO_SUCH_PRODUCTS_ERROR("Your searched product list has no product existing at DB!"),
    NO_SUCH_CATEGORY_ERROR("No such category in DB"),
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
