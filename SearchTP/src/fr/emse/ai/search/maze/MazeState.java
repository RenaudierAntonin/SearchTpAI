package fr.emse.ai.search.maze;

/**
 * Classe qui gère les états du problème du labyrinthe
 */
public class MazeState {

    public String value;

    public MazeState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof MazeState) {
            return ((MazeState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }
}
