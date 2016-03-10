public static String autokeyEncrpt(String Key,String plinText){
    plinText=plinText.toUpperCase();
    int l=plinText.length();
    int lk=Key.length();
    if(lk<l)
    {
        int j,x=l-lk;
        for(j=0;j<x;j++)
        {
            Key=Key+plinText.charAt(j);
        }
    }
    int i;
    Key=Key.toUpperCase();
    String out="";
    for(i=0;i<l;i++){  
      int p,h;
      h=Key.charAt(i)-'A';
      p=plinText.charAt(i)-'A';
      p+=h;
      if(p>=26)
        p-=26;
      p+='A';
      out=out+(char)p;  
    }
    return(out);
}
public static String autokeyDecrypt(String Key,String cipherText){
    cipherText=cipherText.toLowerCase();
    int l=cipherText.length();
    int lk=Key.length();

     String out="";
            Key=Key.toLowerCase();
    
    int i;
    for(i=0;i<l;i++){
         
    int c,h;
    if(i<lk){
      h=Key.charAt(i)-'a';
      c=cipherText.charAt(i)-'a';
      c-=h;
      if(c<0)
        c+=26;
      c+='a';
      out=out+(char)c;}
    else
       {
      h=out.charAt(i-lk) -'a';
      c=cipherText.charAt(i)-'a';
      c-=h;
      if(c<0)
        c+=26;
      c+='a';
      out=out+(char)c;}     
          
    }
    return (out);
}
------------------------------------------------------------------------------------
                String plainText=autokeyEncrpt("mine","prioritize");
                System.out.println(plainText+"\n");
                String cipherText=autokeyDecrypt("for","NBUMCHRSIAFI");
                System.out.println(cipherText+"\n");