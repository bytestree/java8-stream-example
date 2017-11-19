package com.bytestree.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {
	public static void main(String[] args) {
		streamOfCollection();
		streamOfSet();
		steamOfValues();
		streamOfArray();
		streamBuilder();
		streamIterate();
		lazyOperations();
	}

	private static void streamOfCollection() {
		Collection<String> stringCollection = Arrays.asList("One", "Two", "Three");
		Stream<String> streamOfCollection = stringCollection.stream();
		System.out.println("Stream Of Collection:");
		streamOfCollection.forEach(System.out::println);
	}
	
	private static void streamOfSet() {
		Set<String> stringSet = new HashSet<>(Arrays.asList("One", "Two", "Three"));
		Stream<String> streamOfSet = stringSet.stream();
		System.out.println("\nStream Of Set:");
		streamOfSet.forEach(System.out::println);
	}
	
	private static void steamOfValues() {
		Stream<Integer> streamOfIntegers = Stream.of(1, 2, 3);
		System.out.println("\nStream Of Values:");
		streamOfIntegers.forEach(System.out::println);
	}
	
	private static void streamOfArray() {
		System.out.println("\nStream From Arrays:");
		Person[] personArray = {new Person("bytes", 18), new Person("tree", 20)};
		Stream<Person> personStream = Arrays.stream(personArray);
		personStream.forEach(person -> System.out.println("Person Name: " + person.getName()));
		
		System.out.println("\nPremitive Stream From Arrays:");
		int[] intArray = {1, 2, 3};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(System.out::println);
	}
	
	private static void streamBuilder() {
		Stream.Builder<String> builder = Stream.builder();
		Stream<String> streamFromBuilder = builder.add("One").add("Two").add("Three").build();
		System.out.println("\nStream From Builder:");
		streamFromBuilder.forEach(System.out::println);
	}
	
	private static void streamIterate() {
		Stream<Integer> streamFromIterate = Stream.iterate(0, n -> n + 2).limit(10);
		System.out.println("\nStream From Iterate:");
		streamFromIterate.forEach(System.out::println);
	}
	
	private static void lazyOperations() {
		System.out.println("\nStream lazyOperations:");
		
		// nothing printed for this
		Stream.of("one", "two", "Three").map(s -> s.toUpperCase())
				.peek(System.out::println);
		
		System.out.println("\nAdding count:");
		Stream.of("one", "two", "Three").map(s -> s.toUpperCase())
		.peek(System.out::println).count();
	}
}
