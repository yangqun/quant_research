package quant.dao.client;

import quant.service.QuantServiceFeedHandler;

import com.datayes.whale.common.client.Client;
import com.datayes.whale.common.client.SocketClient;
import com.datayes.whale.common.client.constant.Config;
import com.datayes.whale.common.client.model.request.Logon;

public class Leve2InfoDao {
	private static String addresses[] = {"feeder01.cloud-data.datayes.com:9010"};
	
	public void getLevel2Info(String SecurityId){
		Client client = new SocketClient(addresses);
        //构造订阅参数对象
        Logon logon = new Logon("", "");
        //添加订阅项，如订阅何种service，哪个版本，何种message。此类参数可以在Config类中获得所有订阅参数定义Config.MessageID.SHL2.SHL2_MARKET_DATA
        //addSubscription(Config.Service.SHL1.ID, Config.Service.SHL1.VERSION, Config.MessageID.SHL1.SHL1_STOCK,"SecurityID","600000") 
        //logon.addSubscription(Config.Service.SHL1.ID, Config.Service.SHL1.VERSION, Config.MessageID.SHL1.SHL1_STOCK,"SecurityID","600000");
        
        logon.addSubscription(Config.Service.SHL2.ID, Config.Service.SHL2.VERSION, Config.MessageID.SHL2.SHL2_MARKET_DATA,"SecurityID",SecurityId);
        //发送订阅参数对象到server，并且构造一个继承BaseFeedHandler或者ServiceFeedHandler的类的实例，用于接收订阅的数据
        client.subscribe(new QuantServiceFeedHandler(), logon);
		
	}
}
