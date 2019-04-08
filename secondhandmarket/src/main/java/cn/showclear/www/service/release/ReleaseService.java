package cn.showclear.www.service.release;

import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;

public interface ReleaseService {

    /**
     * 发布二手物品
     * @param productDo
     * @return
     */
    String releaseProduct(ProductDo productDo);


    /**
     * 发布求购信息
     * @param demandInfoDo
     * @return
     */
    String releaseDemandInfo(DemandInfoDo demandInfoDo);
}
