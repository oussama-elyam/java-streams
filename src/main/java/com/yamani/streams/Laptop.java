package com.yamani.streams;

public class Laptop {
	private final String name;
	  private final int price;
	  private final int ram;
	  private final OperatingSys os;

	  public Laptop(String name,int price, int ram, OperatingSys gender) {
	    this.name = name;
	    this.price = price;
	    this.ram = ram;
	    this.os = gender;
	  }

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getRam() {
		return ram;
	}

	public OperatingSys getOs() {
		return os;
	}

	@Override
	public String toString() {
		return "Laptop [name=" + name + ", price=" + price + ", ram=" + ram + ", os=" + os + "]";
	}

	

}
