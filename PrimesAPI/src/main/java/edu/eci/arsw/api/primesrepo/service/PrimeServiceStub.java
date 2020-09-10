package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */
public class PrimeServiceStub implements PrimeService
{
	static public ConcurrentHashMap<String, FoundPrime> lista=new ConcurrentHashMap<String, FoundPrime>(); 
	
    @Override
    public void addFoundPrime( FoundPrime foundPrime )
    {
        lista.put(foundPrime.getPrime(),foundPrime);
    }

    @Override
    public List<FoundPrime> getFoundPrimes()
    {
        //TODO
        return (List<FoundPrime>) lista.values();
    }

    @Override
    public FoundPrime getPrime( String prime )
    {
        
        return lista.get(prime);
    }
}
