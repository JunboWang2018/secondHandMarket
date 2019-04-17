package cn.showclear.www.pojo.base;

import java.sql.Timestamp;

/**
 * @author Wang Junbo
 * @description 记录查询类
 * @date 2019/4/17
 */
public class RecordQo {
    private Integer recordId;
    private Double price;
    private String username;
    private Timestamp time;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RecordQo{" +
                "recordId=" + recordId +
                ", price=" + price +
                ", username='" + username + '\'' +
                ", time=" + time +
                '}';
    }
}
