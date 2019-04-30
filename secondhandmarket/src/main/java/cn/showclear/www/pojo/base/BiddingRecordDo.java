package cn.showclear.www.pojo.base;

import java.sql.Timestamp;

/**
 * @author Wang Junbo
 * @date 2019/4/8
 * 竞价记录表实体类
 */
public class BiddingRecordDo {
    private Integer biddingRecordId;
    private Integer productId;
    private Double biddingPrice;
    private String description;
    private Integer userId;
    private Timestamp createDate;

    public Integer getBiddingRecordId() {
        return biddingRecordId;
    }

    public void setBiddingRecordId(Integer biddingRecordId) {
        this.biddingRecordId = biddingRecordId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getBiddingPrice() {
        return biddingPrice;
    }

    public void setBiddingPrice(Double biddingPrice) {
        this.biddingPrice = biddingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "BiddingRecordDo{" +
                "biddingRecordId=" + biddingRecordId +
                ", productId=" + productId +
                ", biddingPrice=" + biddingPrice +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", createDate=" + createDate +
                '}';
    }
}
