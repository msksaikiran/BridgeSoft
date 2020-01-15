package dfsdfd;

public class Decimal {
public static void main(String[] args) {
	MathPowForBin mpb=new MathPowForBin();
	int num=647;
	long res=0;
	int rem=0;
	//int pwr=0;
	/*while(num>0){
		rem=num%2;
		res=(long)(res+rem*Math.pow(10,pwr));
		pwr++;
		num=num/2;
	}
	System.out.println(res);*/
	while(num>0){
		rem=num%2;
		res=(long)(res+rem*mpb.power());
		//pwr++;
		num=num/2;
	}
	System.out.println(res);
	
}
}
