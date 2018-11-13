package com.mt.annotations;

@Item(name = "MusicCDItem")
public class MusicCD extends AbstractItem {

	@Override
	public void printInfo() {
		System.out.println("Hello from MusicCD");

	}

}
