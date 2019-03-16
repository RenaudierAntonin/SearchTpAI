package fr.emse.ai.search.cans;

import fr.emse.ai.search.solver.BreadthFirstTreeSearch;

public class CansTest {
    public static void main(String[] args){
        CansOrientedGraphProblem p1 = new CansOrientedGraphProblem(15,5);
        System.out.println("Solution to problem using breadth first");
        System.out.println(new BreadthFirstTreeSearch().solve(p1).pathToString());
    }

}
