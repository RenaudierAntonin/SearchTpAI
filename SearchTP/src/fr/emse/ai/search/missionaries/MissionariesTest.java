package fr.emse.ai.search.missionaries;

import fr.emse.ai.search.solver.BreadthFirstGraphSearch;
import fr.emse.ai.search.solver.DepthFirstGraphSearch;

/**
 * Classe qui permet de tester la résolution du problème des missionaires
 */
public class MissionariesTest {

    public static void main(String[] args) {
        MissionariesNonOrientedGraphProblem p1 = new MissionariesNonOrientedGraphProblem();
        System.out.println("Solution to problem using depth first : ");
        System.out.println(new DepthFirstGraphSearch().solve(p1).pathToString());
    }
}
