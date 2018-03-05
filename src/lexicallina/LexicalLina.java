/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicallina;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Michael Relacion
 */
public class LexicalLina {
    public static final String FILENAME = "test.txt";
    public static Scanner S;
    public static List<Token> TokenStream = new ArrayList<>();
    
   
    private static boolean whitespace(char c){
        return c == ' ';     
    }
    
    
    private static boolean letter(char c){
        return Character.isLetter(c);
    }
    
    private static boolean digit(char c){
        return Character.isDigit(c);
    }
    
    public static void com1(String statement, int pos){
       
        if(statement.charAt(pos) == '/'){
            com2(statement,pos+1);}
    }
    
    public static void com2(String statement,int pos){
     
        if(statement.charAt(pos) == 'c');
            com3(statement,pos+1);
    }
    
    public static void com3(String statement,int pos){
        
        if(statement.charAt(pos) == 'm');
            com4(statement,pos+1);
    }
    
    public static void com4(String statement,int pos){
        
        if(statement.charAt(pos) == 't');
            com5(statement,pos+1);
    }
    
     public static void com5(String statement,int pos){
        int counter = pos;
        // Checks comment string
       
        String name = "";
        char temp = ' ';
        if(statement.charAt(counter)!=':')
            WrongSyntaxError();
        
        counter++;
            
        
        if(!letter(statement.charAt(counter))) 
            ErrorStartWithLetter();
        
        
        while(statement.charAt(counter) != ':' ){
            temp = statement.charAt(counter);
           
            
            if(letter(temp) || digit(temp) || whitespace(temp))
                name += temp;
            else
                break;
            
            counter++;
        }
        
        if(statement.charAt(counter++) == ':'){
           
            if(statement.charAt(counter++) == '/'){
                com6(name);
            }
        }else{
                WrongSyntaxError();
        }
    }
    
    public static void com6(String name){
                Token s = new Token(name,"Comment");
                TokenStream.add(s);
                //FINISHED COMMENT!
    } 
     
     
    public static void int1(String statement,int pos){
        if(statement.charAt(pos)=='n'){
            pos+=1;
            if(statement.charAt(pos)=='t'){
                pos+=1;
                if(statement.charAt(pos)=='e'){
                    pos+=1;
                    if(statement.charAt(pos)=='g'){
                        pos+=1;
                        if(statement.charAt(pos)=='e'){
                            pos+=1;
                            if(statement.charAt(pos)=='r'){
                                pos+=1;
                                if(whitespace(statement.charAt(pos))){
                                    pos+=1;
                                    intl2(statement,pos);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void intl2(String statement, int pos){
         int counter = pos;
        // Checks integer data type
        System.out.println(statement);
        String name = "";
        char temp = ' ';
        if(!letter(statement.charAt(counter))) 
             ErrorStartWithLetter();
        
        
        while(statement.charAt(counter) != '=' ){
            temp = statement.charAt(counter);
           
            
            if(letter(temp) || digit(temp))
                name += temp;
            else
                break;
            
            counter++;
        }
        System.out.println(statement.charAt(counter));
        if(statement.charAt(counter) == '='){
           intl3(statement,++counter,name);
        }else{
                WrongSyntaxError();
        }
        
        
    }
    
    public static void intl3(String statement,int pos,String varname){
        int counter = pos;
        // Checks comment string
        System.out.println(statement.charAt(pos));
        String name = "";
        char temp = ' ';
        while(statement.charAt(counter) != ';' ){
            temp = statement.charAt(counter);
            System.out.println(temp);
            if(digit(temp)){
                counter++;
                name += temp;
            }
            else{
                ErrorStartWithNumber();
                break;
            }
        }
        
        if(statement.charAt(counter) == ';'){
            finalint(name,varname);
        }else{
                WrongSyntaxError();
        }
        
            
        
    }
    
    public static void finalint(String statement,String varname){
        Token s = new Token(statement,varname);
        TokenStream.add(s);
        //FINISHED COMMENT!
    
    }
    public static void yield1(){
        
    }
    private static void ErrorStartWithLetter(){
        
        System.out.println("Variable Name Should Start with letter");
        S.close();
    }
    
    private static void ErrorStartWithNumber(){
        
        System.out.println("Integer data type must only contain numbers");
        S.close();
    }
    
    private static void WrongSyntaxError() {
        System.out.println("Wrong Syntax");
        S.close();
    }
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
       
       S = new Scanner(new BufferedReader(new FileReader("test.txt")));
        
        
        while(S.hasNext()){
            int counter = 0;
            String statement = S.nextLine();
            
            switch (statement.charAt(counter)) {
                case '/': // this starts off the comment path
                    com1(statement,counter+1);
                    break;
                case 'I': // this starts off the integer path
                    int1(statement,counter+1);
                    break;
                case 'y': // this starts off the integer path
                    yield1();
                    break;
                default:
                    break;
            }
           
           
        }
        
        
        
        
        System.out.println("LIST OF TOKENS: ");
        for(Token T: TokenStream){
            System.out.print("< "+T.getName()+" , "+T.getPurpose()+" >\n");
        }
        
        
        
    }

    
    
    
   
}
