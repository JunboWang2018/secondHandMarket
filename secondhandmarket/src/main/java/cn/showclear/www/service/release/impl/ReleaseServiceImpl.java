package cn.showclear.www.service.release.impl;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.utils.AutoGenerateNumberUtil;
import cn.showclear.www.common.constant.CommonConstant;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.dao.base.ReleaseDao;
import cn.showclear.www.dao.base.demandInfo.DemandInfoDao;
import cn.showclear.www.dao.base.product.ProductDao;
import cn.showclear.www.dao.base.user.UserDao;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.UserDo;
import cn.showclear.www.service.release.ReleaseService;
import cn.showclear.www.service.validate.ValidateService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/8
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {
    private static final Logger log = LoggerFactory.getLogger(ReleaseServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ValidateService validateService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DemandInfoDao demandInfoDao;

    /**
     * 发布物品
     * @param productDo
     * @param username
     * @param imageFile
     * @return
     */
    @Override
    public Message releaseProduct(ProductDo productDo, String username, MultipartFile imageFile, String path)
            throws IllegalArgumentException,BusinessException {
        log.info("releaseService: productDo = " + productDo + ", username = " + username + ", imageFile = " + imageFile);
        //设置用户id，先通过用户名查找id
        UserDo userDo = userDao.searchUser(username);
        log.info(userDo.toString());
        productDo.setUserId(userDo.getUserId());
        //发布物品时默认未售出
        productDo.setIsSold(0);
        //生成物品编号并设置
        String productNumber = AutoGenerateNumberUtil.getAutoGenerateId("PROD");
        log.info("productNumber = " + productNumber);
        if (StringUtils.isEmpty(productNumber)) {
            throw new BusinessException(Message.NUMBER_GEN_ERROR.getCode(), Message.NUMBER_GEN_ERROR.getMessage());
        }
        productDo.setProductNumber(productNumber);
        //生成图片名并保存
        String suffix = imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().indexOf("."));
        if(StringUtils.isEmpty(suffix)) {
            suffix = ".jpg";
        }
        String imageName = productNumber + "_1" + suffix;
        productDo.setImage(imageName);
        //校验物品信息
        validateService.validateProductRelease(productDo);
        this.uploadImageFile(imageFile, imageName, path);
        log.info("insert into table product info " + productDo.toString());
        Integer count = productDao.releaseProduct(productDo);
        log.info("insert Product table " + count + " rows");
        if (count == 1) {
            return Message.RELEASE_SUCCESS;
        }
        return Message.RELEASE_FAILED;
    }

    /**
     * 发布求购信息
     * @param demandInfoDo
     * @return
     */
    @Override
    public Message releaseDemandInfo(DemandInfoDo demandInfoDo, String username) throws IllegalArgumentException, BusinessException {
        log.info("releaseService: demandInfoDo = " + demandInfoDo + ", username = " + username);
        //设置用户id，先通过用户名查找id
        UserDo userDo = userDao.searchUser(username);
        demandInfoDo.setUserId(userDo.getUserId());
        //生成求购信息编号并设置
        String demandInfoNumber = AutoGenerateNumberUtil.getAutoGenerateId("DMDI");
        log.info("productNumber = " + demandInfoNumber);
        if (StringUtils.isEmpty(demandInfoNumber)) {
            throw new BusinessException(Message.NUMBER_GEN_ERROR.getCode(), Message.NUMBER_GEN_ERROR.getMessage());
        }
        demandInfoDo.setDemandInfoNumber(demandInfoNumber);
        //校验信息
        validateService.validateDemandInfoRelease(demandInfoDo);
        log.info("insert into table demand info " + demandInfoDo.toString());
        Integer count = demandInfoDao.releaseDemandInfo(demandInfoDo);
        log.info("insert DemandInfo table " + count + " rows");
        if (count == 1) {
            return Message.RELEASE_SUCCESS;
        }
        return Message.RELEASE_FAILED;
    }


    /**
     * 文件设置文件名，并上传
     * @param imageFile
     * @return
     */
    private void uploadImageFile(MultipartFile imageFile, String imageFileName, String path) throws BusinessException{
        if (imageFile != null) {
            log.info("image file name is " + imageFile.getName() + ", it will change to " + imageFileName);
            try {
                long startTime = System.currentTimeMillis();
                log.info("image upload start, time is " + startTime);
                path = path + "image\\";
                File pathFile = new File(path);
                if (!pathFile.exists()) {
                    pathFile.mkdirs();
                }
                String imagePath = path + imageFileName;
                log.info("image path is " + imagePath);
                log.info("image upload success, end time is " + (System.currentTimeMillis() - startTime));
                //转存文件
                imageFile.transferTo(new File(imagePath));
            }catch (Exception e){
                log.error("文件上传错误", e);
                throw new BusinessException(Message.IMAGE_UPLOAD_FAILED.getCode(), Message.IMAGE_UPLOAD_FAILED.getMessage());
            }
        }
    }

}
