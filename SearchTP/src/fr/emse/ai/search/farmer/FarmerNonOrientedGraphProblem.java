package fr.emse.ai.search.farmer;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe qui représente le problème du fermier
 */
public class FarmerNonOrientedGraphProblem implements Problem {

    /**
     * On va définir un état comme un String de la forme "W X Y Z" on chaque variable peut prendre 2 valeurs(L:Left et R:Right)
     * W représente la position du loup
     * X représente la position de la chèvre
     * Y représente la position du chou
     * Z représente la position du bateau
     */
    private FarmerState initialState = new FarmerState("L L L L");
    private FarmerState finalState = new FarmerState("R R R R");

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
        String s = ((FarmerState) state).value;
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
        String boatPosition = splitState[3];
        int numberIndex = splitState.length;
        if (boatPosition.equals("R")) {
            getAllMove(availableActions,splitState,boatPosition,"L", 3,numberIndex);
        }
        else {
            getAllMove(availableActions,splitState,boatPosition,"R",3,numberIndex);
        }
        return availableActions;
    }

    /**
     * Fonction qui permet de récupérer tous les états possibles depuis un état initial
     * Sans chercher à savoir si il respecte les règles du jeu
     * @param availableActions Liste de string qu'on va remplir
     * @param splitState Etat actuel après l'avoir split par les espaces
     * @param boatPosition Position du bateau
     * @param newBoatPosition Position à laquelle va le bateau
     * @param boatIndex Indice du bateau dans le String[]
     * @param numberIndex Taille du String[]
     */
    private void getAllMove(ArrayList<String> availableActions, String[] splitState, String boatPosition, String newBoatPosition, int boatIndex, int numberIndex) {
        for (int i= 0; i<numberIndex;i++) {
            // On essaye chaque entité représentée dans le problème
            if(splitState[i].equals(boatPosition)) {
                //On déplace seulement celle qui sont du côté du bateau
                String[] action = splitState.clone();
                //On fait les déplacements
                move(action,i,newBoatPosition,boatIndex);
                //On vérifie si l'état est valide
                if (isOk(action)) {
                    //On ajoute l'état si c'est le cas
                    availableActions.add(combine(action));
                }
            }
        }
        //Cas ou on déplace le bateau à vide
        String[] action = splitState.clone();
        move(action,3,newBoatPosition,boatIndex);
        if (isOk(action)) {
            availableActions.add(combine(action));
        }
    }

    /**
     * Fonction qui permet de changer la position d'une entité et du bateau
     * @param action Etat inital sous la forme d'un String[]
     * @param position Position de l'entité à déplacer
     * @param side Côté ou on va
     * @param boatPosition Position du bateau
     */
    private void move(String[] action, int position, String side, int boatPosition) {
        action[position] = side;
        action[boatPosition] = side;
    }

    /**
     * Fonction qui permet de passer d'un String[] à un String
     * @param action String[] à transformer
     * @return Retourne le String correspondant
     */
    private String combine(String[] action) {
        String str = "";
        for (int i = 0; i < 3;i++) {
            str += action[i] + " ";
            //On va faire le String correspondant et respectant la syntaxe choisie
        }
        str += action[3];
        return str;
    }

    /**
     * Fonction qui permet de savoir si notre état respecte les règles
     * @param action Etat à tester sous la forme d'un String[]
     * @return Retourne True si l'état est valide sinon False
     */
    private boolean isOk(String[] action) {
        //On vérifie si le loup est la chevre sont du même côté
        boolean wolfGoat = action[0].equals(action[1]);
        //On vérifie si la chevre est avec le chou
        boolean goatCab = action[1].equals(action[2]);
        //On vérifie si le bateau est du même côté que les entités qui peuvent se manger
        boolean boatOk = action[1].equals(action[3]);
        //On vérifie si l'état est valide
        //C'est à dire si le loup ne mange pas la chevre ou que la chevre ne manque pas le chou pendant un trajet
        return !(wolfGoat || goatCab) || boatOk;
    }

    /**
     * Fonction qui permet de créer un état à partir d'une action
     * @param state Paramètre qui représente l'état actuel
     * @param action Représente une action, c'est à dire un String
     * @return Renvoi l'état qui correspond à l'action
     */
    @Override
    public Object getNextState(Object state, Object action) {
        return new FarmerState((String) action);
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
