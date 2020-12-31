package com.futoshiki.gui;

import java.io.Serializable;
import java.util.HashSet;

/*
 * Classe pour repr�senter un carr� dans le numGrid du puzzle. 
 * Cette classe vous permet de stocker le num�ro que vous pensez 
 * qu'il s'agit et les num�ros que vous ne pensez pas pouvoir �tre.
 * */

public class Square implements Serializable {

	private static final long serialVersionUID = 1L;
	private int row;
    private int col;
    private int number;
    private HashSet<Integer> notNumber;
    private boolean initialSquare = false;

    /**
     * @param row the row you want the square to be.
     * @param col the column you want the square to be.
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        number = 0;
        notNumber = new HashSet<>();
    }

    /**
     * Returns the row of the square.
     *
     * @return row of the square.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns column of the square.
     *
     * @return column of the square
     */
    public int getCol() {
        return col;
    }

    /**
     * Sets the number of the grid.
     *
     * @param num the number you want the square to represent.
     */
    public void setNumber(int num) {
        this.number = num;
    }

    /**
     * Gets the number of the grid.
     *
     * @return the number stored in number.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the numbers the user thinks the square can not contain.
     *
     * @param notNum the numbers that the square can't be.
     */
    public void setNotNumber(int notNum) {
        notNumber.add(notNum);
    }
    
    /**
     * Gets if it is a initial square.
     * @return intialSquare.
     */
    public boolean getInitial () {
        return initialSquare ;
    }
    
    
    /**
     * Sets if it is a initial square, whether i is setup on creation of the grid.
     */
    public void setInitial () {
        initialSquare = true;
    }

    /**
     * removes a number that the user no longer thinks the square can not be.
     *
     * @param canBe the number you want to remove from notNumbers.
     */
    public void removeNotNumber(int canBe) {
        try {
            notNumber.remove(canBe);
        } catch (Exception e) {
            System.err.println(canBe + " is not in the list");
        }
    }

    /**
     * The numbers that the user thinks the square can not be.
     *
     * @return the numbers the user thinks the square can not be.
     */
    public HashSet<Integer> getNotNumber() {
        return notNumber;
    }

}
