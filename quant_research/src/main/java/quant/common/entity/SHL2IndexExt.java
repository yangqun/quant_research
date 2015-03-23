package quant.common.entity;

import java.util.Date;

//字段名			说明					字段类型	
//UpdateTime	行情时间				时间	
//DataStatus	1=重复数据2=未获授权	32位正整数
//SecurityID	证券代码				ASIIC字符串	
//PreCloseIndex	前收盘指数				双精度浮点数	
//OpenIndex		今开盘指数				双精度浮点数	
//Turnover		成交金额				双精度浮点数	
//HighIndex		最高指数				双精度浮点数	
//LowIndex		最低指数				双精度浮点数	
//LastIndex		最新指数				双精度浮点数	
//TradTime		成交时间				时间	
//TradVolume	交易数量(手)			双精度浮点数	
//CloseIndex	今日收盘指数(大于0为有效值)	双精度浮点数

public class SHL2IndexExt {
	private Date updateTime;
	private Integer dataStatus;
	private String securityId;
	private Double preCloseIndex;
	private Double openIndex;
	private Double turnOver;
	private Double highIndex;
	private Double lowIndex;
	private Double lastIndex;
	private Date tradeTime;
	private Double tradeVolume;
	private Double closeIndex;
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getDataStatus() {
		return dataStatus;
	}
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	public String getSecurityId() {
		return securityId;
	}
	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}
	public Double getPreCloseIndex() {
		return preCloseIndex;
	}
	public void setPreCloseIndex(Double preCloseIndex) {
		this.preCloseIndex = preCloseIndex;
	}
	public Double getOpenIndex() {
		return openIndex;
	}
	public void setOpenIndex(Double openIndex) {
		this.openIndex = openIndex;
	}
	public Double getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(Double turnOver) {
		this.turnOver = turnOver;
	}
	public Double getHighIndex() {
		return highIndex;
	}
	public void setHighIndex(Double highIndex) {
		this.highIndex = highIndex;
	}
	public Double getLowIndex() {
		return lowIndex;
	}
	public void setLowIndex(Double lowIndex) {
		this.lowIndex = lowIndex;
	}
	public Double getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(Double lastIndex) {
		this.lastIndex = lastIndex;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public Double getTradeVolume() {
		return tradeVolume;
	}
	public void setTradeVolume(Double tradeVolume) {
		this.tradeVolume = tradeVolume;
	}
	
	public Double getCloseIndex() {
		return closeIndex;
	}
	public void setCloseIndex(Double closeIndex) {
		this.closeIndex = closeIndex;
	}
	@Override
	public String toString() {
		return "SHL2IndexExt [updateTime=" + updateTime + ", dataStatus="
				+ dataStatus + ", securityId=" + securityId
				+ ", preCloseIndex=" + preCloseIndex + ", openIndex="
				+ openIndex + ", turnOver=" + turnOver + ", highIndex="
				+ highIndex + ", lowIndex=" + lowIndex + ", lastIndex="
				+ lastIndex + ", tradeTime=" + tradeTime + ", tradeVolume="
				+ tradeVolume + ", closeIndex=" + closeIndex + "]";
	}
	
	
	
}
