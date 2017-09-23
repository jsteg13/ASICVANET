/*The e-token has the following characterisitcs
        1.  Allows authenticaiton to VANET network
        2.  Has a unique randomly generated ID
        3.  The ID of the e-token is uneditable i.e. final
        4.  The characters of the ID are represented in a string of characters
        */
package tesbted1;
import java.util.UUID;
/**
 *
 * @author Jabari
 */
public class EToken 
{
    private final String serNum;
    private UUID uniqueKey = UUID.randomUUID();
    
    EToken()
    {
        serNum = uniqueKey.toString();
       
    }
    
    public String getSerNum() 
    {
        return serNum;
    }

    
    
}
