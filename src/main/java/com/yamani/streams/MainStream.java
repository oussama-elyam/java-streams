package com.yamani.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainStream {

	public static void main(String[] args) {
		List<Laptop> people = getPeople();

	    // 1:brute force approach 	    
	    /*
		List<Laptop> LINUXs = new ArrayList<>();
	    for (Laptop Laptop : people) {
	      if (Laptop.getOperatingSys().equals(OperatingSys.LINUX)) {
	        LINUXs.add(Laptop);
	      }
	    }
	    LINUXs.forEach(System.out::println);
	    */
	    //1:stream filter
		System.out.println("-------------------Stream Filter----------------------");
	    List<Laptop> LINUXs = people.stream()
	        .filter(Laptop -> Laptop.getOs().equals(OperatingSys.LINUX))
	        .collect(Collectors.toList());

	    LINUXs.forEach(System.out::println);
	    }
	
	 private static List<Laptop> getPeople() {
		    return List.of(
		        new Laptop("laptopA",5000, 8, OperatingSys.MAC),
		        new Laptop("laptopB",6000, 12, OperatingSys.WINDOWS),
		        new Laptop("laptopC",3500, 8, OperatingSys.LINUX),
		        new Laptop("laptopD",8000,16, OperatingSys.MAC),
		        new Laptop("laptopE",10000,16, OperatingSys.MAC),
		        new Laptop("laptopF",2000,8, OperatingSys.LINUX),
		        new Laptop("laptopG",1500, 4, OperatingSys.WINDOWS)
		    );
		  }
}
