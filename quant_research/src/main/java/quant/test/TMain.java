package quant.test;

import quant.dao.client.Leve2InfoDao;


public class TMain {
	public static void main(String[] args) {
		Leve2InfoDao leve2InfoDao = new Leve2InfoDao();
		//leve2InfoDao.getLevel2Info("159901");
		leve2InfoDao.getSZLevel2Info("159901");
		leve2InfoDao.getSHL2Index("999999");
		
	}

}
