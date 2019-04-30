package cn.showclear.utils;

import cn.showclear.www.pojo.base.DemandInfoDo;
import cn.showclear.www.pojo.base.ProductDo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Junbo
 * @description
 * @date 2019/4/15
 */
public class FilterByConditionUtil {

    public static List<ProductDo> filterProdListByRate(List<ProductDo> list, String depRateSymbol, Double depreciationRate) {
        if (list == null || list.size() == 0 ) {
            return list;
        }
        List<ProductDo> newList = new ArrayList<ProductDo>();
        double dr = depreciationRate.doubleValue();
        if (depRateSymbol != null && depRateSymbol.equals("equal")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() == dr) {
                    newList.add(list.get(i));
                }
            }
        }
        if (depRateSymbol != null && depRateSymbol.equals("big")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() > dr) {
                    newList.add(list.get(i));
                }
            }
        }
        if (depRateSymbol != null && depRateSymbol.equals("bigEqual")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() >= dr) {
                    newList.add(list.get(i));
                }
            }
        }
        if (depRateSymbol != null && depRateSymbol.equals("small")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() < dr) {
                    newList.add(list.get(i));
                }
            }
        }
        if (depRateSymbol != null && depRateSymbol.equals("smallEqual")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() <= dr) {
                    newList.add(list.get(i));
                }
            }
        }
        return newList;
    }

    public static List<DemandInfoDo> filterDemdInfoListByRate(List<DemandInfoDo> list, String depRateSymbol, Double depreciationRate) {
        if (list == null || list.size() == 0 ) {
            return list;
        }
        List<DemandInfoDo> newList = new ArrayList<DemandInfoDo>();
        double dr = depreciationRate.doubleValue();
        if (depRateSymbol != null && depRateSymbol.equals("equal")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() == dr) {
                    newList.add(list.get(i));
                }
            }
        }
        if (depRateSymbol != null && depRateSymbol.equals("big")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() > dr) {
                    newList.add(list.get(i));
                }
            }
        }
        if (depRateSymbol != null && depRateSymbol.equals("bigEqual")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() >= dr) {
                    newList.add(list.get(i));
                }
            }
        }
        if (depRateSymbol != null && depRateSymbol.equals("small")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() < dr) {
                    newList.add(list.get(i));
                }
            }
        }
        if (depRateSymbol != null && depRateSymbol.equals("smallEqual")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepreciationRate().doubleValue() <= dr) {
                    newList.add(list.get(i));
                }
            }
        }
        return newList;
    }
}
