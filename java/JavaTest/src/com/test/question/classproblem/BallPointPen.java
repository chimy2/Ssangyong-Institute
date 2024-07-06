package com.test.question.classproblem;

public class BallPointPen {
	private double thickness;
	private String color;

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public double getThickness() {
		return thickness;
	}

	public String getColor() {
		return color;
	}

	String info() {
		if(thickness == 0.0 || color == null) {
			return "잘못된 볼펜입니다.";
		}
		return String.format("%s 색상 %,.1fmm 볼펜입니다.", this.color, this.thickness);
	}
	
}
