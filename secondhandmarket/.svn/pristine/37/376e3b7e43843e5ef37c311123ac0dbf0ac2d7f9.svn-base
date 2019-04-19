package cn.showclear.utils;

import cn.showclear.www.dao.base.product.ProductDao;
import cn.showclear.www.pojo.base.BiddingRecordDo;
import cn.showclear.www.pojo.base.ProductDo;
import cn.showclear.www.pojo.base.UserDo;
import cn.showclear.www.service.order.BiddRecordService;
import cn.showclear.www.service.order.OrderService;
import cn.showclear.www.service.product.ProductService;
import cn.showclear.www.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.TimerTask;

/**
 * @author Wang Junbo
 * @description  竞价商品竞价期限检测服务
 * @date 2019/4/19
 */
public class BiddOrderThread extends TimerTask {
    private static final Logger log = LoggerFactory.getLogger(BiddOrderThread.class);

    private ProductService productService;

    private ProductDao productDao;

    private BiddRecordService biddRecordService;

    private OrderService orderService;

    private UserService userService;

    public BiddOrderThread(ProductService productService, ProductDao productDao, BiddRecordService biddRecordService, OrderService orderService, UserService userService) {
        this.productService = productService;
        this.productDao = productDao;
        this.biddRecordService = biddRecordService;
        this.orderService = orderService;
        this.userService = userService;
    }


    @Override
    public void run() {
        log.debug("Check BIDD product is expire, timeMillis is " + System.currentTimeMillis());
        //查询所有正在出售的竞价商品
        ProductDo prodQuery = new ProductDo();
        prodQuery = productService.searchProductInit(prodQuery);
        prodQuery.setSaleWayCode("BIDD");
        List<ProductDo> resultList = productService.searchProductList(prodQuery);
        if (resultList == null) {
            return;
        }
        for (int i = 0; i < resultList.size(); i++) {
            if (this.isExpire(resultList.get(i))) {
                //倒计时已结束，取竞价记录中最高价成交，若没有竞价记录，则流拍，做下架处理
                this.processExpireProd(resultList.get(i));
            }
        }
    }

    /**
     * 判断倒计时是否已结束
     * @param productDo
     * @return
     */
    private boolean isExpire(ProductDo productDo) {
        if (System.currentTimeMillis() >= (productDo.getCreateDate().getTime() + productDo.getTimeLimit() * 1000)) {
            return true;
        } else {
            return false;
        }
    }

    private void processExpireProd(ProductDo productDo) {
        BiddingRecordDo biddQuery = new BiddingRecordDo();
        biddQuery.setProductId(productDo.getProductId());
        BiddingRecordDo biddResult = biddRecordService.searchMaxPriceRecord(biddQuery);
        if (biddResult == null) {
            //无竞价记录，流拍处理
            productDo.setIsSelling(0);
            productDao.takeUpOrDownProd(productDo);
        } else {
            //取最高价生成订单
            UserDo userQuery = new UserDo();
            userQuery.setUserId(biddResult.getUserId());
            UserDo userResult = userService.searchUser(userQuery);
            System.out.println("orderService = " + orderService + ", biddResult = " + biddResult + ", username = " + userResult);
            orderService.generateOrder(productDo.getProductNumber(), biddResult.getBiddingPrice(), userResult.getUserName());
        }
    }
}
