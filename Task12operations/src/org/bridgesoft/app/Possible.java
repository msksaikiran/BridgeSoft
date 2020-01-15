package org.bridgesoft.app;

import java.util.HashSet;
import java.util.Set;

public class Possible {
		public static void main(String[] args) {
			String s = "123";
			System.out.println("\nGiven numbers :" + s + "\nPermutations: " + possibleOutCome(s));
		
		}
	 
		public static Set<String> possibleOutCome(String str) {
			Set<String> result = new HashSet<String>();
			if (str == null) {
				return null;
			} else if (str.length() == 0) {
				result.add("");
				return result;
			}
	 
			char firstChar = str.charAt(0);
			String rem = str.substring(1);
			Set<String> words = possibleOutCome(rem);
			for (String newString : words) {
				for (int i = 0; i <= newString.length(); i++) {
					result.add(charAdd(newString, firstChar, i));
				}
			}
			return result;
		}
	 
		public static String charAdd(String str, char c, int j) {
			String first = str.substring(0, j);
			String last = str.substring(j);
			return first + c + last;
		}
	 
	}

