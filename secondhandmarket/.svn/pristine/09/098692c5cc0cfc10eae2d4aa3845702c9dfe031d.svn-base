package cn.showclear.www.service.release.impl;

import cn.showclear.utils.AutoGenerateNumberUtil;
import cn.showclear.www.common.constant.CommonConstant;
import cn.showclear.www.dao.base.ReleaseDao;
import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.service.release.ReleaseService;
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
    private ReleaseDao releaseDao;

    /**
     * 发布物品
     * @param productDo
     * @param username
     * @param imageFile
     * @return
     */
    @Override
    public String releaseProduct(ProductDo productDo, String username, MultipartFile imageFile, String path) {
        log.info("releaseService: productDo = " + productDo + ", username = " + username + ", imageFile = " + imageFile);
        //设置用户id，先通过用户名查找id
        Integer userId = releaseDao.findUserIdByName(username);
        productDo.setUserId(userId);
        //发布物品时默认未售出
        productDo.setIsSold(0);
        //生成物品编号并设置
        String productNumber = AutoGenerateNumberUtil.getAutoGenerateId("PROD");
        log.info("productNumber = " + productNumber);
        if (!StringUtils.isEmpty(productNumber)) {
            productDo.setProductNumber(productNumber);
        } else {
            return CommonConstant.ERROR;
        }
        //生成图片名并保存
        String suffix = imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().indexOf("."));
        if(StringUtils.isEmpty(suffix)) {
            suffix = ".jpg";
        }
        String imageName = productNumber + "_1" + suffix;
        productDo.setImage(imageName);
        String result = this.uploadImageFile(imageFile, imageName, path);
        if(result.equals(CommonConstant.SUCCESS)) {
            log.info("insert into table product info " + productDo.toString());
            Integer count = releaseDao.releaseProduct(productDo);
            log.info("insert Product table " + count + " rows");
            if (count == 1) {
                return CommonConstant.SUCCESS;
            }
        }
        return CommonConstant.ERROR;
    }

    /**
     * 发布求购信息
     * @param demandInfoDo
     * @return
     */
    @Override
    public String releaseDemandInfo(DemandInfoDo demandInfoDo, String username) {
        log.info("releaseService: demandInfoDo = " + demandInfoDo + ", username = " + username);
        //设置用户id，先通过用户名查找id
        Integer userId = releaseDao.findUserIdByName(username);
        demandInfoDo.setUserId(userId);
        //生成求购信息编号并设置
        String demandInfoNumber = AutoGenerateNumberUtil.getAutoGenerateId("DMDI");
        log.info("productNumber = " + demandInfoNumber);
        if (!StringUtils.isEmpty(demandInfoNumber)) {
            log.info("insert into table product info " + demandInfoDo.toString());
            demandInfoDo.setDemandInfoNumber(demandInfoNumber);
            Integer count = releaseDao.releaseDemandInfo(demandInfoDo);
            log.info("insert DemandInfo table " + count + " rows");
            if (count == 1) {
                return CommonConstant.SUCCESS;
            } else {
                return CommonConstant.ERROR;
            }
        } else {
            return CommonConstant.ERROR;
        }
    }


    /**
     * 文件设置文件名，并上传
     * @param imageFile
     * @return
     */
    private String uploadImageFile(MultipartFile imageFile, String imageFileName, String path) {
        if (imageFile != null) {
            log.info("image file name is " + imageFile.getName() + ", it will change to" + imageFileName);
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
                e.printStackTrace();
            }
        }
        return CommonConstant.SUCCESS;
    }

}
