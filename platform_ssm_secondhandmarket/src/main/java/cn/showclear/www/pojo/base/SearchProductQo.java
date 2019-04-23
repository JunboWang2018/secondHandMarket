package cn.showclear.www.pojo.base;

/**
 * @author Wang Junbo
 * @description 物品详细信息查询类
 * @date 2019/4/9
 */
public class SearchProductQo {
    private ProductDo productDo;
    //查询属性
    private String typeName;
    private String userName;
    private String saleWayName;
    private Double biddMaxPrice;
    private String sellStatus;

    public Double getBiddMaxPrice() {
        return biddMaxPrice;
    }

    public void setBiddMaxPrice(Double biddMaxPrice) {
        this.biddMaxPrice = biddMaxPrice;
    }

    public ProductDo getProductDo() {
        return productDo;
    }

    public void setProductDo(ProductDo productDo) {
        this.productDo = productDo;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSaleWayName() {
        return saleWayName;
    }

    public void setSaleWayName(String saleWayName) {
        this.saleWayName = saleWayName;
    }

    public String getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(String sellStatus) {
        this.sellStatus = sellStatus;
    }

    @Override
    public String toString() {
        return "SearchProductQo{" +
                "productDo=" + productDo +
                ", typeName='" + typeName + '\'' +
                ", userName='" + userName + '\'' +
                ", saleWayName='" + saleWayName + '\'' +
                ", biddMaxPrice=" + biddMaxPrice +
                ", sellStatus='" + sellStatus + '\'' +
                '}';
    }
}
