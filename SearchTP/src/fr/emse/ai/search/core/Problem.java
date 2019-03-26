package fr.emse.ai.search.core;

import java.util.Collection;

/**
 * Classe qui représente un problème quelconque
 */
public interface Problem {

    /**
     * Fonction qui permet de récupérer l'état initial du problème
     * @return Retourne l'état initial du problème
     */
    public Object getInitialState();

    /**
     * Fonction qui permet de savoir si notre état est l'état final
     * @param state Un état quelconque du problème
     * @return Retourne True si on est à l'état final, False sinon
     */
    public boolean isGoal(Object state);

    /**
     * Fonction qui permet d'obtenir la liste des actions possibles depuis un état
     * @param state Un état quelconque du problème
     * @return Retourne une liste contenant les différents états possibles depuis l'état donné
     */
    public Collection<Object> getActions(Object state);

    /**
     * Fonction qui permet de créer un état à partir d'une action
     * @param state Paramètre qui représente l'état actuel
     * @param action Représente une action, c'est à dire un String
     * @return Renvoi l'état qui correspond à l'action
     */
    public Object getNextState(Object state,Object action);

    /**
     * Fonction qui permet de calculer le cout d'un noeud
     * @param start Etat inital
     * @param action Etat en cours
     * @param dest Etat final
     * @return Retourne la valeur du cout
     */
    public double getStepCost(Object start, Object action, Object dest);

    /**
     * Fonction qui permet de calculer l'heuristique d'un noeud
     * @param node Noeud actuel
     * @return Retourne la valeur de l'heuristique
     */
    public double heuristicCalcul(Object node);

}
