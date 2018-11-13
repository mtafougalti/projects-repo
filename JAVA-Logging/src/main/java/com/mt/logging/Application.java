package com.mt.logging;

import java.io.IOException;
import java.util.logging.Logger;

public class Application {
	private static Logger log = Logger.getLogger(Application.class.getName());
	static {
		try {
			LoggingConfig.config();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		log.info("GREETING : Hello world !");
		log.info("FR_GREETING : Bonjour tout le monde");
		log.info("GREETING : How are you?");
		log.info("FR_GREETING : Comment allez vous?");
		log.info("GREETING : Fine");
	}

}
