package dfsdfd;

public class MathPowForBin {
	public long power(){
		Pwr p1=new Pwr();
		Long j=p1.pwrFinder();
		return j;
	}
}
class Pwr{
	  static long s=1;
	  public long pwrFinder(){
		  s=s*10;
		  return s;
	  }
}
