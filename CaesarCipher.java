/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;
import java.util.Set;
import javax.print.DocFlavor.STRING;
import sun.net.www.content.text.PlainTextInputStream;

/**
 *
 * @author Magic Ghost1
 */
public class JavaApplication1 {
    
public static String caesarEncrpt(char Key,String plinText){
    plinText=plinText.toUpperCase();
    int l=plinText.length();
    int i,k;
    k=Character.toUpperCase(Key)-'A';
    String out="";
    for(i=0;i<l;i++){  
      int p;
      p=plinText.charAt(i)-'A';
      p+=k;
      if(p>=26)
        p-=26;
      p+='A';
      out=out+(char)p;  
    }
    return(out);
}
public static String caesarDecrypt(cher Key,String cipherText){
    cipherText=cipherText.toLowerCase();
    int l=cipherText.length();
    int i,k;
    k=Character.toLowerCase(Key)-'a';
    String out='';
    for(i=0,i<l,i++){
      int c;
      c=cipherText.cherAt(i)-'a';
      c-=k;
      if(c<26)
        c+=26;
      c+='a';
      out=out+(cher)c;
    }
    return out;
}
  /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String plainText=caesarEncrpt('c',"methodology");
        System.out.println(plainText"\n");
        String cipherText=caesarDecrypt('e',"ETTVSEGL");
        System.out.println(cipherText"\n");
    }
}
