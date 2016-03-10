
package playfairdecrypt;

import java.awt.Point;


public class PlayFairDecrypt {
        
     public static char[][]buildKeyMatrix(String keyword)
   { Point p=new Point(-1,-1);
   int i,j,x,count=0;
   char[][] res =new char[5][5];
   int L=keyword.length();
   keyword=keyword.toUpperCase();
   char[] key = keyword.toCharArray(); 
   
   char [] alpha = new char [26+L];
   int countchar=65;
   
  for (x=0;x<=25+L;x++ )
  { 
      if(x<L){ 
      alpha[x]=key[x];}
      else {
      alpha[x]=(char)countchar;
      countchar++; }
      
 //System.out.println(alpha[x]);
  }
    
  for(i=0;i<5;i++)
   {    
       for(j=0;j<5;j++)
       {          
           char c;
           c =alpha[count];
          // count++;
           p= search(c,res);
           if(p.x==-1||p.y==-1) //the letter does not exist in the Matrix so  --> insert it      
           res[i][j]=c;
          else
          {  
             while(p.x!=-1) 
              {
               char c1=alpha[count++];
               p= search(c1,res);
               if(p.x==-1||p.y==-1)
               res[i][j]=c1; 
              }
             
          }
       //    System.out.println(p); 
         //  System.out.println("i="+i+'\t'+"j= "+j+" --> "+res[i][j]);
       }
   }
   return res;
   }
  
  
 static Point search(char letter,char[][]keyMatrix)
  {
      Point p = new Point(-1,-1);
      int i,j;
  for(i=0;i<5;i++)
{   for(j=0;j<5;j++)
    {
        if(letter==keyMatrix[i][j])
        {
            p.x=i;
            p.y=j; 
       return new Point(i,j);
        }       
    } 
}
 return new Point(-1,-1);
  }
  
   
    public static String playFairDecrypt(String string,String key) {
       String output=""; int i;
       Point p1=new Point();
       Point p2=new Point();
       string=string.toUpperCase(); 
       char[][]res=new char[5][5]; //to recieve the out put of build(); 
       int l=string.length();
       if(l%2==1) return null;        //the plain text is odd
       boolean f=search2(string);    //to check if the plain text contain 2 concequnce letters
       if(f==false) return null;    //the plain text contain 2 concequnce letters ;
     res= buildKeyMatrix(key);
  //    printMatrix(res);
       for(i=0;i<l;i+=2)     
{                               //Decrypt 
       p1=search(string.charAt(i),res);    
        p2=search(string.charAt(i+1),res);      //take 2 letters
      // Point t1=p1,t2=p2;
       if(p1.x==p2.x)           //the 2 letters in the same row 
       {
        p1.y=p1.y-1; 
        if(p1.y<0)p1.y+=5;
        p1.y%=5;
        p2.y=p2.y-1;
        if(p2.y<0)p2.y+=5;
        p2.y%=5;
       output+=res[p1.x][p1.y];
       output+=res[p2.x][p2.y];
      System.out.println(output);
       }
      if(p1.y==p2.y)             //the 2 letters in the same col.
       {
        p1.x=p1.x-1; 
        if(p1.x<0)p1.x+=5;
        p1.x%=5;
        p2.x=p2.x-1; 
        if(p2.x<0)p2.x+=5;
        p2.x%=5;
        output+=res[p1.x][p1.y];
       output+=res[p2.x][p2.y];
       System.out.println(output);
       }
      if((p1.y!=p2.y)&&(p1.x!=p2.x))   //the 2 letters does not exist in the same row nither the same col.
      {
      output+=res[p1.x][p2.y];
       output+=res[p2.x][p1.y];      
      System.out.println(output);
      }
}

 return output;}
 
  public static boolean search2( String string)
  { int i=0,count=0;
  char[]string1=string.toCharArray();
while(i<string.length())
{
    if (string1[count]==string1[count+1])
            return false;
         i++;}
            count++;


 return true;  } 

  public static void printMatrix(char[][]keyMatrix)
{
      for(int i=0;i<5;i++){
          for(int j=0;j<5;j++)
          {
          System.out.print(keyMatrix[i][j]+"\t");
          
          }
          System.out.println();
      }
}

   
    public static void main(String[] args) {
        String output=playFairDecrypt("BDYHSLSQQDUHABQNLI","model");
        System.out.println(output.toLowerCase());
    }
    
}
