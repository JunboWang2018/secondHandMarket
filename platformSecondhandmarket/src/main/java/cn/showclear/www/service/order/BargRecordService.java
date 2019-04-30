package cn.showclear.www.service.order;

import cn.showclear.www.common.constant.Message;
import cn.showclear.www.pojo.base.BargainingRecordDo;
import cn.showclear.www.pojo.base.BiddingRecordDo;

import java.util.List;

public interface BargRecordService {

    /**
     * 按默认初始化参数 is_active = 1
     * @param bargainingRecordDo
     * @return
     */
    BargainingRecordDo initSearchArguToDefault(BargainingRecordDo bargainingRecordDo);

    /**
     * 根据条件查询议价记录list
     * @param bargainingRecordDo
     * @return
     */
    List<BargainingRecordDo> searchBargRecordList(BargainingRecordDo bargainingRecordDo) throws IllegalArgumentException;

    /**
     * 根据条件搜索最高价的记录
     * @param bargainingRecordDo
     * @return
     */
    BargainingRecordDo searchMaxPriceRecord(BargainingRecordDo bargainingRecordDo) throws IllegalArgumentException;

    /**
     * 插入一条议价记录
     * @param bargainingRecordDo
     * @return
     */
    Message addBargRecord(BargainingRecordDo bargainingRecordDo, String productNumber, String username) throws IllegalArgumentException;

    /**
     * 逻辑删除议价记录
     * @param productId
     * @param userId
     * @return
     */
    Message deleteBargRecord(Integer productId, Integer userId);
}
