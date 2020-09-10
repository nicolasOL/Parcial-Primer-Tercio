package edu.eci.arsw.api.primesrepo.service;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */

@Service()
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
    	ArrayList<FoundPrime> result=new ArrayList<FoundPrime>();
    	for (FoundPrime f:lista.values()) {
    		result.add(f);
    	}
        return result;
    }

    @Override
    public FoundPrime getPrime( String prime )
    {
        
        return lista.get(prime);
    }
}
