package t2;

import java.math.BigInteger;

public class OldRSABreaker {

	private int n ;
	private BigInteger e;
	private int encryptedMessage;

	public void setN(int n) {
		this.n=n;
	}

	public void setE(BigInteger e) {
		this.e=e;

	}

	public BigInteger getPhi() {
		Pair p = sieve();
		return BigInteger.valueOf((p.getP()-1)*(p.getQ()-1));
	}

	public void setEncryptedMessage(int encryptedMessage) {
		this.encryptedMessage = encryptedMessage;
	}

	public BigInteger getD() { 
		return gcd(e,getPhi())[1];
	}

	public BigInteger decryptMessage() {
		
		return BigInteger.valueOf(encryptedMessage).pow(getD().intValue()).mod((BigInteger.valueOf(n)));
	}

	public Pair sieve() {
		int upperBoundSquareRoot = (int) Math.sqrt(n);

		boolean[] isComposite = new boolean[n + 1];

		for (int m = 2; m <= upperBoundSquareRoot; m++) {

			if (!isComposite[m]) {

				for (int k = m * m; k <= n; k += m)

					isComposite[k] = true;

			}

		}

		for (int i = 2; i< isComposite.length; i++) {
			if (!isComposite[i] && (n%i) == 0) {
				int j = n/i;
				if(!isComposite[j]) {
					Pair p = new Pair(i, j);
					return p;
				}

			}

		}


		return null;
	}
	
	static BigInteger[] gcd(BigInteger p, BigInteger q) {
	      if (q.compareTo(BigInteger.ZERO ) ==0)
	         return new BigInteger[] { p, BigInteger.ONE, BigInteger.ZERO };

	      BigInteger[] vals = gcd(q, p.mod(q));
	      BigInteger d = vals[0];
	      BigInteger a = vals[2];
	      BigInteger b = vals[1].subtract((p.divide(q)).multiply(vals[2]));
	      return new BigInteger[] { d, a, b };
	   }




//	public static void main(String[] args) {
//		OldRSABreaker rsa = new OldRSABreaker();
//		rsa.setE(BigInteger.valueOf(5524331));
//		rsa.setN(1177662719);
//		System.out.println(rsa.getPhi());
//	}

}