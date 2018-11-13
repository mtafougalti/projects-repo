package com.mt.log4j;

import org.apache.log4j.Logger;

public class Application {

	private static final Logger log = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		log.info("GREETING : Hello world !");
		log.info("FR_GREETING : Bonjour tout le monde");
		log.info("GREETING : How are you?");
		log.info("FR_GREETING : Comment allez vous?");
		log.info("GREETING : Fine");
		
	}

}
