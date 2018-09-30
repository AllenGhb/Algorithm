package sort;

import java.util.Arrays;

/**
 * 股票最大收益问题
 *
 * @author 周何圳 2018年05月28日 新建
 */
public class Text4_1_StockMaxProfit {

    /**
     * Use my own way. Θ(n)
     * 思路：从后往前扫描。
     * @param prices Stock prices
     * @return Max stock profit
     */
    public StockMaxProfitBean getMaxProfit_MyWay(int[] prices){
        //assume the prices length is at least 3.
        if(prices.length < 3){
            System.out.println("prices length must >= 3");
            return null;
        }


        StockMaxProfitBean sBean = new StockMaxProfitBean();
        int lastMaxPriceDay = prices.length - 1;
        int lastMaxPriceDayPrice = prices[prices.length - 1];
        int lastMaxProfit = Integer.MIN_VALUE;
        int lastMostProfitableDay = -1;
        int lastMostProfitableDayPrice = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            int tempProfit = lastMaxPriceDayPrice - prices[i];
            if(tempProfit > lastMaxProfit){
                lastMostProfitableDay = i;
                lastMostProfitableDayPrice = prices[i];
                lastMaxProfit = tempProfit;
                sBean.sellDay = lastMaxPriceDay;
                sBean.sellDayPrice = lastMaxPriceDayPrice;
                sBean.maxProfit = lastMaxProfit;
            }
            if(prices[i] > lastMaxPriceDayPrice){
                lastMaxPriceDayPrice = prices[i];
                lastMaxPriceDay = i;
            }
        }
        sBean.buyDay = lastMostProfitableDay;
        sBean.buyDayPrice = lastMostProfitableDayPrice;
        return sBean;

    }

    /**
     * 采用最大子数组递归解法 Θ(n*lgn)
     * @param prices Stock prices
     * @return Max stock profit
     */
    public StockMaxProfitBean getMaxProfit_MaxSubArray(int[] prices){
        //assume the prices length is at least 3.
        if(prices.length < 3){
            System.out.println("prices length must >= 3");
            return null;
        }

        //将原数组转换为股票波动价格数组
        int[] stockChangeArray = new int[prices.length - 1];
        for(int i = 0 ; i < stockChangeArray.length ; i++){
            stockChangeArray[i] = prices[i+1] - prices[i];
        }
        //然后使用最大子数组递归解法去取得stockChangeArray中的最大收益
        MaxSubArray_Recursive m = new MaxSubArray_Recursive();
        MaxSubArrayBean mBean = m.findMaxSubArray(stockChangeArray);
        //构建股票最大收益实体
        StockMaxProfitBean sBean = new StockMaxProfitBean();
        sBean.buyDay = mBean.startIndex;
        sBean.sellDay =mBean.endIndex + 1;
        sBean.buyDayPrice = prices[sBean.buyDay];
        sBean.sellDayPrice = prices[sBean.sellDay];
        sBean.maxProfit = mBean.sumValue;
        return sBean;
    }




    public static void main(String[] args) {
        Text4_1_StockMaxProfit t = new Text4_1_StockMaxProfit();
        int[] a1 = {100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97};	//price list
        int[] a2 = {10,11,7,10,6};
        int[] a3 = {100,80,79,79};
        System.out.println("prices: " + Arrays.toString(a1));
        System.out.println(t.getMaxProfit_MaxSubArray(a1));
        System.out.println(t.getMaxProfit_MyWay(a1));
        System.out.println("prices: " + Arrays.toString(a2));
        System.out.println(t.getMaxProfit_MaxSubArray(a2));
        System.out.println(t.getMaxProfit_MyWay(a2));
        System.out.println("prices: " + Arrays.toString(a3));
        System.out.println(t.getMaxProfit_MaxSubArray(a3));
        System.out.println(t.getMaxProfit_MyWay(a3));
    }


    /**
     * 股票最大收益实体
     *
     * @author 周何圳 2018年05月28日 新建
     */
    class StockMaxProfitBean {
        /** 买入日期 **/
        int buyDay;    //start from 0.
        /** 买入价格 **/
        int buyDayPrice;
        /** 卖出日期 **/
        int sellDay;
        /** 卖出价格 **/
        int sellDayPrice;
        /** 最大利润 **/
        int maxProfit;

        public String toString() {
            return "buyDay: " + buyDay + " buyDayPrice: " + buyDayPrice + " sellDay: " + sellDay + " sellDayPrice: " + sellDayPrice + " maxProfit: " + maxProfit;
        }
    }
}


