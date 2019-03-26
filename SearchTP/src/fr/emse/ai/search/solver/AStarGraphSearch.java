package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractAStarSearch;
import fr.emse.ai.search.core.HeuristicComparator;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Classe qui implémente un parcours A* dans un graphe
 */
public class AStarGraphSearch extends AbstractAStarSearch {

    /**
     * Comparateur pour le queue de priorité
     */
    public HeuristicComparator comparator= new HeuristicComparator();

    /**
     * Fonction qui initialise la frontière
     * @return Retourne la frontière, c'est une queue de priorité triée par ordre croissant en fonction de l'heuristique
     */
    public Collection<Node> initFrontier() {
        return new PriorityQueue<Node>(100,comparator);
    }

    /**
     * Fonction qui retourne le premier élément de la frontière
     * @param frontier Liste des noeuds à visiter
     * @param problem Problème
     * @return Retourne le prochain noeud à visiter
     */
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((PriorityQueue<Node>) frontier).remove();
    }
}
