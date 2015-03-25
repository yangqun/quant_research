package quant.dao.client;

import quant.service.SHL2IndexServiceFeedHandler;
import quant.service.SHL2MarketDataServiceFeedHandler;
import quant.service.SZL2MarketDataServiceFeedHandler;

import com.datayes.whale.common.client.Client;
import com.datayes.whale.common.client.SocketClient;
import com.datayes.whale.common.client.constant.Config;
import com.datayes.whale.common.client.model.request.Logon;

public class Leve2InfoDao {
	private static String addresses[] = {"feeder01.cloud-data.datayes.com:9010"};
	private static Client client = new SocketClient(addresses);
	private static Logon logon = new Logon("", "");
	public void getSHLevel2StockInfo(String SecurityId){
        //添加订阅项，如订阅何种service，哪个版本，何种message。此类参数可以在Config类中获得所有订阅参数定义Config.MessageID.SHL2.SHL2_MARKET_DATA
        //addSubscription(Config.Service.SHL1.ID, Config.Service.SHL1.VERSION, Config.MessageID.SHL1.SHL1_STOCK,"SecurityID","600000") 
        //logon.addSubscription(Config.Service.SHL1.ID, Config.Service.SHL1.VERSION, Config.MessageID.SHL1.SHL1_STOCK,"SecurityID","600000");
        logon.addSubscription(Config.Service.SHL2.ID, Config.Service.SHL2.VERSION, Config.MessageID.SHL2.SHL2_MARKET_DATA,"SecurityID",SecurityId);
        //发送订阅参数对象到server，并且构造一个继承BaseFeedHandler或者ServiceFeedHandler的类的实例，用于接收订阅的数据
        client.subscribe(new SHL2MarketDataServiceFeedHandler(), logon);
	}
	
	public void getSZLevel2Info(String SecurityId){
        logon.addSubscription(Config.Service.SZL2.ID, Config.Service.SZL2.VERSION, Config.MessageID.SZL2.SZL2_MARKETDATA,"SecurityID",SecurityId);
        //发送订阅参数对象到server，并且构造一个继承BaseFeedHandler或者ServiceFeedHandler的类的实例，用于接收订阅的数据
        client.subscribe(new SZL2MarketDataServiceFeedHandler(), logon);
		
	}
	
	public void getSHL2Index(String SecurityId){
		
        logon.addSubscription(Config.Service.SHL2.ID, Config.Service.SHL2.VERSION, Config.MessageID.SHL2.SHL2_INDEX,"SecurityID",SecurityId);
        client.subscribe(new SHL2IndexServiceFeedHandler(), logon);
	}
	
	public void getSZL2ETFIndex(String SecurityId){
		logon.addSubscription(Config.Service.SZL2.ID, Config.Service.SZL2.VERSION, Config.MessageID.SZL2.SZL2_MARKETDATA,"SecurityID",SecurityId);
        //发送订阅参数对象到server，并且构造一个继承BaseFeedHandler或者ServiceFeedHandler的类的实例，用于接收订阅的数据
        client.subscribe(new SZL2MarketDataServiceFeedHandler(), logon);
	}
	
	
	
}
