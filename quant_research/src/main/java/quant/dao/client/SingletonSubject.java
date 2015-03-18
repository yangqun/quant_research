package quant.dao.client;

import com.datayes.whale.common.client.Client;
import com.datayes.whale.common.client.SocketClient;
import com.datayes.whale.common.client.model.request.Logon;

public class SingletonSubject {
	String addresses[] = {"feeder01.cloud-data.datayes.com:9010"};
	Client client= null;
	Logon logon = null;
	
	private SingletonSubject(){
		//构造一个SocketClient实例，通过该实例来订阅
        this.client = new SocketClient(this.addresses);
        //构造订阅参数对象
        this.logon = new Logon("", "");
	}
	private static SingletonSubject instance = null;
	
	public static SingletonSubject getIntance(){
		if(instance == null)
			instance = new SingletonSubject();
		return instance;
	}
	
}
