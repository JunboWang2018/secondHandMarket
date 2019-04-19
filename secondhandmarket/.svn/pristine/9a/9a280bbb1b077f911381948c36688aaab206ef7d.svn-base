package cn.showclear.www.dao.base.order;

import cn.showclear.www.pojo.base.BargainingRecordDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BargainRecordDao {
    /**
     * 根据条件查询议价记录list
     * @param bargainingRecordDo
     * @return
     */
    List<BargainingRecordDo> searchBargainRecordList(BargainingRecordDo bargainingRecordDo);

    /**
     * 添加议价记录
     * @param bargainingRecordDo
     * @return
     */
    Integer addRecord(BargainingRecordDo bargainingRecordDo);

    /**
     * 通过物品id逻辑删除议价记录
     * @param productId
     * @return
     */
    Integer deleteRecordByProdId(Integer productId);

    /**
     * 通过用户id逻辑删除议价记录
     * @param userId
     * @return
     */
    Integer deleteRecordByUserId(Integer userId);

    /**
     * 通过物品id和用户id逻辑删除议价记录
     * @param productId
     * @param userId
     * @return
     */
    Integer deleteRecordByProdIdAndUserId(Integer productId, Integer userId);
}
