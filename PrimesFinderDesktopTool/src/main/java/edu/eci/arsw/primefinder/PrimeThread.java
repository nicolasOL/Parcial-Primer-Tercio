package edu.eci.arsw.primefinder;

import java.math.BigInteger;
import java.util.Collection;

public class PrimeThread extends Thread{
	private Collection<BigInteger> result;
	private BigInteger ini;
	private BigInteger fin;

	
	public PrimeThread(BigInteger Nini, BigInteger Nfin) {
		this.ini=Nini;
		this.ini=Nfin;
	}
	@Override
	public void run() {
		PrimesResultSet p = new PrimesResultSet("john");
		PrimeFinder.findPrimes(ini, fin, p);
		result=p.getPrimes();
		System.out.println(result);
	}
}
