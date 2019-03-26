package fr.emse.ai.search.maze;

import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe qui représente le problème d'un robot dans un labyrinthe
 * Permet de teste A*
 */
public class MazeNonOrientedGraph implements Problem {

    /**
     * On définit un état comme un String de la forme "x y"
     * Ou x et y représentent la position du robot
     */
    private MazeState initialState = new MazeState("1 1");
    private MazeState finalState = new MazeState("1 5");

    /**
     * Taille du labyrinthe
     */
    private int length = 5;

    /**
     * Fonction qui permet de récupérer l'état initial du problème
     * @return Retourne l'état initial du problème
     */
    @Override
    public Object getInitialState() {return initialState;}

    /**
     * Fonction qui permet de savoir si notre état est l'état final
     * @param state Un état quelconque du problème
     * @return Retourne True si on est à l'état final, False sinon
     */
    @Override
    public boolean isGoal(Object state) { return  state.equals(finalState);}

    /**
     * Fonction qui permet d'obtenir la liste des actions possibles depuis un état
     * @param state Un état quelconque du problème
     * @return Retourne une liste contenant les différents états possibles depuis l'état donné
     */
    @Override
    public Collection<Object> getActions(Object state) {
        String s = ((MazeState) state).value;
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
        getAllMove(availableActions,splitState);
        return availableActions;
    }

    /**
     * Fonction qui permet de récupérer tous les états possibles depuis un état initial
     * Sans chercher à savoir si il respecte les règles du jeu
     * @param availableActions Liste de string qu'on va remplir
     * @param splitState Etat actuel après l'avoir split par les espaces
     */
    private void getAllMove(ArrayList<String> availableActions, String[] splitState) {
        int x = Integer.parseInt(splitState[0]);
        int y = Integer.parseInt(splitState[1]);
        //On peut se déplacer en diagonale
        for (int i = -1;i<2;i++) {
            //On déplace le robot selon x
            for (int j = -1;j<2;j++) {
                //On déplace le robot selon y
                String new_x = String.valueOf(x + i);
                String new_y = String.valueOf(y + j);
                String new_state = new_x +" "+new_y;
                //On vérifie si l'état est valide
                if (isOk(new_state) &&  !(i==0 && j==0)) {
                    availableActions.add(new_state);
                }
            }
        }
    }

    /**
     * Fonction qui permet de savoir si notre état respecte les règles
     * @param state Etat à tester sous la forme d'un String
     * @return Retourne True si l'état est valide sinon False
     */
    private boolean isOk(String state) {
        String[] splitState = state.split(" ");
        int x = Integer.parseInt(splitState[0]);
        int y = Integer.parseInt(splitState[1]);
        //On vérifie que le robot n'est pas en dehors du labyrinthe
        boolean inRange = (0<x) && (x<=length) && (0<y) && (y<=length);
        //On crée la liste des murs
        ArrayList<String> wall = new ArrayList<>();
        wall.add("1 4");
        wall.add("2 4");
        wall.add("3 4");
        wall.add("4 4");
        wall.add("4 3");
        //On vérifie que le robot n'est pas dans un mur
        boolean isNotWall = !(wall.contains(state));
        return isNotWall && inRange;
    }

    /**
     * Fonction qui permet de créer un état à partir d'une action
     * @param state Paramètre qui représente l'état actuel
     * @param action Représente une action, c'est à dire un String
     * @return Renvoi l'état qui correspond à l'action
     */
    @Override
    public Object getNextState(Object state, Object action) {
        return new MazeState((String) action);
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
        String state = ((MazeState) node).value;
        String[] splitState = state.split(" ");
        int x = Integer.parseInt(splitState[0]);
        int y = Integer.parseInt(splitState[1]);
        String[] splitStateFinal = finalState.value.split(" ");
        int xFinal = Integer.parseInt(splitStateFinal[0]);
        int yFinal = Integer.parseInt(splitStateFinal[1]);
        //On prend le max de l'écart selon x et y
        //Cela revient à prendre la distance à vol d'oiseau
        return Math.max(Math.abs(xFinal-x),Math.abs(yFinal-y));
    }
}
