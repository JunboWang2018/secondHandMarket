package cn.showclear.www.service.release;

import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import org.springframework.web.multipart.MultipartFile;

public interface ReleaseService {

    /**
     * 发布二手物品
     * @param productDo
     * @param username
     * @return
     */
    String releaseProduct(ProductDo productDo, String username, MultipartFile imageFile, String path);


    /**
     * 发布求购信息
     * @param demandInfoDo
     * @param username
     * @return
     */
    String releaseDemandInfo(DemandInfoDo demandInfoDo, String username);

}
