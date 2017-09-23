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
public class VanetDataCollector {
    private ArrayList<VanetData> data;
    private ArrayList<VerifierSignature> sigs;
    private int signedDataCount=0;
    private int numberETokensUsed=0;
    
    VanetDataCollector(){
        data=new ArrayList();
        sigs=new ArrayList();
    }
    
    public void collectData(VanetData d,int x, int y){
        if(d.isSigned()&&(x==y)){
            data.add(d);
            signedDataCount++;
        }
    }
    
    public void printDatabases(){
        for(int i=0; i<data.size();i++){
            System.out.println((data.get(i)).printData());
        }
    }
}
