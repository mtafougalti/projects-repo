package com.mt.annotations;

public class Application {
	
	public static void main(String[] args) {
		AbstractItem item1 = new MusicCD();
		AbstractItem item2 = new Software();
		
		item1.process();
		item2.process();
	}

}
