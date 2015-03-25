package quant.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import quant.common.entity.BidLevelsItemSub;
import quant.common.entity.Level2MarketData;
import quant.common.entity.SHL2IndexExt;
import quant.common.entity.SellLevelsItemSub;
import quant.common.util.DateUtil;

import com.datayes.whale.common.client.ServiceFeedHandler;
import com.datayes.whale.common.client.model.Result;
import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2Index;
import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData;
import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData.BidLevelsItem;
import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData.SellLevelsItem;
import com.datayes.whale.common.client.model.response.MDLSZL2Msg.MarketData;
import com.datayes.whale.common.client.model.response.MDLSZL2Msg.MarketData.BidPriceLevelItem;
import com.datayes.whale.common.client.model.response.MDLSZL2Msg.MarketData.OfferPriceLevelItem;

public class SHL2IndexServiceFeedHandler extends ServiceFeedHandler{
	
	//result即为接收到的数据，其中分为2部分，header和body，
    //需要根据header中的serviceID和messageID，将其强转为相应的Msg，参考onSHL1Message()
    @Override
    public void onAPIMessage(Result result) {
        //System.out.println("---------API---------");

    }
    @Override
    public void onSYSMessage(Result result) {
    	System.out.println("SYS");
    }
    @Override
    public void onCFFEXMessage(Result result) {
    	System.out.println("onCFFEXMessage");
    }
    @Override
    public void onCZCEMessage(Result result) {
    	System.out.println("onCZCEMessage");
    }
    @Override
    public void onDCEMessage(Result result) {
    	System.out.println("onDCEMessage");
    }
    @Override
    public void onSHFEMessage(Result result) {
    	System.out.println("onSHFEMessage");
    }
    
    @Override
    public void onSHL1Message(Result result) {
    	System.out.println("onSHL1Message");
    }

    @Override
    public void onSHL2Message(Result result) {
    	//System.out.println("onSHL2Message");
    	getSHL2Index(result);
    }
    @Override
    public void onSZL1Message(Result result) {

    }
    @Override
    public void onSZL2Message(Result result) {
    	System.out.println("onSZL2Message");
//    	System.out.println(result);
    	
    }
    @Override
    public void onHKEXMessage(Result result) {
       //System.out.println("---------HK---------");
    }
    
    public SHL2IndexExt getSHL2Index(Result result) {
    	System.out.println("-------------------------------");
    	SHL2IndexExt shl2IndexExt = new SHL2IndexExt();
    	SHL2Index shl2Index = (SHL2Index) result.getBody();
    	//szl2MarketData.getUpdateTime();
    	//该时间戳精确到秒，不是毫秒,如142718000
    	//marketData.setUpdateTime(DateUtil.timestamp2Str(szl2MarketData.getUpdateTime()));
    	shl2IndexExt.setCloseIndex(shl2Index.getCloseIndex().getValue()/100000D);
    	shl2IndexExt.setDataStatus(shl2Index.getDataStatus());
    	shl2IndexExt.setHighIndex(shl2Index.getHighIndex().getValue()/100000D);
    	shl2IndexExt.setLastIndex(shl2Index.getLastIndex().getValue()/100000D);
    	shl2IndexExt.setLowIndex(shl2Index.getLowIndex().getValue()/100000D);
    	shl2IndexExt.setOpenIndex(shl2Index.getOpenIndex().getValue()/100000D);
    	shl2IndexExt.setPreCloseIndex(shl2Index.getPreCloseIndex().getValue()/100000D);
    	shl2IndexExt.setSecurityId(shl2Index.getSecurityID());
    	//shl2IndexExt.setTradeTime(szl2Index.getTradTime());
    	shl2IndexExt.setTradeVolume(shl2Index.getTradVolume().getValue()/1D);
    	shl2IndexExt.setTurnOver(shl2Index.getTurnover().getValue()/1D);
    	
    	System.out.println(shl2IndexExt.toString());
    	return shl2IndexExt;
    }
    
    
}
