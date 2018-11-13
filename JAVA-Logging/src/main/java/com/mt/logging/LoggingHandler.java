package com.mt.logging;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LoggingHandler extends Handler {
	volatile FileHandler _handler;
	volatile long _endDate;
	volatile String _pattern;
	volatile int _limit;
	volatile int _count;
	volatile boolean _append;
	volatile boolean _init = false;
	volatile long _startDate = System.currentTimeMillis();
	
	final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	public LoggingHandler(){
		
	}
	public LoggingHandler(String pattern, int limit, int count, boolean append) throws IOException, SecurityException {
		_pattern = pattern;
		_limit = limit;
		_count = count;
		_append = append;
		rotateDate();
		_init = true;
	}

	@Override
	public void close() throws SecurityException {
		_handler.close();

	}

	@Override
	public void flush() {
		_handler.flush();
	}

	@Override
	public void publish(LogRecord record) {
		if (_endDate < record.getMillis())
			rotateDate();
		if (System.currentTimeMillis() - _startDate > 25 * 60 * 60 * 1000) {
			String msg = record.getMessage();
			record.setMessage("missed file rolling at: " + new Date(_endDate) + "\n" + msg);
		}
		_handler.publish(record);

	}

	@Override
	public void setFormatter(Formatter newFormatter) {
		super.setFormatter(newFormatter);
		if (_handler != null)
			_handler.setFormatter(newFormatter);
	}

	/**
	 * Rotate date.
	 */
	private void rotateDate() {
		_startDate = System.currentTimeMillis();
		if (_handler != null)
			_handler.close();
		String pattern = _pattern.replace("%d", format.format(new Date()));
		Calendar next = Calendar.getInstance(); // current date
		// begin of next date
		next.set(Calendar.HOUR_OF_DAY, 0);
		next.set(Calendar.MINUTE, 0);
		next.set(Calendar.SECOND, 0);
		next.set(Calendar.MILLISECOND, 0);
		next.add(Calendar.DATE, 1);
		_endDate = next.getTimeInMillis();

		try {
			_handler = new FileHandler(pattern, _limit, _count, _append);
			if (_init) {
				_handler.setEncoding(this.getEncoding());
				_handler.setErrorManager(this.getErrorManager());
				_handler.setFilter(this.getFilter());
				_handler.setFormatter(this.getFormatter());
				_handler.setLevel(this.getLevel());
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
