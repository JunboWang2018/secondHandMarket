package cn.showclear.www.service.product.impl;

import cn.com.scooper.common.exception.BusinessException;
import cn.showclear.utils.FilterByConditionUtil;
import cn.showclear.www.common.constant.Message;
import cn.showclear.www.dao.base.product.ProductDao;
import cn.showclear.www.pojo.base.*;
import cn.showclear.www.service.order.BargRecordService;
import cn.showclear.www.service.order.BiddRecordService;
import cn.showclear.www.service.product.ProdTypeService;
import cn.showclear.www.service.product.ProductService;
import cn.showclear.www.service.product.SaleWayService;
import cn.showclear.www.service.user.UserService;
import cn.showclear.www.service.validate.ValidateService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Junbo
 * @description  物品查询
 * @date 2019/4/11
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ValidateService validateService;

    @Autowired
    private UserService userService;

    @Autowired
    private SaleWayService saleWayService;

    @Autowired
    private ProdTypeService prodTypeService;

    @Autowired
    private BiddRecordService biddingRecordService;

    @Autowired
    private BargRecordService bargRecordService;

    /**
     * 通过商品编号查询物品
     * @param productDo
     * @return 物品对象
     */
    @Override
    public ProductDo searchProduct(ProductDo productDo) {
        List<ProductDo> list = null;
        list = this.searchProductList(productDo);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * 初始化查询,设置默认值0（未售出），在售1(出售中)，有效值1(有效)
     * @param productDo
     * @return
     */
    public ProductDo searchProductInit(ProductDo productDo) {
        //设置默认值0（未售出），在售1(出售中)，有效值1(有效)
        if (productDo.getIsSold() == null) {
            productDo.setIsSold(0);
        }
        if (productDo.getIsSelling() == null) {
            productDo.setIsSelling(1);
        }
        if (productDo.getIsActive() == null) {
            productDo.setIsActive(1);
        }
        return productDo;
    }



    /**
     * 查找某个物品，并查找其它需要的参数
     * @param prodDo
     * @return
     */
    @Override
    public SearchProductQo searchProductQo(ProductDo prodDo) {
        SearchProductQo searchProductQo = new SearchProductQo();
        //查询物品
        ProductDo productDo = this.searchProduct(prodDo);
        if (productDo == null) {
            throw new BusinessException(Message.PRODUCT_NOT_EXIST.getCode(), Message.PRODUCT_NOT_EXIST.getMessage());
        }
        searchProductQo = this.queryProdInfo(productDo);
        return searchProductQo;
    }

    /**
     * 查找多个物品，并查找其它需要的参数
     * @param productDo
     * @return
     * @throws IllegalArgumentException
     * @throws BusinessException
     */
    @Override
    public List<SearchProductQo> searchProdQoList(ProductDo productDo) throws IllegalArgumentException, BusinessException {
        List<SearchProductQo> prodQoList = new ArrayList<SearchProductQo>();
        List<ProductDo> prodList = this.searchProductList(productDo);
        if (prodList == null) {
            return new ArrayList<SearchProductQo>();
        }
        //其他信息查詢
        for (int i = 0; i < prodList.size(); i++) {
            prodQoList.add(this.queryProdInfo(prodList.get(i)));
        }
        return prodQoList;
    }

    /**
     * 查询单个物品所需的其它信息
     * @param productDo
     * @return SearchProductQo
     */
    private SearchProductQo queryProdInfo(ProductDo productDo) {
        SearchProductQo searchProductQo = new SearchProductQo();
        searchProductQo.setProductDo(productDo);
        //查询用户名
        UserDo userDoQuery = new UserDo();
        userDoQuery.setUserId(productDo.getUserId());
        UserDo userDo = userService.searchUser(userDoQuery);
        searchProductQo.setUserName(userDo.getUserName());
        //查询出售方式
        SaleWayDo saleWayDoQuery = new SaleWayDo();
        saleWayDoQuery.setCode(productDo.getSaleWayCode());
        SaleWayDo saleWayDo = saleWayService.searchSaleWay(saleWayDoQuery);
        searchProductQo.setSaleWayName(saleWayDo.getName());
        //查询物品类型
        ProductTypeDo prodTypeDoQuery = new ProductTypeDo();
        prodTypeDoQuery.setCode(productDo.getTypeCode());
        ProductTypeDo prodTypeDo = prodTypeService.searchProdType(prodTypeDoQuery);
        searchProductQo.setTypeName(prodTypeDo.getName());
        //如果是竞价类型，查询当前最高价并设置,若没有记录，设置初始价格
        if (searchProductQo.getProductDo().getSaleWayCode().equals("BIDD")) {
            BiddingRecordDo biddingRecordDoQuery = new BiddingRecordDo();
            biddingRecordDoQuery.setProductId(searchProductQo.getProductDo().getProductId());
            BiddingRecordDo biddingRecordDo = biddingRecordService.searchMaxPriceRecord(biddingRecordDoQuery);
            if (biddingRecordDo != null) {
                searchProductQo.setBiddMaxPrice(biddingRecordDo.getBiddingPrice());
            } else {
                searchProductQo.setBiddMaxPrice(productDo.getPrice());
            }
        }
        if (productDo.getIsSelling().intValue() == 1) {
            searchProductQo.setSellStatus("出售中");
        } else if (productDo.getIsSold().intValue() == 0){
            searchProductQo.setSellStatus("已下架");
        } else {
            searchProductQo.setSellStatus("已出售");
        }
        return searchProductQo;
    }


    /**
     * 通过指定条件查询物品
     * @param productDo
     * @return 物品对象集合
     */
    @Override
    public List<ProductDo> searchProductList(ProductDo productDo) {
        //输入参数校验
        validateService.validateProductSearch(productDo);
        return productDao.searchProdByCol(productDo);
    }

    @Override
    public SearchProdListQo searchProductQoInit(SearchProdListQo searchProdListQo) {
        //设置默认值0（未售出），在售1(出售中)，有效值1(有效)
        if (searchProdListQo.getIsSold() == null) {
            searchProdListQo.setIsSold(0);
        }
        if (searchProdListQo.getIsSelling() == null) {
            searchProdListQo.setIsSelling(1);
        }
        if (searchProdListQo.getIsActive() == null) {
            searchProdListQo.setIsActive(1);
        }
        return searchProdListQo;
    }

    @Override
    public List<ProductDo> searchProdListQo(SearchProdListQo searchProdListQo) {
        this.correctCondition(searchProdListQo);
        List<ProductDo> list = productDao.searchProdListByQo(searchProdListQo);
        //按折旧率条件筛选
        if (list != null && !StringUtils.isEmpty(searchProdListQo.getDepRateSymbol()) && searchProdListQo.getDepreciationRate() != null) {
            list = FilterByConditionUtil.filterProdListByRate(list, searchProdListQo.getDepRateSymbol(), searchProdListQo.getDepreciationRate());
        }
        return list;
    }

    @Override
    public Integer saleProduct(String productNumber) {
        return productDao.saleProduct(productNumber);
    }

    @Override
    public Message takeUpOrDownProd(ProductDo productDo) {
        //查询出售类型，竞价商品拒绝下架，议价商品下架删除（is_active=0）议价记录
        ProductDo prodQuery = new ProductDo();
        if (productDo.getProductId() != null) {
            prodQuery.setProductId(productDo.getProductId());
        } else if (productDo.getProductNumber() != null) {
            prodQuery.setProductNumber(productDo.getProductNumber());
        } else {
            throw new IllegalArgumentException("参数错误");
        }
        ProductDo prodResult = this.searchProduct(prodQuery);
        if (prodResult == null) {
            return Message.PRODUCT_NOT_EXIST;
        }
        if (prodResult.getSaleWayCode().equals("BIDD")) {
            return Message.BIDD_PROD_REJECT_TAKE_DOWN;
        } else if (prodResult.getSaleWayCode().equals("BARG")) {
            Message bargMessage =  bargRecordService.deleteBargRecord(productDo.getProductId(), null);
            if (bargMessage != Message.DELETE_BARG_RECORD_SUCCESS) {
                return bargMessage;
            }
        }
        Integer result = productDao.takeUpOrDownProd(productDo);
        if (result == 1) {
            if (productDo.getIsSelling() == 1) {
                return Message.TAKE_UP_PROD_SUCCESS;
            } else {
                return Message.TAKE_DOWN_PROD_SUCCESS;
            }
        } else {
            if (productDo.getIsSelling() == 1) {
                return Message.TAKE_UP_PROD_FAILED;
            } else {
                return Message.TAKE_DOWN_PROD_FAILED;
            }
        }
    }

    /**
     * 更正条件，将属性值为''改成null，以免不必要的异常
     * @param searchProdListQo
     */
    private void correctCondition(SearchProdListQo searchProdListQo) {
        if (searchProdListQo.getDepRateSymbol() != null && searchProdListQo.getDepRateSymbol().equals("")) {
            searchProdListQo.setDepRateSymbol(null);
        }
        if (searchProdListQo.getDepreciationRate() != null && searchProdListQo.getDepreciationRate().equals("")) {
            searchProdListQo.setDepreciationRate(null);
        }
        if (searchProdListQo.getTypeCode() != null && searchProdListQo.getTypeCode().equals("")) {
            searchProdListQo.setTypeCode(null);
        }
        if (searchProdListQo.getSaleWayCode() != null && searchProdListQo.getSaleWayCode().equals("")) {
            searchProdListQo.setSaleWayCode(null);
        }
    }
}
