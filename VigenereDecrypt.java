/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vigenere.decrypt;

import java.util.Scanner;

/**
 *
 * @author hussam eldien
 */
public class VigenereDecrypt {

    public static String VigenereDecryption(String key,String decryptText){
    decryptText=decryptText.toUpperCase();
    key=key.toUpperCase();
    int l=decryptText.length();
    int lk=key.length();
    int i,j;
    int[] k=new int[lk];
    for(i=0;i<lk;i++)
        k[i]=key.charAt(i)-'A';
    String out="";
    j=0;
    for(i=0;i<l;i++){ 
      int p;
      p=decryptText.charAt(i)-'A';
      p-=k[j];
      j++;
      j=j%lk;
      if(p<0)
        p+=26;
      p+='A';
      out=out+(char)p; 
      out=out.toLowerCase();
    }
    return(out);
}
    public static void main(String[] args) {
          Scanner skey = new Scanner (System.in);
        Scanner sDCtxt = new Scanner (System.in);
        String key=skey.nextLine();
        String DCtxt=sDCtxt.nextLine();
        String plainText=VigenereDecryption(key,DCtxt);
        System.out.println(plainText+"\n");
    }
}
