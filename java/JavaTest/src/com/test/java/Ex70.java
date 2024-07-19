package com.test.java;

import java.io.File;

import com.github.lalyos.jfiglet.FigletFont;

public class Ex70 {
	public static void main(String[] args) {
		/*
		 * figlet
		 * - https://github.com/dtmo/jfiglet
		 */

	    try {
			// using default font standard.flf, obtained from maven artifact
			String asciiArt1 = FigletFont.convertOneLine("Java Program");
			System.out.println(asciiArt1);
			

		    // using font font2.flf, located somewhere in classpath under path /flf/font2.flf
//		    String asciiArt2 = FigletFont.convertOneLine(FigletFont.class.getResourceAsStream("flf/isometric3.flf"), "hello");
//		    System.out.println(asciiArt2);

		    // using font font3.flf, located in file system under path /opt/font3.flf
		    String asciiArt3 = FigletFont.convertOneLine(new File("fif/isometric3.flf"), "hello");     
		    System.out.println(asciiArt3);
		    for(String s : asciiArt3.split("\n")) {
		    	System.out.println(s);
		    	Thread.sleep(100);
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
