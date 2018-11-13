package com.mt.annotations;

@Item(name = "SoftwareItem")
public class Software extends AbstractItem {

	@Override
	public void printInfo() {
		System.out.println("Hello from Software");
	}

}
