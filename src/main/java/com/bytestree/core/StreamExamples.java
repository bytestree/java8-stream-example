package com.bytestree.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {
	public static void main(String[] args) {
		convertListToOther();
		filterList();
		findElement();
		findMaxMin();
		sumOfElements();
	}
	
	//Convert List of objects to another List of objects
	public static void convertListToOther() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Bytes", 18));
		persons.add(new Person("Tree", 20));
		persons.add(new Person("Streams", 22));
		
		List<String> names = persons.stream().map(p -> p.getName()).collect(Collectors.toList());
		System.out.println(names);
	}
	
	//Create new list by filtering elements
	public static void filterList() {
		//create list of integers from 1 to 10
		List<Integer> numbers = Stream.iterate(1, n -> n + 1).limit(10).collect(Collectors.toList());
		List<Integer> evenNumbers = numbers.stream().filter(n -> (n.intValue() % 2 == 0))
				.collect(Collectors.toList());
		System.out.println(evenNumbers);		
	}
	
	//find element from a List
	public static void findElement() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Bytes", 18));
		persons.add(new Person("Tree", 20));
		persons.add(new Person("Streams", 22));
		
		Optional<Person> result = persons.stream().filter(p -> p.getName().equals("Bytes")).findAny();
		if (result.isPresent()) {
			System.out.println(result.get());
		} else {
			System.out.println("Not Found");
		}
	}
	
	public static void findMaxMin() {
		List<Integer> integers = Arrays.asList(3, 5, 45, 52, 5, 14);
		
		Optional<Integer> max = integers.stream().max(Comparator.naturalOrder());
		Optional<Integer> min = integers.stream().min(Comparator.naturalOrder());
		
		System.out.println("Max: " + max.get());
		System.out.println("Min: " + min.get());
	}
	
	public static void sumOfElements() {
		int[] intArray = {23,45,76,12,67,89};
		Arrays.stream(intArray).reduce(Integer::sum)
				.ifPresent(s -> System.out.println("Sum: " + s));
	}
	
	
}
