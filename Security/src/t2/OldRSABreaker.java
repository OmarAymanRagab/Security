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
		//TO-DO
		return BigInteger.ZERO;
	}

	public BigInteger decryptMessage() {
		//TO-DO
		return BigInteger.ZERO;
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

		for (int i = 0; i< isComposite.length; i++) {
			if (!isComposite[i]) {
				for (int j = 0; j< isComposite.length; j++) {
					if (!isComposite[j] && i*j == n) {
						Pair p = new Pair(i, j);
						return p;


					}

				}
			}
		}
		return null;
	}



	public static void main(String[] args) {
		OldRSABreaker rsa = new OldRSABreaker();
		rsa.setE(BigInteger.valueOf(5524331));
		rsa.setN(1177662719);
		System.out.println(rsa.getPhi());
	}

}