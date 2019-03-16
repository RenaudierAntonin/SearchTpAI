package fr.emse.ai.search.missionaries;

import fr.emse.ai.search.solver.BreadthFirstGraphSearch;

public class MissionariesTest {

    public static void main(String[] args) {
        MissionariesNonOrientedGraphProblem p1 = new MissionariesNonOrientedGraphProblem();
        System.out.println("Solution to problem using breadth first : ");
        System.out.println(new BreadthFirstGraphSearch().solve(p1).pathToString());
    }
}
