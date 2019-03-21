import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.lang.reflect.*;


// **** address the input issue (part of the challenge) ****
import static java.lang.System.in;


/*
 * Requested class name for the challenge.
 */
class Prime {
	
	/*
	 * Determine if this number is prime or not.
	 */
	private boolean isPrime(int n) {
		
		// **** number <= 1 are not prime ****
		if (n <= 1)
			return false;
		
		// **** 2 and 3 are prime ****
		if (n <= 3)
			return true;
		
		// **** skip multiples of 2 and 3 ****
		if ((n % 2 == 0) ||				// even
			(n % 3 == 0))				// start at 3
			return false;
		
		// **** start with 3 and increment by 2 ****
		int sr = (int)Math.sqrt(n);
		for (int i = 3; i <= sr; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		
		// **** should be a prime ****
		return true;
	}
	
	
	/*
	 * Helper function to loop through the numbers and display primes
	 */
	void checkPrime(int... numbers) {
		
		// **** ****
		for (int n : numbers) {
			if (isPrime(n))
				System.out.print(n + " ");
		}
		System.out.println();
	}
}


/*
 * 
 */
public class Solution {

	/*
	 * 
	 */
	public static void main(String[] args) {
		try {
			
			// **** address this bug (introduced by HackerRank) ****
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
//			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			int n1=Integer.parseInt(br.readLine());
			int n2=Integer.parseInt(br.readLine());
			int n3=Integer.parseInt(br.readLine());
			int n4=Integer.parseInt(br.readLine());
			int n5=Integer.parseInt(br.readLine());
			
			Prime ob = new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1,n2);
			ob.checkPrime(n1,n2,n3);
			ob.checkPrime(n1,n2,n3,n4,n5);
			
			Method[] methods = Prime.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload=false;
			
			for(int i=0;i<methods.length;i++) {
				if(set.contains(methods[i].getName())) {
					overload=true;
					break;
				}
				set.add(methods[i].getName());
			}
			
			if(overload) {
				throw new Exception("Overloading not allowed");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
