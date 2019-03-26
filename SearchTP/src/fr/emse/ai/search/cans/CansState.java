package fr.emse.ai.search.cans;

/**
 * Classe qui gère les états du problème des récipients
 */
public class CansState {

    public String value;

    public CansState(String value){this.value = value;}

    public boolean equals(Object o){
        if (o instanceof CansState){
            return ((CansState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString(){return value;}
}
