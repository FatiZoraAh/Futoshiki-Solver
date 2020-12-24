package com.futoshiki.gui;

import java.util.HashSet;

/*
 * Classe pour représenter un carré dans le numGrid du puzzle. 
 * Cette classe vous permet de stocker le numéro que vous pensez 
 * qu'il s'agit et les numéros que vous ne pensez pas pouvoir être.
 * */

public class Square {
	private int row;
    private int col;
    private int number;
    private HashSet<Integer> notNumber;
    private boolean initialSquare = false;
    
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        number = 0;
        notNumber = new HashSet<>();
    }
    public int getRow() {
        return row;
    }

    
    public int getCol() {
        return col;
    }

    
    public void setNumber(int num) {
        this.number = num;
    }

   
    public int getNumber() {
        return number;
    }

   
    public void setNotNumber(int notNum) {
        notNumber.add(notNum);
    }
    
   
    public boolean getInitial () {
        return initialSquare ;
    }
    
    
    
    public void setInitial () {
        initialSquare = true;
    }

   
    public void removeNotNumber(int canBe) {
        try {
            notNumber.remove(canBe);
        } catch (Exception e) {
            System.err.println(canBe + " is not in the list");
        }
    }

    
    public HashSet getNotNumber() {
        return notNumber;
    }

}
