package codereview.day1;

public class Solution {
	public static boolean isPrime(int num) {
		int checkPrime=13,nPrime=0;
	      for (int i = 2; i <= checkPrime; i++)
	      {
	        if(checkPrime % i == 0) 
	        {
	          nPrime=1;
	          break;
	        }
	      }
	      if(nPrime==0)
	        {
	        return false;
	        }else
	        {
	    	return true;	
	        }

	}

	public static void main(String[] args) {
		Solution.isPrime(13);
	}

}
