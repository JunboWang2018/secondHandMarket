package cn.showclear.www.service.order;

import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.BiddingRecordDo;

import java.util.List;

public interface BiddRecordService {
    /**
     * 根据条件查询竞价记录list
     * @param biddingRecordDo
     * @return
     */
    List<BiddingRecordDo> searchBiddRecordList(BiddingRecordDo biddingRecordDo) throws IllegalArgumentException;

    /**
     * 根据条件搜索最高价的记录
     * @param biddingRecordDo
     * @return
     */
    BiddingRecordDo searchMaxPriceRecord(BiddingRecordDo biddingRecordDo) throws IllegalArgumentException;

    /**
     * 插入一条竞价记录
     * @param biddingRecordDo
     * @return
     */
    Message addBiddRecord(BiddingRecordDo biddingRecordDo, String productNumber, String username) throws IllegalArgumentException;
}
