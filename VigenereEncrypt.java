/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere.cipher;

import java.util.Scanner;

/**
 *
 * @author hussam eldien
 */
public class VigenereCipher {
      
public static String VigenereEncrpt(String key,String plinText){
    plinText=plinText.toUpperCase();
    key=key.toUpperCase();
    int l=plinText.length();
    int lk=key.length();
    int i,j;
    int[] k=new int[lk];
    for(i=0;i<lk;i++)
        k[i]=key.charAt(i)-'A';
    String out="";
    j=0;
    for(i=0;i<l;i++){ 
      int p;
      p=plinText.charAt(i)-'A';
      p+=k[j];
      j++;
      j=j%lk;
      if(p>=26)
        p-=26;
      p+='A';
      out=out+(char)p;  
    }
    return(out);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner skey = new Scanner (System.in);
        Scanner sPltxt = new Scanner (System.in);
        String key=skey.nextLine();
        String Pltxt=sPltxt.nextLine();
        String plainText=VigenereEncrpt(key,Pltxt);
        System.out.println(plainText+"\n");
    }
}
