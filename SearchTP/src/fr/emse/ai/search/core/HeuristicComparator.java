package fr.emse.ai.search.core;

import java.util.Comparator;

/**
 * Classe qui implémente l'interface Comparator
 */
public class HeuristicComparator implements Comparator {

    /**
     * Fonction qui permet de comparer deux noeud en fonction de leur heuristique
     * @param o1 Noeud 1
     * @param o2 Noeud 2
     * @return Retourne 1 si 1 est plus grand que 2, 0 si 1 égal 2 et -1 sinon
     */
    public int compare(Object o1, Object o2) {
        double h1 = ((Node) o1).getHeuristic();
        double h2 = ((Node) o2).getHeuristic();
        if (h1<h2) {
            return -1;
        }
        else if (h1==h2) {
            return 0;
        }
        else {
            return 1;
        }
    }
}
