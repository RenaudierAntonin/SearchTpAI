package fr.emse.ai.search.cans;

import fr.emse.ai.search.solver.DepthFirstGraphSearch;

/**
 * Classe qui permet de tester la résolution du problème des récipients
 */
public class CansTest {

    public static void main(String[] args){

        CansNonOrientedGraphProblem p1 = new CansNonOrientedGraphProblem(15,5);
        System.out.println("Solution to problem using depth first");
        System.out.println(new DepthFirstGraphSearch().solve(p1).pathToString());
    }

}
