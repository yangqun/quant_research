package quant.dao.client;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import quant.common.entity.SecIdInfo;
import quant.common.util.DateUtil;
import quant.common.util.DateUtil.DatePattern;


@Repository
public class DataApiDao {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DataApiDao.class);

	private static final String GET_SECID_URL = "http://dataapi01.cloud-data.datayes.com/api/master/getSecID.json?field=&ticker=%s&partyID=&assetClass=%s";

	public SecIdInfo getSecIDInfo(String securityId) {
		
		String url = String.format(GET_SECID_URL, securityId,"E");
		if(securityId.startsWith("1")){
			url = String.format(GET_SECID_URL, securityId,"F");
		}else if(securityId.startsWith("0")){
			
		}
		return null;
	}

	

	String date2str(Date d) {
		String str = DateUtil.dateToStr(d, DatePattern.day);
		str = str.replace("-", "");
		return str;
	}

}
