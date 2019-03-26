package fr.emse.ai.search.core;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe abstraite qui implémente un parcours A* dans un graph
 */
public abstract class AbstractAStarSearch implements Search{

    /**
     * Collection des noeuds à visiter
     */
    private Collection<Node> frontier;

    /**
     * Fonction qui va résoudre le problème
     * @param problem Problème à résoudre
     * @return Retourne la solution au problème
     */
    public  Node solve(Problem problem) {
        // Initialisation de la frontière
        System.out.println("Solving...");
        frontier = initFrontier();
        //On crée et on initialise un liste pour stocker les états déjà vu
        ArrayList<Object> AlreadySeen = new ArrayList<>();
        AlreadySeen.add(problem.getInitialState());
        frontier.addAll(expand(new Node(problem.getInitialState()), problem));
        System.out.println("Starting frontier is " + frontier);
        boolean done = false;
        Node solution = null;
        while (!done) {
            if (frontier.isEmpty()) {
                System.out.println("No more nodes in frontier => FAILURE");
                done = true;
            } else {
                Node node = chooseLeafNode(frontier, problem);
                //On vérifie qu'on a pas déjà vistié l'état
                if (!AlreadySeen.contains(node.getState())) {
                    System.out.println("Inspecting node " + node);
                    //On vérifie qu'on a pas trouvé la solution
                    if (problem.isGoal(node.getState())) {
                        System.out.println("Goal node reached => SUCCESS");
                        solution = node;
                        done = true;
                    } else {
                        frontier.addAll(expand(node, problem));
                        System.out.printf("Expanding node, frontier is " + frontier);
                    }
                    //On ajoute l'état à la liste des états déjà vu
                    AlreadySeen.add(node.getState());
                }
            }
        }
        return solution;
    }

    /**
     * Fonction qui pemet de trouver les prochains noeuds à visiter en fonction du problème
     * @param node Noeud actuel
     * @param problem Problème à résoudre
     * @return Retourne la collection  des noeuds à visiter
     */
    public Collection<Node> expand(Node node, Problem problem) {
        Collection<Node> nodes = new ArrayList<>();
        Collection<Object> actions = problem.getActions(node.getState());
        for (Object action : actions) {
            Object next = problem.getNextState(node.getState(), action);
            //On calcule l'heuristique d'un prochain noeud
            //La méthode de calcul est définie dans l'interface Problem
            double heuristic = problem.heuristicCalcul(next);
            //On crée le nouveau noeud avec toutes les informatiosn nécessaires
            //Cf la classe Node pour voir le nouveau constructeur
            nodes.add(new Node(next, node, action, problem.getStepCost(node.getState(), action, next),heuristic));
        }
        return nodes;
    }

    /**
     * Fonction qui initialise la frontière
     * @return Retourne la frontière
     */
    public abstract Collection<Node> initFrontier();

    /**
     * Fonction qui retourne le premier élément de la frontière
     * @param frontier Liste des noeuds à visiter
     * @param problem Problème
     * @return Retourne le prochain noeud à visiter
     */
    public abstract Node chooseLeafNode(Collection<Node> frontier, Problem problem);
}
