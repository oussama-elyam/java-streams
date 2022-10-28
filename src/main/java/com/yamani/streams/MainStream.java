package com.yamani.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainStream {

	public static void main(String[] args) {
		List<Laptop> laptop = getLaptop();

	    // 1:brute force approach 	    
	    
		List<Laptop> LINUXs = new ArrayList<>();
	    for (Laptop Laptop : laptop) {
	      if (Laptop.getOs().equals(OperatingSys.LINUX)) {
	        LINUXs.add(Laptop);
	      }
	    }
	    LINUXs.forEach(System.out::println);
	    
	    //1:stream filter
		System.out.println("-------------------Stream Filter----------------------");
	    List<Laptop> linux = laptop.stream()
	        .filter(Laptop -> Laptop.getOs().equals(OperatingSys.LINUX))
	        .collect(Collectors.toList());

	    linux.forEach(System.out::println);
	    
	    //2:stream Sort
	    System.out.println("-------------------Stream sorted----------------------");
	    //sorting by price if price is equals then sort by ram
	    List<Laptop> sorted = laptop.stream()
	        .sorted(Comparator.comparing(Laptop::getPrice).thenComparing(Laptop::getRam).reversed())
	        .collect(Collectors.toList());

	    sorted.forEach(System.out::println);
	    
	    // All match
    	System.out.println("-------------------Stream all match----------------------");
	    boolean allMatch = laptop.stream()
	        .allMatch(Laptop -> Laptop.getPrice() > 5000);
	
	    System.out.println(allMatch);
	    
	    // Any match
    	System.out.println("-------------------Stream any match----------------------");
	    boolean anyMatch = laptop.stream()
	        .anyMatch(Laptop -> Laptop.getPrice() > 5000);
	
	    System.out.println(anyMatch);
	    
	    // None match
    	System.out.println("-------------------Stream none match----------------------");
	    boolean noneMatch = laptop.stream()
	        .noneMatch(Laptop -> Laptop.getName().equals("laptopA"));
	    
	    System.out.println(noneMatch);
	    
	    // Max
    	System.out.println("-------------------Stream MAX----------------------");
	    laptop.stream()
	        .max(Comparator.comparing(Laptop::getPrice))
	        .ifPresent(System.out::println);

	    // Min
    	System.out.println("-------------------Stream MIN----------------------");
	    laptop.stream()
	        .min(Comparator.comparing(Laptop::getPrice))
	        .ifPresent(System.out::println);
	    
	    // Group
    	System.out.println("-------------------Stream groupby using map --------------------");
	    Map<OperatingSys, List<Laptop>> groupByGender = laptop.stream()
	        .collect(Collectors.groupingBy(Laptop::getOs));

	    groupByGender.forEach((os, lap) -> {
	      System.out.println(os);
	      lap.forEach(System.out::println);
	      System.out.println();
	    });

	    
	    }
		
	
	 private static List<Laptop> getLaptop() {
		    return List.of(
		        new Laptop("laptopA",5000, 8, OperatingSys.MAC),
		        new Laptop("laptopB",10000, 12, OperatingSys.WINDOWS),
		        new Laptop("laptopC",3500, 8, OperatingSys.LINUX),
		        new Laptop("laptopD",8000,16, OperatingSys.MAC),
		        new Laptop("laptopE",10000,16, OperatingSys.MAC),
		        new Laptop("laptopF",2000,8, OperatingSys.LINUX),
		        new Laptop("laptopG",1500, 4, OperatingSys.WINDOWS)
		    );
		  }
}
