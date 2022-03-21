package task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        System.out.println(belongs("aa"));

    }

    public static boolean belongs (String token){ 
 int state = 1; 
 int i = 0; 
 while(i <token.length()){ 
  char ch = token.charAt(i); 
  switch(state) 
 { 
   case 1: 
    if(ch == 'a'){ 
     state = 2;
    } 
    else if(ch == 'b'){ 
     state = 1;
    } 
    else 
     return false; 
     break; 
   case 2: 
    if(ch == 'a'){ 
     state = 3;
    } 
    else if(ch == 'b'){ 
     state = 1;
    } 
    else 
     return false; 
     break; 
   case 3: 
    if(ch == 'a'){ 
     state = 3;
    } 
    else if(ch == 'b'){ 
     state = 3;
    } 
    else 
     return false; 
     break; 
    } 
    i++; 
   } 
   if(state == 3)
    return true; 
   else 
    return false; 
   } 



}
