package cn.showclear.www.pojo.base;

import java.sql.Timestamp;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/8
 * 求购信息表实体，T_DEMAND_INFO
 */
public class DemandInfoDo {
    private Integer demandInfoId;
    private String demandInfoNumber;
    private String name;
    private String typeCode;
    private Double depreciationRate;
    private Integer quantity;
    private Double price;
    private String other;
    private Integer userId;
    private Timestamp createDate;
    private Timestamp modifyDate;

    public Integer getDemandInfoId() {
        return demandInfoId;
    }

    public void setDemandInfoId(Integer demandInfoId) {
        this.demandInfoId = demandInfoId;
    }

    public String getDemandInfoNumber() {
        return demandInfoNumber;
    }

    public void setDemandInfoNumber(String demandInfoNumber) {
        this.demandInfoNumber = demandInfoNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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

    @Override
    public String toString() {
        return "DemandInfoDo{" +
                "demandInfoId=" + demandInfoId +
                ", demandInfoNumber='" + demandInfoNumber + '\'' +
                ", name='" + name + '\'' +
                ", typeCode=" + typeCode +
                ", depreciationRate='" + depreciationRate + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", other='" + other + '\'' +
                ", userId=" + userId +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }
}
