package fr.emse.ai.search.farmer;

/**
 * Classe qui gère les états du problème du fermier
 */
public class FarmerState {

    public String value;

    public FarmerState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof FarmerState) {
            return ((FarmerState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }
}
