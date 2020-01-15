package dfsdfd;

public class Recurion {
public static void main(String[] args) {
	String s1="sai is great";
	reverse(s1);
}

private static void reverse(String s1) {
	// TODO Auto-generated method stub
	if(s1==null||s1.length()<=1){
		System.out.println(s1);
	}else{
		System.out.print(s1.charAt(s1.length()-1));
		reverse(s1.substring(0, s1.length()-1));
      }
}
}
