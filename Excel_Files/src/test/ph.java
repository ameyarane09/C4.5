package test;

//DiscreteLog.java

import java.math.BigInteger;

public class ph {
	
	public static long power(long a, long m, long n) {
		// Find a^m mod n
		BigInteger base = BigInteger.valueOf(a);
		BigInteger exponent = BigInteger.valueOf(m);
		BigInteger module = BigInteger.valueOf(n);
		BigInteger p = base.modPow(exponent, module);
		return p.longValue();
	}
	public static long inverse(long a, long n) {
		// Find a^(-1) mod n
		BigInteger r1 = BigInteger.valueOf(a);
		BigInteger r2 = BigInteger.valueOf(n);
		BigInteger inv = r1.modInverse(r2);
		return inv.longValue();		
	}
	public static long gcd(long a, long b) {
		// Find gcd(a,b);
		BigInteger r1 = BigInteger.valueOf(a);
		BigInteger r2 = BigInteger.valueOf(b);
		BigInteger g = r1.gcd(r2);
		return g.longValue();
	}
	
	// shank's algorithm
	public static long shank(long a, long b, long p) {
		// To find x such that a^x = b mod p, p is a prime
		int m = (int)Math.sqrt(p-1);
		long[] first = new long[m];
		long ainv = inverse(a, p);
		first[0] = b;
		for (int i=1; i<m; i++) first[i] = (first[i-1]*ainv)%p;
		long am = power(a, m, p);
		long second = 1;
		long result = -1;
		System.out.println("m = " + m);
		System.out.println("a^m = " + am);
		System.out.println("a inverse = " + ainv);
		for (int j=0; j<m; j++ ) {
			second = power(am, j, p);
			for (int i=0; i<m; i++) {
				if (second == first[i]) {
					System.out.println("i = " + i);
					System.out.println("j = " + j);
					result = (m*j+i);
					break;
				}
			}
			if (result>-1) break;
		}
		return result;
	}
	
	// Pollard Rho Algorithm
	static class Pollard {
		private long N;
		private long n;
		private long alpha;
		private long beta;
		private long x = 1;
		private long a = 0;
		private long b = 0;
		private long X = x;
		private long A = a;
		private long B = b;
		
		public Pollard(long alpha, long beta, long N) {
			this.alpha = alpha;
			this.beta = beta;
			this.N = N;
			n = N-1;
		}
		
		private void new_xab(int type) {
			if (type == 1) {
				switch((int)(x%3)) {
				case 0: x = (x*x)%N;  a = (a*2)%n; b = (b*2)%n; break;
				case 1: x = (x*alpha)%N; a = (a+1)%n; break;
				case 2: x = (x*beta)%N; b = (b+1)%n; break;
				}
			}
			if (type == 2) {
				switch((int)(X%3)) {
				case 0: X = (X*X)%N;  A = (A*2)%n; B = (B*2)%n; break;
				case 1: X = (X*alpha)%N; A = (A+1)%n; break;
				case 2: X = (X*beta)%N; B = (B+1)%n; break;
				}
			}
		}
		
		public void solve() {
			System.out.println("x\t X\t  a\t  A\t   b\t    B");
			for(long i = 1; i < n; i++ ) {
 			new_xab(1);
 			new_xab(2); 
 			new_xab(2);
 			if (x == X) {
 				System.out.println(x+" "+X+" "+a+" "+A+" "+b+" "+ B);
 				// Find the solution
 				long s = (n+B-b)%n;
 				long t = (n+a-A)%n;
 				//System.out.println("Solve " + s + "x = "+ t);
 				long g = gcd(gcd(s,n),t);
 				n = n/g; s=s/g; t=t/g;
 				long answer = (t*inverse(s,n))%n;
 				System.out.println("Answer = "+answer);
 				break;
 			}
 		}
		}
	}
	
	// Pohlig-Hellman Algorithm
	// 19839996 = 2*2*3*3*11*50101
	public static void pohligHellman() {
		// Find x such that 17^x = 5099 mod 19839997
		// We can find that phi(19839997) = 19839996 = 2*2*3*3*11*50101
		long[] primes = {5,8};
		long[] b = new long[primes.length];
		long p = 41;
		long phi = 40;
		long alpha = 7;
		long beta = 12;
		for (int i=0; i<primes.length; i++) {
			long e = phi/primes[i];
			long betaPow = power(beta, e, p);
			long alphaPow = power(alpha, e, p);
			for (long j=0; j<primes[i]; j++) {
				long a1 = power(alphaPow, j, p);
				if (a1 == betaPow) {
					b[i] = j; 
					//System.out.println(b[i]);
					break;
				}
			}
		}
		for (int i=0; i<b.length; i++) {
			System.out.println("b" + (i+1) + " = " + b[i]);
		}
		// We get b = {1,4,5,41273}
		// Apply Chinese Remainder Theorem
		// Solve the system of equations
		// x = 1 mod 4
		// x = 4 mod 9
		// x = 5 mod 11
		// x = 41273 mod 50101
		long M = 1;
		long[] m = new long[b.length];
		for (int i=0; i<primes.length; i++) M = M*primes[i];
		for (int i=0; i<primes.length; i++) {
			m[i] = inverse(M/primes[i], primes[i]);
		}
		long answer = 0;
		for (int i=0; i<b.length; i++) {
			answer = (answer + b[i]*m[i]*M/primes[i])%M;
		}
		System.out.println("Answer = " + answer);
	}
	
	// Index Calculus Algorithm
	public static void indexCalculus() {
		// Hard to be done by code
	}
	
	public static void main(String[] args) {
		// Shank's algorithm, answer = 59181515
		System.out.println("Shank's algorithm for problem #1");
		System.out.println("Answer = " + shank(37, 12295, 79839983));
		System.out.println("");
		
		// Pollard Rho Algorithm: answer = 11687164
		System.out.println("Pollard's Pho algorithm for problem #2");
		new Pollard(79, 4341, 39839983).solve();
		System.out.println("");
		
		// Pohlig-Hellman Algorithm: answer = 8257837
		System.out.println("Pohlig-Hellman algorithm for problem #3");
		pohligHellman();
		System.out.println("");
		
		// Index Calculus: answer = 52282748
		System.out.println("Index Calculus algorithm for problem #4");
		System.out.println("Answer = " + shank(83, 12295, 89839993));
	}
}