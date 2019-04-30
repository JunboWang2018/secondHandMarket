package cn.showclear.www.pojo.base;

import java.sql.Timestamp;

/**
 * @author Wang Junbo
 * @date 2019/4/8
 * 商品类，对应数据库商品表T_PRODUCT
 */
public class ProductDo {
    private Integer productId;
    private String productNumber;
    private String name;
    private String description;
    private Double depreciationRate;    //折旧率
    private Integer quantity;           //数量
    private String image;
    private Double price;
    private Integer isSold;
    private Integer isSelling;
    private String typeCode;           //商品类型
    private String saleWayCode;        //出售形式
    private Integer timeLimit;
    private Integer addPriceLimit;
    private Integer userId;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private Integer isActive;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDepreciationRate() {
        return depreciationRate;
    }

    public void setDepreciationRate(Double depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIsSold() {
        return isSold;
    }

    public void setIsSold(Integer isSold) {
        this.isSold = isSold;
    }

    public Integer getIsSelling() {
        return isSelling;
    }

    public void setIsSelling(Integer isSelling) {
        this.isSelling = isSelling;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getSaleWayCode() {
        return saleWayCode;
    }

    public void setSaleWayCode(String saleWayCode) {
        this.saleWayCode = saleWayCode;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getAddPriceLimit() {
        return addPriceLimit;
    }

    public void setAddPriceLimit(Integer addPriceLimit) {
        this.addPriceLimit = addPriceLimit;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "ProductDo{" +
                "productId=" + productId +
                ", productNumber='" + productNumber + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", depreciationRate=" + depreciationRate +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", isSold=" + isSold +
                ", isSelling=" + isSelling +
                ", typeCode='" + typeCode + '\'' +
                ", saleWayCode='" + saleWayCode + '\'' +
                ", timeLimit=" + timeLimit +
                ", addPriceLimit=" + addPriceLimit +
                ", userId=" + userId +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", isActive=" + isActive +
                '}';
    }
}
