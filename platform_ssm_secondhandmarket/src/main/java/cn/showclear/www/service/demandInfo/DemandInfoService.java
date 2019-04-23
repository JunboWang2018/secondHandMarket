package cn.showclear.www.service.demandInfo;

import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.SearchDemdInfoQo;
import cn.showclear.www.pojo.base.SearchProdListQo;

import java.util.List;

public interface DemandInfoService {

    /**
     * 通过编号查找某条求购信息
     * @param demandInfoNumber
     * @return
     */
    DemandInfoDo searchDemandInfo(String demandInfoNumber);

    /**
     * 通过编号查找某条求购信息,并查找其需要的参数
     * @param demandInfoNumber
     * @return
     */
    SearchDemdInfoQo searchDemdInfoQo(String demandInfoNumber);



    /**
     * 按条件查找求购信息，返回求购信息的集合
     * @param demandInfoDo
     * @return
     */

    List<DemandInfoDo> searchDemandInfoList(DemandInfoDo demandInfoDo) throws IllegalArgumentException;

    /**
     * 根据自定义条件查询求购信息，返回求购信息集合
     * @param searchProdListQo
     * @return
     * @throws IllegalArgumentException
     */
    List<DemandInfoDo> searchDemdInfoListByQo(SearchProdListQo searchProdListQo);
}
