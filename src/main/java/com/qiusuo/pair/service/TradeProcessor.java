/*
 * TradeProcessor.java  2015年2月28日
 */
package com.qiusuo.pair.service;

import java.util.List;

import com.qiusuo.pair.data.entity.Trade;

/**
 * trade processor
 * 
 * @author Li, Rong
 * @version 1.0
 */
public interface TradeProcessor {
	/**
	 * process trade
	 */
	void processTrade(Trade trade);
	
	/**
	 * Get all trade.
	 */
	List<Trade> getAllTrade();
}
