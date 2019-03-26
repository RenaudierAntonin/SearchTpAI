package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractGraphSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.Collection;
import java.util.Stack;

/**
 * Classe qui implémente un parcours en profondeur dans un graphe
 */
public class DepthFirstGraphSearch extends AbstractGraphSearch {

    /**
     * Fonction qui initialise la frontière
     * @return Retourne la frontière, c'est une pile LIFO
     */
    public Collection<Node> initFrontier() {
        return new Stack<Node>();
    }

    /**
     * Fonction qui retourne le premier élément de la frontière
     * @param frontier Liste des noeuds à visiter
     * @param problem Problème
     * @return Retourne le prochain noeud à visiter
     */
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((Stack<Node>) frontier).pop();
    }
}
