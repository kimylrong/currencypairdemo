/*
 * TradeResource.java  2015年2月28日
 */
package com.qiusuo.pair.web.api;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qiusuo.pair.data.entity.Trade;

/**
 * Message Consumption. End point of protocol.
 * 
 * @author Li, Rong
 * @version 1.0
 */
@Path("/trade")
@Consumes("application/json")
@Produces("application/json")
public interface TradeResource {
	/**
	 * consume a trade
	 * 
	 * @param trade
	 * @return "success" message after done
	 */
	@POST
	Result consumeTrade(@Valid Trade trade);

	/**
	 * Get all trade information.
	 * 
	 * @return
	 */
	@GET
	List<Trade> getAllTrade();
}
