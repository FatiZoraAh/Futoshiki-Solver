package com.futoshiki.gui;



public class GreaterThan extends Constraint{
	public GreaterThan(Square square1, Square square2) {
        super(square1, square2);
    }
	 public boolean isCorrect() {
	        if ((isRowConstraint() || isColConstraint()) && square1.getNumber() != 0 && square2.getNumber() != 0) {
	            return square1.getNumber() > square2.getNumber();
	        } else {
	            return true;
	        }
	    }
	 public String constraint() {
	        if (isRowConstraint()) {
	            return ">";
	        } else if (isColConstraint()) {
	            return "V";
	        } else {
	            return " ";
	        }
	    }
	 public String stringRep() {
	        return "greater than";
	    }


}
