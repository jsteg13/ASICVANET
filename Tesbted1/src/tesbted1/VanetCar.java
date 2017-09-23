/*The VANET car has the following characterisitcs
        1.  Can access subscribed VANET network via etoken request
        2.  Has a name and ID or some type of simple unique identifier
        3.  When the car tries to access the VANET network it submits a unique
            etoken request to the providers VANET netowk
        4.  After the request has been approved the vehicle will send valuable 
            info to the network and it will be encryted and verified by 
            subscriber and provider via blind signature.
        5.  If a car tries to send info to a vanet network more than n times the
            the car will recieve a denial to etoken request
        6.  If an adversary attempts to send a duplicate etoken the car will 
            recieve a denial to its etoken request
*/
package tesbted1;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Jabari
 */
public class VanetCar { 
    private ETokenMachine sys;
    private int numCoinsPerInterval=5;
    private ArrayList<String> bank;
    private String ID;
    private int arrayIndex;
    private VanetData data;
    private String name;
    private ArrayList<VanetData> mdata;
    private ArrayList<VanetData> smdata;
    private UUID uniqueKey = UUID.randomUUID();
    
    
    
    
    
    VanetCar(String n,String EtokenMachineBrand){
        String key=uniqueKey.toString();
        bank =new ArrayList();
        sys = new ETokenMachine(EtokenMachineBrand+key);
        name=n;
        
        
    }        
    VanetCar(String n,int coinsPerInt,String EtokenMachineBrand){
        String key=uniqueKey.toString();
        numCoinsPerInterval=coinsPerInt;
        bank =new ArrayList();
        sys = new ETokenMachine(EtokenMachineBrand+" || "+key);
        mdata=new ArrayList();
        smdata= new ArrayList();       
        name=n;
    }
    
    public String getEtokenMachineID(){
        return sys.getMachID();
    }
    
    
    
    public String eTokenRequest(){
        if(bank.size()>0){
        arrayIndex= (int) (Math.random() * bank.size());   
        ID=bank.get(arrayIndex);
        bank.remove(arrayIndex);
        bank.trimToSize();
        }return ID;
    }
    
   public void recieveEtokens(){
        
       for(int x=1;x<=numCoinsPerInterval;x++){        
        bank.add(x-1,sys.dispense());
        
        }
   }
   
   public VanetData sendVanetData(){
       data=new VanetData();//this will have data parameters later
       mdata.add(data);
       return data;
   }      
   
   public VanetData sendSignedData(){
       for(int i=0;i<mdata.size();i++)
       {    
        if(mdata.get(i).isSigned()==true){
            smdata.add(mdata.get(i));
            }
        else{
           System.out.println("No signed data to send");
        }
        }return data;
   }
   
   public ArrayList<VanetData> sendMVanetData(){
      mdata=new ArrayList();
      return mdata;
       
   }
   
   public String checkVanetData(){
       return "Signed by: "+data.checkSig();
   }
   
   public int bankSize(){
       return bank.size();
   }
   
    
//    public String getInfo(){
//        return "Name: "+name+" || Location: "+info1 + " || Speed: "+info2+" || Direction: "+ info3;
//               
//    }
//            
//    
//    public void setInfo1(String s) 
//    {
//        info1=s;
//    }
//    
//    public String getInfo1() 
//    {
//        return "Location: "+info1;
//    }
//    
//    public void setInfo2(String s) 
//    {
//        info2= s;
//    }
//    
//    public String getInfo2() 
//    {
//        return "Location: "+info2;
//    }
//    
//    public void setInfo3(String s) 
//    {
//        info3= s;
//    }
//    
//    public String getInfo3() 
//    {
//        return "Direction: "+info3;
//    }
    
    public void setName(String s) 
    {
        name= s;
    }
    
    public String getName() 
    {
        return "Name: "+name;
    }
            
    
}
