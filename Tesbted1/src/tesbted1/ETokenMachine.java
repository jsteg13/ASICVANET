//e-token machine
        /*The e-token manager has the following responsibilities
        1.  Issues x amount of tokens perscribed by the EToken Sys Manager in 
            the prescribed interval and issues x new tokens every interval while
            disguarding the old tokens from previous intervals
        2. Blind signature capabilitity via miaxed cascade
        3. Has a serial number to be managed by e-token system manager
        4. 
        */
package tesbted1;

import java.util.UUID;

/**
 *
 * @author Jabari
 */
public class ETokenMachine 
{
   
    private int areas;
    private int authenAtmps;
    private double steps = .001;
    private int numCoinsPerInterval=5;
    private String MachID;
    
    ETokenMachine(String s){
         MachID = s;
    }
    
    public String dispense(){
        EToken token = new EToken();
        String t = token.getSerNum();
        return t;
    }
    
    public String getMachID(){
        return MachID;
    }
    
}
