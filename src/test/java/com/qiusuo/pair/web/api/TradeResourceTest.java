/*
 * TradeResourceTest.java  2015年2月28日
 */
package com.qiusuo.pair.web.api;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.junit.Test;
import static org.junit.Assert.*;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.qiusuo.pair.data.entity.Trade;

/**
 * 
 * @author Li, Rong
 * @version 1.0
 */
public class TradeResourceTest {
	@Test
	public void testTrade() {
		List<Object> providers = new ArrayList<Object>();
		providers.add(new JacksonJaxbJsonProvider());

		String address = "http://127.0.0.1:9004/api/rest";

		TradeResource tradeResource = (TradeResource) JAXRSClientFactory
				.create(address, TradeResource.class, providers);

		Trade trade = new Trade();
		trade.setUserId(134256L);
		trade.setCurrencyFrom("EUR");
		trade.setCurrencyTo("GBP");
		trade.setAmountSell(new BigDecimal("1000"));
		trade.setAmountBuy(new BigDecimal("747.10"));
		trade.setRate(new BigDecimal("0.7471"));

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			trade.setTimePlaced(dateFormat.parse("2014-01-15 10:27:44"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		trade.setOriginatingCountry("FR");

		Result result = tradeResource.consumeTrade(trade);
		assertEquals("success", result.getMessage());
	}

	@Test(expected = Exception.class)
	public void testTradeTooSmallRate() {
		List<Object> providers = new ArrayList<Object>();
		providers.add(new JacksonJaxbJsonProvider());

		String address = "http://127.0.0.1:9004/api/rest";

		TradeResource tradeResource = (TradeResource) JAXRSClientFactory
				.create(address, TradeResource.class, providers);

		Trade trade = new Trade();
		trade.setUserId(134256L);
		trade.setCurrencyFrom("EUR");
		trade.setCurrencyTo("GBP");
		trade.setAmountSell(new BigDecimal("1000"));
		trade.setAmountBuy(new BigDecimal("747.10"));
		// rate must between 0 and 100
		trade.setRate(new BigDecimal("-0.7471"));

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			trade.setTimePlaced(dateFormat.parse("2014-01-15 10:27:44"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		trade.setOriginatingCountry("FR");
		tradeResource.consumeTrade(trade);
	}
}
