        /*The e-token manager has the following responsibilities
        1.  Tracking the amount of areas the it needs to manage(This is for future
            inforank implementation
        3.  Manages the interval in how often new coins with be redistrubuted
        4.  Manages the amount of N authentications per interval i.e maximum amount 
            of coins uses per user per interval
        5. Detects which coin dispenser has attempted more than N Max Authentication attempts(usually adversary)
        6. Manages the serial numbers of coin dispensers
        7.  The system retains tracing information(Etoken ser num)) as well as 
            revocation information of etoken machine attempt
        */
package tesbted1;

import java.util.ArrayList;

/**
 *
 * @author Jabari
 */
public class VanetVerifier {
    
    int numAreas=1; //Areas would  idealy be the size of the average city block
    int numCars=numAreas*12; /**During average conditions it is estimated to be 
                               at least n cars per surveyed block and propose 12
                               is the average.*/
    double networkatks=(.25)*numCars; //Lets assume 1/4 drivers in a adversary    
    double AuthenInterval=1; /**This is one second The authentication interval 
                               refreshes every second*/
    int NMaxAuthen=numCars*10;
    private int numCoinsPerInterval;  //this is the same as number of authen tications per interval
    private int intervalSecs;
    private int mdata;
    private String verifierName;
    private ArrayList<String> eTokenDatabase;
    private VerifierSignature sig;
    private int signedDataCount=0;
    private int numberETokensUsed=0;
    private ArrayList<String> eTokenMachineDatabase;
    private ArrayList<String> eTokenMachineBlackList;
    
    
    VanetVerifier(String n){
        verifierName=n;
        
        eTokenDatabase=new ArrayList();
        eTokenMachineDatabase=new ArrayList();
        eTokenMachineBlackList=new ArrayList();
                
    }
    
    public String getVerifierName(){
        return verifierName;
    }
    
    public int getCoinsPerInterval(){
    return numCoinsPerInterval;
}
    public void setCoinsPerInterval(int i){
        numCoinsPerInterval=i;
    }
    
    public void verify(VanetData d,String etokenSerNum,String etokenMachineID,Boolean GlobalDatabaseCheck)
    {
        sig = new VerifierSignature(verifierName);
        if(eTokenMachineDatabase.contains(etokenMachineID))
        {
            if(eTokenDatabase.contains(etokenSerNum)&&GlobalDatabaseCheck)
            {
            d.signInfo(false, "EToken Has already been used");
            eTokenMachineBlackList.add(etokenMachineID);
                if(eTokenMachineBlackList.contains(etokenMachineID))
                {
                d.signInfo(false, "Your Etoken Machine has been blacklisted until further notice");            
                }       
            }
            else
            {
            d.signInfo(sig.getSignStatus(), sig.getCompanySig());
            signedDataCount++;           
            eTokenDatabase.add(etokenSerNum);  
            numberETokensUsed=eTokenDatabase.size();
            }
        }  
        
        else
        {
            eTokenMachineDatabase.add(etokenMachineID);       
            if(eTokenDatabase.contains(etokenSerNum)&&GlobalDatabaseCheck)
            {
            d.signInfo(false, "EToken Has already been used");
             eTokenMachineBlackList.add(etokenMachineID);
                if(eTokenMachineBlackList.contains(etokenMachineID))
                {
                d.signInfo(false, "Your Etoken Machine has been blacklisted until further notice");            
                }       
            }
            else
            {
            d.signInfo(sig.getSignStatus(), sig.getCompanySig());
            signedDataCount++;            
            eTokenDatabase.add(etokenSerNum);
            numberETokensUsed=eTokenDatabase.size();
            }
        }
    }
                 
    public void printEtokenDataBase(){
        for(int n=0;n<eTokenDatabase.size();n++){
        System.out.println("EToken "+(n+1)+": "+eTokenDatabase.get(n));
        }
    }
    
    public String getSignature(){
        return sig.getCompanySig();
    }
    
    public void printEtokenMachineDataBase(){
        for(int n=0;n<eTokenMachineDatabase.size();n++){
        System.out.println("EToken Machine "+(n+1)+": "+eTokenMachineDatabase.get(n));
        }
    }
    
    public int getSignedDataCount(){
        return signedDataCount;
        
    }
    
    public int getTotalEtokensUsed(){
        return numberETokensUsed;
        
    }
    
   
    
    
}
