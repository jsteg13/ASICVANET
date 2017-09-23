/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesbted1;

/**
 *
 * @author Jabari
 */
public class VanetData {
    private String info1;
    private String info2;
    private String info3;
    private Boolean signed;
    private String verifierSig;
    
    VanetData(){
        info1="location";
        info2="velocity";
        info3="timestamp";
        signed=false;
        verifierSig=null;
    }
    
    public Boolean isSigned(){
        return signed;
    }
    
    public String checkSig(){
        return verifierSig;
    }
    
    public void signInfo(Boolean b,String s){
        signed =b;
        verifierSig=s;
    }
    
    public String printData(){
        return info1+" || "+info2+" || "+info3+" || "+"Data Signed?: "+signed+" || "+"Verifier Signature: "+verifierSig;
    }
}
