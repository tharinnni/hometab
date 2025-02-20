	package week1.day1;
	
	public class IsPrime {
	
		public static void main(String[] args) {
			int checkPrime=91,nPrime=0;
			for (int i = 2; i <= checkPrime; i++) {
				if(checkPrime % i == 0) {
					System.out.println("The Number is Not  Prime");
					nPrime=1;
					break;
				}
			}
			if(nPrime==0)
			{
				System.out.println("The Number is Prime");
			}
	
		}
	
	}
	