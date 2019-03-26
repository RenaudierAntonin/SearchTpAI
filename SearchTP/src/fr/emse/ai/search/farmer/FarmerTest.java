package fr.emse.ai.search.farmer;

import fr.emse.ai.search.solver.AStarGraphSearch;
import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;

/**
 * Classe qui permet de tester la résolution du problème du fermier
 */
public class FarmerTest {

    public static void main(String[] args) {
        FarmerNonOrientedGraphProblem p1 = new FarmerNonOrientedGraphProblem();
        System.out.println("Solution to problem using breadth first : ");
        System.out.println(new BreadthFirstGraphSearch().solve(p1).pathToString());
    }
}
