package quant.common.entity;

import java.util.Date;
import java.util.List;

//import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData.BidLevelsItem;
//import com.datayes.whale.common.client.model.response.MDLSHL2Msg.SHL2MarketData.SellLevelsItem;

public class Level2MarketData {
	private Date updateTime;
	private String securityId;
	private Double preClosePrice;
	private Double openPrice;
	private Double highPrice;
	private Double lowPrice;
	private Double lastPrice;
	private Double closePrice;
	private Double tradeVolume;
	private Double turnOver;
	//买一到买十
	private List<BidLevelsItemSub> bidLevelsList;
	//卖一到卖十
	private List<SellLevelsItemSub> sellLevelList;
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public Double getPreClosePrice() {
		return preClosePrice;
	}
	public void setPreClosePrice(Double preClosePrice) {
		this.preClosePrice = preClosePrice;
	}
	public Double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}
	public Double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}
	public Double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public Double getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}
	public Double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}
	public Double getTradeVolume() {
		return tradeVolume;
	}
	public void setTradeVolume(Double tradeVolume) {
		this.tradeVolume = tradeVolume;
	}
	public Double getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(Double turnOver) {
		this.turnOver = turnOver;
	}
	public List<BidLevelsItemSub> getBidLevelsList() {
		return bidLevelsList;
	}
	public void setBidLevelsList(List<BidLevelsItemSub> bidLevelsList) {
		this.bidLevelsList = bidLevelsList;
	}
	public List<SellLevelsItemSub> getSellLevelList() {
		return sellLevelList;
	}
	public void setSellLevelList(List<SellLevelsItemSub> sellLevelList) {
		this.sellLevelList = sellLevelList;
	}
	@Override
	public String toString() {
		return "Level2MarketData [updateTime=" + updateTime + ", securityId="
				+ securityId + ", preClosePrice=" + preClosePrice
				+ ", openPrice=" + openPrice + ", highPrice=" + highPrice
				+ ", lowPrice=" + lowPrice + ", lastPrice=" + lastPrice
				+ ", closePrice=" + closePrice + ", tradeVolume=" + tradeVolume
				+ ", turnOver=" + turnOver + ", bidLevelsList=" + bidLevelsList
				+ ", sellLevelList=" + sellLevelList + "]";
	}
	
	
}
