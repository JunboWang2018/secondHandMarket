package cn.showclear.www.pojo.base;

/**
 * @author Wang Junbo
 * @description 求购信息条件搜索查询类
 * @date 2019/4/16
 */
public class SearchDemdInfoListQo {
    private String typeCode;
    private String depRateSymbol;
    private Double depreciationRate;

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

    public Double getDepreciationRate() {
        return depreciationRate;
    }

    public void setDepreciationRate(Double depreciationRate) {
        this.depreciationRate = depreciationRate;
    }

    @Override
    public String toString() {
        return "SearchDemdInfoListQo{" +
                "typeCode='" + typeCode + '\'' +
                ", depRateSymbol='" + depRateSymbol + '\'' +
                ", depreciationRate=" + depreciationRate +
                '}';
    }
}
