/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesbted1;

import java.util.UUID;

/**
 *
 * @author Jabari
 */
public class VerifierSignature {
    private Boolean signed;
    private UUID uniqueSig = UUID.randomUUID();
    private String sigSerNum;
    private String verifierSig;
    
    VerifierSignature(String s){
       sigSerNum= uniqueSig.toString();
       verifierSig=s+" "+sigSerNum;
       signed=true;
    }
    
    VerifierSignature(){
      sigSerNum= uniqueSig.toString();
      signed=true;
      verifierSig="No comapny signature available";
    }
    
    public Boolean getSignStatus(){
        return signed;
    }
    
    public String getCompanySig(){
        return verifierSig;
    }
    
}
