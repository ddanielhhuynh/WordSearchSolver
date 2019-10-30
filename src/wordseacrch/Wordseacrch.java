/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordseacrch;
import java.util.Arrays;

import java.util.*;

/**
 *
 * @author SJHS-DHuynh
 */
public class Wordseacrch {
	/**
 	* @param args the command line arguments
 	*/
	boolean ifDone = false;
	boolean result = false;
	public char [][]board = {{'a','b','c','d','e'},
                        	{'3','2','1','f','g'},
                                {'h','i','j','k','l'},
                                {'m', 'a', 'x', 'z','r'}};
	int columnLength = board[0].length;
	String word = "max";
  	int row = 0, column = 0;
        String firstLetter = "";
        String lastLetter = "";
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        int r = 0, c = 0;
        
        
        //Main Method
	public static void main(String[] args){
            Wordseacrch programm = new Wordseacrch();
            programm.perform();
            
	}
        
        
        //System out prints that tries to get the location of the word
	public void perform(){
     	reset();
        
  	exist(board, word);
        
        replace(result);
       
        
        System.out.println("Row " + r);
        System.out.println("Column " + c);
        
  	System.out.println(result);
        
	}
        
	public boolean exist(char[][] board, String word) {
	int m = board.length;
	int n = board[0].length;
	
	for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board,word,i,j,0)){
                        result = true;
                        list.add(i);
                        list2.add(j);
                }
            }
	}
 
	return result;
}
 
	public boolean dfs(char[][] board, String word, int i, int j, int k){
    	int m = board.length;
    	int n = board[0].length;
    	if(i<0 || j<0 || i>=m || j>=n){
        	return false;
    	}
    	if(board[i][j] == word.charAt(k)){
        	char temp = board[i][j];
        	board[i][j]='#';
        	if(k==word.length()-1){
            	return true;
        	}else if(dfs(board, word, i-1, j, k+1)
                       // ||dfs(board, word, i)
                        ||dfs(board, word, i+1, j, k+1)
                        ||dfs(board, word, i, j-1, k+1)
                        ||dfs(board, word, i, j+1, k+1)){

                    return true;
        	}
        	board[i][j]=temp;
                
            }
    	return false;
}
	
	public void reset(){
	do{
            do{
            for(column = 0; column < columnLength; column++){
                    System.out.print("\t" + board[row][column]);
            }
            }while(column!=columnLength);
            System.out.println();
            column = 0;
            row++;
            if(row == 3){
            row = 0;
            column = columnLength;
            ifDone = true;
                    }
    	}while(ifDone != true);
	}
        
        public void replace(boolean foo){
            if(foo == true){
                firstLetter = word.substring(0,1);
                lastLetter = word.substring(word.length()-1, word.length());
            }
        }
}


