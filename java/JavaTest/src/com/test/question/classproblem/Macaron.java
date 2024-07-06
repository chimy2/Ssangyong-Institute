package com.test.question.classproblem;

public class Macaron {
	private int size;
	private String color;
	private int thickness;
	
	private int check;
	public final static int PASS = 1;
	public final static int FAIL = -1;
	private final int NOTCHECK = 0;
	private static final String[] COLORS = { "red", "blue", "yellow", "white", "pink", "purple", "green", "black" };

	
	public Macaron(int size, String color, int thickness) {
		this.size = size;
		this.color = color;
		this.thickness = thickness;
	}

	public int getCheck() {
		if(this.check == NOTCHECK) {
			setCheck();
		}
		return check;
	}

	private void setCheck() {
		if(this.size < 8 || this.size > 14 
				|| this.color.equals("black")
				|| this.thickness < 3 || this.thickness > 18) {
			this.check = FAIL;
			return;
		}
		this.check = PASS;
	}
	
	@Override
	public String toString() {
		if(this.check == NOTCHECK) {
			setCheck();
		}
		return String.format("%dcm(%s, %dmm) : %s",
				this.size, this.color, this.thickness, this.check == PASS ? "합격" : "불합격");
	}
	
	public static int getColorsCount() {
		return COLORS.length;
	}
	
	public static String getColor(int index) {
		return COLORS[index];
	}
}
