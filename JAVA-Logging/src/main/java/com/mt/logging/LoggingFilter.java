package com.mt.logging;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class LoggingFilter implements Filter {

	public boolean isLoggable(LogRecord record) {
		if (record == null || record.getMessage() == null || record.getMessage().isEmpty()) {
			return false;
		} else {
			return record.getMessage().contains("FR_GREETING");
		}
	}

}
