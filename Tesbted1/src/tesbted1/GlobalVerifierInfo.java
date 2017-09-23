/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesbted1;

import java.util.ArrayList;

/**
 *
 * @author Jabari
 */
public class GlobalVerifierInfo {
     private ArrayList<String> usedETokenDatabase;
     private Boolean etokenStatus; //True means in database false means not
     
     GlobalVerifierInfo(){
         usedETokenDatabase=new ArrayList();
     }
     
     public void populate(String s){
         usedETokenDatabase.add(s);        
     }
    
     public Boolean checkDatabase(String etoken){
         for(int n=0;n<usedETokenDatabase.size();n++){
             if(etoken==usedETokenDatabase.get(n)){
                etokenStatus=true;
             }else{
                 etokenStatus= false;
              }
     }return etokenStatus;
     
     }
     
     public void printEtokenDatabase(){
         for(int n=0;n<usedETokenDatabase.size();n++){
             System.out.println(usedETokenDatabase.get(n));
         }
     }
}
