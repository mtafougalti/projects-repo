package com.mt.log4j;

import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class Log4jTestFilter extends Filter {

	private String keyWord;

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	@Override
	public int decide(LoggingEvent event) {
		String msg = event.getRenderedMessage();

		if (msg == null || keyWord == null)
			return Filter.NEUTRAL;
		if (msg.indexOf(keyWord) == -1) {
			return Filter.DENY;
		} else { // we've got a match
			return Filter.ACCEPT;
		}
	}

}
