package com.futoshiki.gui;



public abstract class Constraint {

    /**
     * Allows you to store the futoshiki square you are using to later use for other methods
     */
    protected Square square1;

    /**
     * Allows you to store the futoshiki square you are using to later use for other methods
     */
    protected Square square2;
    private boolean rowConstraint;
    private boolean colConstraint;

    /**
     *Constructeur qui initialisera les champs. 
     *Il v�rifie �galement si vous cr�ez une contrainte de ligne 
     *ou de colonne.
     
     */
    public Constraint(Square first, Square second) {
    	//first:le premier carr� futoshiki de la contrainte
    	//second:le 2eme carr� futoshiki de la contrainte
        this.square1 = first;
        this.square2 = second;

        if ((first.getRow() == second.getRow()) && (second.getCol() == first.getCol()+1)) {
            rowConstraint = true;
        } else if ((second.getRow() == first.getRow()+1) && (first.getCol() == second.getCol())) {
            colConstraint = true;
        } else {
            rowConstraint = false;
            colConstraint = false;
        }
    }

    //Renvoie le rowConstraint pour la r�cup�ration du champ
    public boolean isRowConstraint() {
        return rowConstraint;
    }

    //Renvoie le colConstraint pour la r�cup�ration du champ
    public boolean isColConstraint() {
        return colConstraint;
    }

   //M�thode pour v�rifier que les carr�s de futoshiki r�pondent aux contraintes
    public abstract boolean isCorrect();
    
   //Renvoie le symbole de la contrainte qui a �t� affect�e.
    public abstract String constraint();

   //Renvoie une repr�sentation mot de la contrainte
    public abstract String stringRep();
}



