package quant.test;

import quant.dao.client.Leve2InfoDao;


public class TMain {
	public static void main(String[] args) {
		Leve2InfoDao leve2InfoDao = new Leve2InfoDao();
		leve2InfoDao.getLevel2Info("600000");
		
		
	}

}
