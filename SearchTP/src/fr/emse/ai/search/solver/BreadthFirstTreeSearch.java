package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Classe qui implémente un parcours en largeur dans un arbre
 */
public class BreadthFirstTreeSearch extends AbstractTreeSearch {

    /**
     * Fonction qui initialise la frontière
     * @return Retourne la frontière, c'est une file FIFO
     */
    public Collection<Node> initFrontier() {
        return new LinkedList<Node>() ; }

    /**
     * Fonction qui retourne le premier élément de la frontière
     * @param frontier Liste des noeuds à visiter
     * @param problem Problème
     * @return Retourne le prochain noeud à visiter
     */
    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((LinkedList<Node>) frontier).poll(); }
}
