package com.mt.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingConfig {

	public static void config() throws SecurityException, IOException {
		LogManager logManager = LogManager.getLogManager();
		Logger LOGGER = Logger.getLogger("");
		try {
			logManager.readConfiguration(new FileInputStream("src\\main\\resources\\logging-test.properties"));
		} catch (IOException exception) {
			LOGGER.log(Level.SEVERE, "Error in loading configuration", exception);
		}
		LoggingHandler handler = new LoggingHandler("C:\\dev\\tttt%g.log", 10000000, 5, true);
		handler.setLevel(Level.INFO);
		handler.setFormatter(new SimpleFormatter());
        //setting custom filter for FileHandler
		handler.setFilter(new LoggingFilter());
		LOGGER.addHandler(handler);
	}
}
