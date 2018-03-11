package t2;
import java.util.ArrayList;

public class Hacking2 {

	
	public static ArrayList<Integer> Primes(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int i = 2; i <= n; i++) {
			primes.add(i);
		}
		for (int i = 0; i < primes.size(); i++) {
			if(isPrime(primes.get(i))) {
				primes.removeAll(getMultiples(primes.get(i), n));
			}
		}
		return primes;
		
	}
	
	public static boolean isPrime(int num) {
		if(num == 0 || num ==1) {
			return false;
		}
		if(num == 2) {
			return true;
		}
		
		for (int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
			
		}
		
		return true;	
	}
	
	public static ArrayList<Integer> getMultiples(int num, int n) {
		ArrayList<Integer> multiples = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if( num*i <= n) {
			multiples.add(num*i);
		}
		}
		return multiples;
	}
	
	public static void main(String[] args) {
		System.out.println(isPrime(3));
		System.out.println(getMultiples(2, 50));
		System.out.println(Primes(53));
	}
	
}
