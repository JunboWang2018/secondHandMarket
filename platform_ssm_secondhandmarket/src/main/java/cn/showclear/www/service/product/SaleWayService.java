package cn.showclear.www.service.product;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.www.pojo.base.SaleWayDo;

import java.util.List;

public interface SaleWayService {

    /**
     * 通过指定条件搜索出售形式list
     * @param saleWayDo
     * @return
     */
    List<SaleWayDo> searchSaleWayList(SaleWayDo saleWayDo) throws IllegalArgumentException;

    /**
     * 通过指定条件搜索出售形式
     * @param saleWayDo
     * @return
     */
    SaleWayDo searchSaleWay(SaleWayDo saleWayDo) throws IllegalArgumentException, BusinessException;
}
