package ch17.sec04.exam04;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) throws Exception {
		Path path = Paths.get(StreamExample.class.getResource("data.txt").toURI());
		Stream<String> stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(line -> System.out.println(line));
		stream.close();
		/*
		{"pno":1, "name":"상품1", "company":"멋진 회사", "price":1558}
		{"pno":2, "name":"상품2", "company":"멋진 회사", "price":4671}
		{"pno":3, "name":"상품3", "company":"멋진 회사", "price":470}
		{"pno":4, "name":"상품4", "company":"멋진 회사", "price":9584}
		{"pno":5, "name":"상품5", "company":"멋진 회사", "price":6868}
		*/
	}
}
