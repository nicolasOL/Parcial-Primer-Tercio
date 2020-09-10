package edu.eci.arsw.primefinder;

import edu.eci.arsw.mouseutils.MouseMovementMonitor;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class PrimesFinderTool {

	public static void main(String[] args) {
		            
            int maxPrim=1000;
            private int nThreads;
            private int[] threads;
            
            
            
            PrimesResultSet prs=new PrimesResultSet("john");
            System.out.println("Prime numbers found:");
            PrimeFinder.findPrimes(new BigInteger("1"), new BigInteger("10"), prs);
            
            
            System.out.println(prs.getPrimes());
            
            
            
            
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
	
	
	public void pararelNthreads (int nT, BigInteger ini,BigInteger fin) {
    	BigInteger tHilo=fin.subtract(ini);
    	BigInteger nHilo=tHilo.divide(BigInteger.valueOf(nT));
    	BigInteger mHilo=tHilo.mod(BigInteger.valueOf(nT));
    	for (int i = 0; i<nT) {
    		
    	}
    	
    }
	
}


