package com.futoshiki.gui;

import java.io.Serializable;
import java.util.HashSet;

/*
 * Classe pour repr�senter un carr� dans le numGrid du puzzle. 
 * Cette classe vous permet de stocker le num�ro que vous pensez 
 * qu'il s'agit .
 * */

public class Square implements Serializable {

	private static final long serialVersionUID = 1L;
	private int row;
    private int col;
    private int number;
   
    private boolean initialSquare = false;

   
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        number = 0;
       
    }

   
    public int getRow() {
        return row;
    }

   
    public int getCol() {
        return col;
    }

   //definit le numero de la grid 
    public void setNumber(int num) {
        this.number = num;
    }
    //le numero de la grid
    public int getNumber() {
        return number;
    }

   //obtient s'il s'agit d'un carree initial
    public boolean getInitial () {
        return initialSquare ;
    }
    
    
    
    public void setInitial () {
    	//D�finit s'il s'agit d'un carr� initial, si i est configur� lors de la cr�ation de la grille.
        initialSquare = true;
    }

   

}
