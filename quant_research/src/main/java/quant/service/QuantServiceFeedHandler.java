package quant.service;

import java.util.ArrayList;
import java.util.List;

import quant.common.entity.BidLevelsItemSub;
import quant.common.entity.Level2MarketData;
import quant.common.entity.SellLevelsItemSub;
import quant.common.util.DateUtil;

import com.datayes.whale.common.client.ServiceFeedHandler;
import com.datayes.whale.common.client.model.Result;
import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData;
import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData.BidLevelsItem;
import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData.SellLevelsItem;
import com.datayes.whale.common.client.model.response.MDLSZL2Msg.MarketData;

public class QuantServiceFeedHandler extends ServiceFeedHandler{
	
	//result即为接收到的数据，其中分为2部分，header和body，
    //需要根据header中的serviceID和messageID，将其强转为相应的Msg，参考onSHL1Message()
	public void sayhello(){
		System.out.println("hello");
	}
    @Override
    public void onAPIMessage(Result result) {
        System.out.println("---------API---------");

    }
    @Override
    public void onSYSMessage(Result result) {

    }
    @Override
    public void onCFFEXMessage(Result result) {

    }
    @Override
    public void onCZCEMessage(Result result) {

    }
    @Override
    public void onDCEMessage(Result result) {

    }
    @Override
    public void onSHFEMessage(Result result) {

    }
    
    @Override
    public void onSHL1Message(Result result) {
    	
    }
    
    int i = 0;
    Long timeAccu = 0l;
    Long startTime = DateUtil.currentTimeMillis();
    Long averTime = 0L;
    @Override
    public void onSHL2Message(Result result) {
    	getMarketData(result);
//        System.out.println("+++++++++++++++++++++++++++++++++++++"+i++);
//        SHL2MarketData shl2MarketData = (SHL2MarketData) result.getBody();
//        System.out.println("-------------------------------------");
//        System.out.println("openPrice is: " + shl2MarketData.getOpenPrice());
//        List<BidLevelsItem> bidLevelsItemList = shl2MarketData.getBidLevelsList();
//        for (BidLevelsItem bidLevelsItem : bidLevelsItemList) {
//			System.out.println("BidLevelsItem" + bidLevelsItem.toString());
//		}
//        System.out.println(shl2MarketData.getBidLevelsList());
//        System.out.println(startTime);
//    	Result temp = result;
//    	Long endTime = DateUtil.currentTimeMillis();
//    	averTime = (endTime - startTime)/i;
//    	System.out.println("level 2 访问平均时间： "+ averTime);
//        System.out.println(result);
    }
    @Override
    public void onSZL1Message(Result result) {

    }
    @Override
    public void onSZL2Message(Result result) {
    }
    @Override
    public void onHKEXMessage(Result result) {
       //System.out.println("---------HK---------");
    }
    
    public Level2MarketData getMarketData(Result result){
    	System.out.println("*************************");
    	Level2MarketData marketData = new Level2MarketData();
    	SHL2MarketData shl2MarketData = (SHL2MarketData) result.getBody();
    	//marketData.setUpdateTime(updateTime);
    	marketData.setSecurityId(shl2MarketData.getSecurityID());
    	marketData.setPreClosePrice(shl2MarketData.getPreCloPrice().getValue()/1000D);
    	marketData.setHighPrice(shl2MarketData.getHighPrice().getValue()/1000D);
    	marketData.setOpenPrice(shl2MarketData.getOpenPrice().getValue()/1000d);
    	marketData.setLowPrice(shl2MarketData.getLowPrice().getValue()/1000d);
    	marketData.setClosePrice(shl2MarketData.getClosePrice().getValue()/1000d);
    	marketData.setLastPrice(shl2MarketData.getLastPrice().getValue()/1000d);
    	List<BidLevelsItemSub> bidLevelsItemSubList = new ArrayList<BidLevelsItemSub>();
    	for (BidLevelsItem bidLevelsItem : shl2MarketData.getBidLevelsList()) {
    		BidLevelsItemSub temp = new BidLevelsItemSub();
    		temp.setBidPrice(bidLevelsItem.getOrderPrice().getValue()/1000f);
    		temp.setBidVolume(bidLevelsItem.getOrderVol().getValue());
    		bidLevelsItemSubList.add(temp);
		}
    	marketData.setBidLevelsList(bidLevelsItemSubList);
    	List<SellLevelsItemSub> sellLevelsItemSubList = new ArrayList<SellLevelsItemSub>();
    	for (SellLevelsItem sellLevelsItem : shl2MarketData.getSellLevelsList()) {
    		SellLevelsItemSub temp = new SellLevelsItemSub();
    		temp.setAskPrice(sellLevelsItem.getOrderPrice().getValue()/1000f);
    		temp.setAskVolume(sellLevelsItem.getOrderVol().getValue());
    		sellLevelsItemSubList.add(temp);
		}
    	
    	marketData.setSellLevelList(sellLevelsItemSubList);
    	System.out.println(marketData.toString());
    	return marketData;
    }
    
    
}
