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