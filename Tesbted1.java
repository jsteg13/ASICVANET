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
public class Tesbted1 
{
    public static void main(String[] args) 
    {    
        GlobalVerifierInfo globe = new GlobalVerifierInfo();
        VanetDataCollector collect = new VanetDataCollector();
        VanetVerifier veri = new VanetVerifier("Verifier INC");
        VanetCar car= new VanetCar("Vroom",4,veri.getVerifierName());
        VanetCar car2= new VanetCar("Vroom2",4,veri.getVerifierName());
         
        car.recieveEtokens();
        car2.recieveEtokens();
         
         
        for(int i=0;i<=2;i++){
        String s=car.eTokenRequest();
        String s2=car2.eTokenRequest();
        veri.verify(car.sendVanetData(), s,car.getEtokenMachineID(),globe.checkDatabase(s));
        veri.verify(car2.sendVanetData(), s2,car2.getEtokenMachineID(),globe.checkDatabase(s));
        globe.populate(s);
        globe.populate(s2);
        }
        
        
         System.out.println("Signed Data count: "+veri.getSignedDataCount());
         System.out.println("Etokens Used: "+veri.getTotalEtokensUsed());
         veri.printEtokenMachineDataBase();
         veri.printEtokenDataBase();
         
         
         
         
         collect.collectData(car.sendSignedData(),veri.getTotalEtokensUsed(),veri.getSignedDataCount());
         collect.collectData(car2.sendSignedData(),veri.getTotalEtokensUsed(),veri.getSignedDataCount());
         collect.printDatabases();
         
         globe.printEtokenDatabase();
         
         //System.out.println(car.checkVanetData());
         
    }        
}
