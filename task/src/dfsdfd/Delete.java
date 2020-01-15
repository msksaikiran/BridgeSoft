package dfsdfd;

public class Delete {
	
		public static void m1(int[] ar)
		{
			//int[] ar= {2,2,2,3,3};
			int n=ar.length;
			for(int i=0;i<n-1;i++)
			{
				int temp=1;
				for(int j=i+1;j<n;j++)
				{
					int counter=0;
					if(ar[i]==ar[j])
					{
					//temp=temp+counter++;
					int k=j;
					while(k<n-1)
					{
						ar[k]=ar[k+1];
						k++;
					}
					n--;
					j--;
					}
					/*if(ar[i]>ar[j])
					{
						int flage=ar[i];
						ar[i]=ar[j];
						ar[j]=temp;
					}*/
				}
				//System.out.println("*******"+temp);
			}
			
			for(int k=0;k<n;k++)
			   {
			   System.out.println(ar[k]);
			   }
		}

		public static void main(String[] args) {
			
	   int[] ar= {2,3,2,3,5,6,4,2};
	   m1(ar);
	   
	   
	   
		}

	}


