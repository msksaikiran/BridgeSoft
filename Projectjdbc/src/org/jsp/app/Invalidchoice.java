package org.jsp.app;

public class Invalidchoice extends RuntimeException{
	@Override
	public String toString() {
		System.err.println("invalid choice...");
		return " invalid choice";
	}
}
