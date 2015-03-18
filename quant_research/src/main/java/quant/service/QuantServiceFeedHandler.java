package quant.service;

import java.util.List;

import quant.common.util.DateUtil;

import com.datayes.whale.common.client.ServiceFeedHandler;
import com.datayes.whale.common.client.model.Result;
import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData;
import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData.BidLevelsItem;

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
        System.out.println("+++++++++++++++++++++++++++++++++++++"+i++);
        SHL2MarketData shl2MarketData = (SHL2MarketData) result.getBody();
        System.out.println("-------------------------------------");
        System.out.println("openPrice is: " + shl2MarketData.getOpenPrice());
        List<BidLevelsItem> bidLevelsItemList = shl2MarketData.getBidLevelsList();
        for (BidLevelsItem bidLevelsItem : bidLevelsItemList) {
			System.out.println("BidLevelsItem" + bidLevelsItem.toString());
		}
        System.out.println(shl2MarketData.getBidLevelsList());
//        System.out.println(startTime);
    	Result temp = result;
    	Long endTime = DateUtil.currentTimeMillis();
    	averTime = (endTime - startTime)/i;
    	System.out.println("level 2 访问平均时间： "+ averTime);
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
}
