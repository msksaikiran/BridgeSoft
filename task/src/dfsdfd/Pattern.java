package dfsdfd;

public class Pattern {
	public static void main(String[] args) {
		
int space=4;
int star=1;
for(int i=1;i<=10;i++){
	for(int j=1;j<=space;j++){
		System.out.print(" ");
	}
	for(int k=1;k<=star;k++){
		if((i==7||i==8||i==9||i==10)&&(k==4||k==5||k==6)){
			System.out.print(" ");
		}else{
			System.out.print("*");
		}
	}
	if(i==5||i==6||i==7||i==8||i==9){
		star=star-2;
	}
	System.out.println();
	space--;
	star+=2;
}
}
}
