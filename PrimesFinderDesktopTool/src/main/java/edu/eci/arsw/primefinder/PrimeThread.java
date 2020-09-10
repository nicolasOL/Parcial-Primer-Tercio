package edu.eci.arsw.primefinder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

public class PrimeThread extends Thread{
	private Collection<BigInteger> result= new ArrayList<BigInteger>() ;
	private BigInteger ini;
	private BigInteger fin;

	
	public PrimeThread(BigInteger Nini, BigInteger Nfin) {
		this.ini=Nini;
		this.fin=Nfin;
	}
	
	
	@Override
	public void run() {
		PrimesResultSet p = new PrimesResultSet("john");
		PrimeFinder.findPrimes(ini, fin, p);
		result=p.getPrimes();
		

	}
	
	public Collection<BigInteger> getResult (){
		return result;
	}
}
