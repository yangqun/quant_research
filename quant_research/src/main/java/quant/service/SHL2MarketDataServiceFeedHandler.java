package quant.service;

import java.text.ParseException;
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
import com.datayes.whale.common.client.model.response.MDLSZL2Msg.MarketData.BidPriceLevelItem;
import com.datayes.whale.common.client.model.response.MDLSZL2Msg.MarketData.OfferPriceLevelItem;

public class SHL2MarketDataServiceFeedHandler extends ServiceFeedHandler{
	
	//result即为接收到的数据，其中分为2部分，header和body，
    //需要根据header中的serviceID和messageID，将其强转为相应的Msg，参考onSHL1Message()
    @Override
    public void onAPIMessage(Result result) {
        System.out.println("---------API---------");

    }
    @Override
    public void onSYSMessage(Result result) {
    	System.out.println("SYS");
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
    }
    @Override
    public void onSZL1Message(Result result) {

    }
    @Override
    public void onSZL2Message(Result result) {
//    	System.out.println(result);
    	getSZL2MarketData(result);
    }
    @Override
    public void onHKEXMessage(Result result) {
       //System.out.println("---------HK---------");
    }
    
    public Level2MarketData getSZL2MarketData(Result result) {
    	System.out.println("-------------------------------");
    	Level2MarketData marketData = new Level2MarketData();
    	MarketData szl2MarketData = (MarketData) result.getBody();
    	//szl2MarketData.getUpdateTime();
    	//该时间戳精确到秒，不是毫秒,如142718000
    	//marketData.setUpdateTime(DateUtil.timestamp2Str(szl2MarketData.getUpdateTime()));
    	marketData.setSecurityId(szl2MarketData.getSecurityID());
    	marketData.setPreClosePrice(szl2MarketData.getPreClosePx().getValue()/1000D);
    	marketData.setHighPrice(szl2MarketData.getHighPx().getValue()/1000D);
    	marketData.setOpenPrice(szl2MarketData.getOpenPx().getValue()/1000d);
    	marketData.setLowPrice(szl2MarketData.getLastPx().getValue()/1000d);
    	//marketData.setClosePrice(szl2MarketData.getclo.getValue()/1000d);
    	marketData.setLastPrice(szl2MarketData.getLastPx().getValue()/1000d);
    	marketData.setTradeVolume(szl2MarketData.getTotalVolumeTrade());
    	//marketData.setTurnOver(szl2MarketData.);
    	List<BidLevelsItemSub> bidLevelsItemSubList = new ArrayList<BidLevelsItemSub>();
    	for (BidPriceLevelItem bidLevelsItem : szl2MarketData.getBidPriceLevelList()) {
    		BidLevelsItemSub temp = new BidLevelsItemSub();
    		temp.setBidPrice(bidLevelsItem.getBidPx().getValue()/1000f);
    		temp.setBidVolume(bidLevelsItem.getBidSize());
    		bidLevelsItemSubList.add(temp);
		}
    	marketData.setBidLevelsList(bidLevelsItemSubList);
    	List<SellLevelsItemSub> sellLevelsItemSubList = new ArrayList<SellLevelsItemSub>();
    	for (OfferPriceLevelItem sellLevelsItem : szl2MarketData.getOfferPriceLevelList()) {
    		SellLevelsItemSub temp = new SellLevelsItemSub();
    		temp.setAskPrice(sellLevelsItem.getOfferPx().getValue()/1000f);
    		temp.setAskVolume(sellLevelsItem.getOfferSize());
    		sellLevelsItemSubList.add(temp);
		}
    	marketData.setSellLevelList(sellLevelsItemSubList);
    	System.out.println(marketData.toString());
    	return marketData;
    }
    
    public Level2MarketData getMarketData(Result result) {
    	System.out.println("*************************");
    	Level2MarketData marketData = new Level2MarketData();
    	SHL2MarketData shl2MarketData = (SHL2MarketData) result.getBody();
    	shl2MarketData.getUpdateTime();
    	//该时间戳精确到秒，不是毫秒,如142718000
    	marketData.setUpdateTime(DateUtil.timestamp2Str(shl2MarketData.getUpdateTime()));
    	marketData.setSecurityId(shl2MarketData.getSecurityID());
    	marketData.setPreClosePrice(shl2MarketData.getPreCloPrice().getValue()/1000D);
    	marketData.setHighPrice(shl2MarketData.getHighPrice().getValue()/1000D);
    	marketData.setOpenPrice(shl2MarketData.getOpenPrice().getValue()/1000d);
    	marketData.setLowPrice(shl2MarketData.getLowPrice().getValue()/1000d);
    	marketData.setClosePrice(shl2MarketData.getClosePrice().getValue()/1000d);
    	marketData.setLastPrice(shl2MarketData.getLastPrice().getValue()/1000d);
    	marketData.setTradeVolume(shl2MarketData.getTradVolume().getValue());
    	marketData.setTurnOver(shl2MarketData.getTurnover().getValue());
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
