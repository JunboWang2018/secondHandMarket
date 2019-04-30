package cn.showclear.www.dao.base.order;

import cn.showclear.www.pojo.base.BiddingRecordDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiddingRecordDao {
    /**
     * 通过自定义条件查询竞价记录
     * @param biddingRecordDo
     * @return
     */
    List<BiddingRecordDo> searchBiddRecdList(BiddingRecordDo biddingRecordDo);

    /**
     * 通过自定义条件查询最高价记录
     * @param biddingRecordDo
     * @return
     */
    BiddingRecordDo searchMaxPriceRecord(BiddingRecordDo biddingRecordDo);

    /**
     * 插入一条记录
     * @param biddingRecordDo
     * @return
     */
    Integer addRecord(BiddingRecordDo biddingRecordDo);
}
