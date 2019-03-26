package fr.emse.ai.search.cans;
import fr.emse.ai.search.core.Problem;
import fr.emse.ai.search.farmer.FarmerState;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe qui représente le problème des récipients et de l'eau
 */
public class CansNonOrientedGraphProblem implements Problem{

    /**
     * Création de l'état initial et final du problème
     * Un état est représenté par un String qui contient 2 valeurs séparées par un espace
     * Chaque valeur représente le volume contenu dans le récipient A ou B
     */
    private CansState initialState = new CansState("12 3");
    private CansState finalState = new CansState("0 5");

    /**
     * Entier représentant respectivement les volumes maximums des récipients A ou B
     */
    private Integer volumeB;
    private Integer volumeA;

    /**
     * Constructeur de la classe
     * @param volumeA Volume maximal contenu dans le récipient A
     * @param volumeB Volume maximal contenu dans le récipient B
     */
    // constructor that initiate volumes
    public CansNonOrientedGraphProblem(Integer volumeA, Integer volumeB){
        this.volumeA = volumeA;
        this.volumeB = volumeB;
    }

    /**
     * Fonction qui permet de récupérer l'état initial du problème
     * @return Retourne l'état initial du problème
     */
    @Override
    public Object getInitialState() {
        return initialState;
    }

    /**
     * Fonction qui permet de savoir si notre état est l'état final
     * @param state Un état quelconque du problème
     * @return Retourne True si on est à l'état final, False sinon
     */
    @Override
    public boolean isGoal(Object state) {
        return state.equals(finalState);
    }

    /**
     * Fonction qui permet d'obtenir la liste des actions possibles depuis un état
     * @param state Un état quelconque du problème
     * @return Retourne une liste contenant les différents états possibles depuis l'état donné
     */
    @Override
    public Collection<Object> getActions(Object state) {
        String s = ((CansState) state).value;
        ArrayList<String> availableActions = getAvaibleActions(s);
        return new ArrayList<>(availableActions);
    }


    /**
     * Fonction qui permet de créer une liste d'état accessible depuis un état donné en fonction du problème
     * @param state Un état quelconque du problème
     * @return Retourne la liste des états accessibles depuis un état donné en fonction du problème
     */
    private ArrayList<String> getAvaibleActions(String state) {
        String[] splitState = state.split(" ");
        ArrayList<String> availableActions = new ArrayList<>();
        Integer canA = Integer.parseInt(splitState[0]);
        Integer canB = Integer.parseInt(splitState[1]);

        // On ajoute les deux actions ou on vide A ou B
        String emptyACanAction = "0 " +splitState[1];
        String emptyBcanAction = splitState[0] + " 0";
        availableActions.add(emptyACanAction);
        availableActions.add(emptyBcanAction);

        //On vérifie qu'on a pas déjà le volume maximal dans A et que B n'est pas vide
        if(canA != this.volumeA && canB != 0){
            if( canA + canB <=this.volumeA){
                // On vide B dans A
                String action1 = Integer.toString(canA+canB);
                action1 = action1 + " 0";
                availableActions.add(action1);
            }
            if (canA + canB >this.volumeA){
                // On remplit A au maximum et on garde le reste dans B
                String action2 = "15 ";
                action2 = action2 + Integer.toString(canB - (15-canA));
                availableActions.add(action2);
            }
        }

        //On vérifie que B n'est pas plein et que A n'est pas vide
        if(canB != this.volumeB && canA != 0){
            if( canA + canB <=this.volumeB){
                // On vide A dans B
                String action3 = Integer.toString(canA+canB);
                action3 = "0 " + action3;
                availableActions.add(action3);
            }
            if (canA + canB >this.volumeB){
                // On remplit B au maximum et on laisse le reste dans A
                String action4 = Integer.toString(canA - (5-canB));
                action4 = action4 + " 5";
                availableActions.add(action4);

            }
        }
        return availableActions;
    }


    /**
     * Fonction qui permet de créer un état à partir d'une action
     * @param state Paramètre qui représente l'état actuel
     * @param action Représente une action, c'est à dire un String
     * @return Renvoi l'état qui correspond à l'action
     */
    @Override
    public Object getNextState(Object state, Object action) {

        return new CansState((String) action);
    }

    /**
     * Fonction qui permet de calculer le cout d'un noeud
     * @param start Etat inital
     * @param action Etat en cours
     * @param dest Etat final
     * @return Retourne la valeur du cout
     */
    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

    /**
     * Fonction qui permet de calculer l'heuristique d'un noeud
     * @param node Noeud actuel
     * @return Retourne la valeur de l'heuristique
     */
    @Override
    public double heuristicCalcul(Object node) {
        return 0;
    }
}
