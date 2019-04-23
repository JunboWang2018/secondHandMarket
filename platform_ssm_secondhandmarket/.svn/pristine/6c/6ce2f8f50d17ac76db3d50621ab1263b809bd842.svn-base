package cn.showclear.www.dao.base;

import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseDao {

    /**
     * 发布二手物品
     * @param productDo
     * @return 返回受影响（插入）的行数。 [0: 插入未成功，1：插入成功]
     */
    Integer releaseProduct(ProductDo productDo);

    /**
     * 发布求购信息
     * @param demandInfoDo
     * @return 返回受影响（插入）的行数。 [0: 插入未成功，1：插入成功]
     */
    Integer releaseDemandInfo(DemandInfoDo demandInfoDo);

    /**
     * 通过用户名查找id
     * @param username
     * @return
     */
    Integer findUserIdByName(String username);
}
