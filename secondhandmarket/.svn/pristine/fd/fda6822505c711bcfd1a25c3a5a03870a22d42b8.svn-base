package cn.showclear.www.service.release;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.www.common.constant.Message;
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
    Message releaseProduct(ProductDo productDo, String username, MultipartFile imageFile, String path) throws IllegalArgumentException, BusinessException;


    /**
     * 发布求购信息
     * @param demandInfoDo
     * @param username
     * @return
     */
    Message releaseDemandInfo(DemandInfoDo demandInfoDo, String username) throws IllegalArgumentException, BusinessException;

}
