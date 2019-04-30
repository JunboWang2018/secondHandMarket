package cn.showclear.www.dao.base.demandInfo;

import cn.showclear.www.pojo.base.DemandInfoDo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 求购信息
 */
@Repository
public interface DemandInfoDao {
    /**
     * 根据指定列条件查找求购信息
     * @param demandInfoDo
     * @return
     */
    List<DemandInfoDo> searchDemandInfoByCol(DemandInfoDo demandInfoDo);

    /**
     * 发布求购信息
     * @param demandInfoDo
     * @return
     */
    Integer releaseDemandInfo(DemandInfoDo demandInfoDo);
}
