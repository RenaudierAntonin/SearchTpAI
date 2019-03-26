package fr.emse.ai.search.maze;

import fr.emse.ai.search.solver.AStarGraphSearch;

/**
 * Classe qui permet de tester la résolution du problème du labyrinthe
 */
public class MazeTest {

    public static void main(String[] args) {
        MazeNonOrientedGraph p1 = new MazeNonOrientedGraph();
        System.out.println("Solution to problem using A star : ");
        System.out.println(new AStarGraphSearch().solve(p1).pathToString());
    }
}
