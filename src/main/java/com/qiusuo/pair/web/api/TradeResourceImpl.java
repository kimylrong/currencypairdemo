/*
 * TradeResourceImpl.java  2015年2月28日
 */
package com.qiusuo.pair.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qiusuo.pair.data.entity.Trade;
import com.qiusuo.pair.service.TradeProcessor;

/**
 * Message Consumption Implement.
 * 
 * @author Li, Rong
 * @version 1.0
 */
public class TradeResourceImpl implements TradeResource {
	@Autowired
	private TradeProcessor tradeProcessor;

	@Override
	public Result consumeTrade(Trade trade) {
		tradeProcessor.processTrade(trade);

		Result result = new Result();
		result.setCode("200");
		result.setMessage("success");
		return result;
	}

	@Override
	public List<Trade> getAllTrade() {
		return tradeProcessor.getAllTrade();
	}

}
