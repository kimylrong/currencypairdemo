/*
 * TradeProcessorImpl.java  2015年2月28日
 */
package com.qiusuo.pair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qiusuo.pair.data.entity.Trade;
import com.qiusuo.pair.data.entity.TradeExample;
import com.qiusuo.pair.data.mapper.TradeMapper;

/**
 * trade processor implements
 * 
 * @author Li, Rong
 * @version 1.0
 */
@Component
public class TradeProcessorImpl implements TradeProcessor {
	@Autowired
	private TradeMapper tradeMapper;

	@Override
	public void processTrade(Trade trade) {
		tradeMapper.insert(trade);
	}

	@Override
	public List<Trade> getAllTrade() {
		return tradeMapper.selectByExample(new TradeExample());
	}

}
