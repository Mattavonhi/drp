package me.qinyang.drp.util;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlConfigReader {
	private static XmlConfigReader instance = null;
	private JdbcConfig config = null;
	private XmlConfigReader(){
		
		try {
			SAXReader reader = new SAXReader();
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("sys-conf.xml");
			Document document;
			document = reader.read(in);
			Element driverName = (Element)document.selectObject("/config/db-info/driver-name");
			Element url = (Element) document.selectObject("/config/db-info/url");
			Element userName = (Element) document.selectObject("/config/db-info/user-name");
			Element password = (Element) document.selectObject("/config/db-info/password");
			config = new  JdbcConfig(driverName.getStringValue(),
					url.getStringValue(),
					userName.getStringValue(), 
					password.getStringValue());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static synchronized XmlConfigReader getInstance(){
		if (instance == null) {
			instance = new  XmlConfigReader();
		}
		return instance;
	}
	public JdbcConfig getConfig() {
		return config;
	}
	
	
}
