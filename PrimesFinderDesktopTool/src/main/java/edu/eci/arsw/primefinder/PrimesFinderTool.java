package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {
	private static int nThreads;
	private static PrimeThread[] arrayThreads;
    private static ArrayList<BigInteger> threads= new ArrayList<BigInteger>();
    
    
    
	public static void main(String[] args) {
		            
            /*int maxPrim=1000;
            
            
            
            
            PrimesResultSet prs=new PrimesResultSet("john");
            System.out.println("Prime numbers found:");
            PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("10"), prs);
            
            
            System.out.println(prs.getPrimes());
            */
            
            pararelNthreads(4,new BigInteger("1"), new BigInteger("10"));
            
            
            /*while(task_not_finished){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement()>10000){
                        System.out.println("Idle CPU ");
                    }
                    else{
                        System.out.println("User working again!");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
                        
            
            
            
            
	}
	
	
	public static void pararelNthreads (int nT, BigInteger ini,BigInteger fin) {
		//System.out.println(nT);
		//System.out.println(ini);
		//System.out.println(fin);
		nThreads=nT;
		arrayThreads = new PrimeThread[nThreads];
    	BigInteger tHilo=fin.subtract(ini).add(BigInteger.valueOf(1));
    	BigInteger nHilo=BigInteger.valueOf(fin.intValueExact()/nThreads);
    	//BigInteger[] nHilo=fin.divideAndRemainder(BigInteger.valueOf(nThreads));
    	System.out.println(nThreads);
    	System.out.println("tHilo: "+tHilo);
    	System.out.println("nHilo: "+nHilo);

    	for (int i = 0; i<nThreads;i++) {
    		threads.add(ini);
    		threads.add(ini.add(nHilo));
    		
    	}
    	try {
			primos();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    }
	
	public static void primos() throws InterruptedException {
		String result="";
		//System.out.println(threads.size());
		for (int i=0;i<threads.size();i=i+2) {
			//System.out.println(i);
			arrayThreads[i/2]= new PrimeThread(threads.get(i), threads.get(i+1));
			
		}
		for (int i=0;i<nThreads;i++) {
			arrayThreads[i].start();
		}
		for (int i=0;i<nThreads;i++) {
			//System.out.println(i);
			arrayThreads[i].join();
			result+=arrayThreads[i].getResult();
		}
		System.out.println(result);
	}
	
}


