package dfsdfd;

public class Binary {
public static void main(String[] args) {
	String arr = toBinay(12);
	System.out.print(arr);
}

public static String toBinay(long decimal) {
	
	long[] binary=new long[40];
	int index=0;
	String ss="";
	while(decimal>0){
		binary[index++]=decimal%2;
		decimal=decimal/2;
	}
	for(int i=index-1;i>=0;i--){
		ss+=binary[i];
		}
	return ss;
 }
}
