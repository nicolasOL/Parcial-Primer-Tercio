package edu.eci.arsw.api.primesrepo;

import edu.eci.arsw.api.primesrepo.model.FoundPrime;
import edu.eci.arsw.api.primesrepo.service.PrimeService;
import edu.eci.arsw.api.primesrepo.service.PrimeServiceStub;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Santiago Carrillo
 * 2/22/18.
 */

@RestController
public class PrimesController
{

    PrimeService primeService;


    @RequestMapping( value = "/primes", method = GET )
    public List<FoundPrime> getPrimes()
    {
        return primeService.getFoundPrimes();
    }
    
    @RequestMapping(value = "/primes/{primenumber}", method = GET)
    public ResponseEntity<?> getPrimeNumber(String prime){
        try {
            //obtener datos que se enviarán a través del API
            String data = new Gson().toJson(primeService.getPrime(prime));
            return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Recurso no encontrado",HttpStatus.NOT_FOUND);
        }        
    }
    
    @RequestMapping(value="/primes", method = RequestMethod.POST)	
    public  ResponseEntity<?> addPrime(@RequestBody FoundPrime f){
            ResponseEntity<?> retorno=null;
            if (!PrimeServiceStub.lista.contains(f)) {
            	primeService.addFoundPrime(f);
            }else {
            	retorno= new ResponseEntity<>("Recurso ya inscrito",HttpStatus.CONFLICT);
            }
    		retorno= new ResponseEntity<>(HttpStatus.CREATED);
    		return retorno;


    }

  



}
