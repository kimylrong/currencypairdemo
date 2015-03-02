package com.qiusuo.pair;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jetty server boot.
 * 
 * @author Li,Rong
 * @version 1.0
 */
public class JettyStarter {
	private static final Logger LOG = LoggerFactory
			.getLogger(JettyStarter.class);

	public static void main(String[] args) throws Exception {
		try {
			XmlConfiguration jettyConf = new XmlConfiguration(
					JettyStarter.class.getResourceAsStream("/jetty.xml"));
			Server jettyServer = new Server();
			jettyConf.configure(jettyServer);
			jettyServer.start();
			jettyServer.join();
		} catch (Exception e) {
			LOG.error("Jetty start failed", e);
		}
	}
}
