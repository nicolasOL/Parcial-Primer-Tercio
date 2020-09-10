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
            
            
         
            
       //   PUNTO 2
            

            /*

            //Mientras que haya movimiento del mouse, Mientras la tarea no esté terminada
            //while(MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement() > 10000){
            while(!Thread.interrupted()){
                try {
                    //check every 10ms if the idle status (10 seconds without mouse
                    //activity) was reached. 
                    Thread.sleep(10);
                    if (MouseMovementMonitor.getInstance().getTimeSinceLastMouseMovement() > 10000){
                   
                        prime.pararelNthreads(4,new BigInteger("1"), new BigInteger("10"));
                    }
                    else{
                        System.out.println("ya");
                        
                        Thread.holdsLock();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PrimesFinderTool.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                synchronized (this)) {
	                for (int i=0;i<nThreads;i++) {
						arrayThreads[i].notify();
					}
                   
                }
            }     
            */
            
            
            
	}
	
	
	public static void pararelNthreads (int nT, BigInteger ini,BigInteger fin) {
		
	
		
		
		//System.out.println(nT);
		//System.out.println(ini);
		//System.out.println(fin);
		nThreads=nT;
		arrayThreads = new PrimeThread[nThreads];
    	//BigInteger tHilo=fin.subtract(ini).add(BigInteger.valueOf(1));
    	int nHilo=fin.intValue()/nThreads;
    	int mHilo=fin.intValue()%nThreads;
    	int k=nHilo;
    	//BigInteger[] nHilo=fin.divideAndRemainder(BigInteger.valueOf(nThreads));
    	//System.out.println(nThreads);
    	int act=ini.intValue();
    	for(int i = 0; i<nThreads; i++) {
            if(i+1 == nThreads) {
                threads.add(BigInteger.valueOf(act));
                act+=k+mHilo-1;
                threads.add(BigInteger.valueOf(act));
                
            }else {
                threads.add(BigInteger.valueOf(act));
                act+=k;
                threads.add(BigInteger.valueOf(act));
            }
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
			//System.out.println(threads.get(i));
			//System.out.println(threads.get(i+1));
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


