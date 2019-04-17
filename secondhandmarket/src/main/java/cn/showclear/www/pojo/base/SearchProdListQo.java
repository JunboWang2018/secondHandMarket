package cn.showclear.www.pojo.base;

/**
 * @author Wang Junbo
 * @description 自定义条件查询物品列表
 * @date 2019/4/15
 */
public class SearchProdListQo {
    private String typeCode;
    private String depRateSymbol;
    private Double depreciationRate;
    private Double maxPrice;
    private Double minPrice;
    private String saleWayCode;
    private Integer isSold;

    public Double getDepreciationRate() {
        return depreciationRate;
    }

    public void setDepreciationRate(Double depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    public Integer getIsSold() {
        return isSold;
    }

    public void setIsSold(Integer isSold) {
        this.isSold = isSold;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getDepRateSymbol() {
        return depRateSymbol;
    }

    public void setDepRateSymbol(String depRateSymbol) {
        this.depRateSymbol = depRateSymbol;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public String getSaleWayCode() {
        return saleWayCode;
    }

    public void setSaleWayCode(String saleWayCode) {
        this.saleWayCode = saleWayCode;
    }

    @Override
    public String toString() {
        return "SearchProdListQo{" +
                "typeCode='" + typeCode + '\'' +
                ", depRateSymbol='" + depRateSymbol + '\'' +
                ", depreciationRate='" + depreciationRate + '\'' +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                ", saleWayCode='" + saleWayCode + '\'' +
                ", isSold=" + isSold +
                '}';
    }
}
