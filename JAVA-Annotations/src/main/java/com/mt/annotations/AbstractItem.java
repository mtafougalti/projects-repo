package com.mt.annotations;

public abstract class AbstractItem {
	public void process() {
		if (this.getClass().isAnnotationPresent(Item.class)) {
			Item item = this.getClass().getAnnotation(Item.class);
			System.out.println(item.name());
		}
		printInfo();
	}

	public abstract void printInfo();
}
