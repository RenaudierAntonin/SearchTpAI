package fr.emse.ai.search.missionaries;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe qui représente le problème des missionnaires
 */
public class MissionariesNonOrientedGraphProblem implements Problem {

    /**
     * On va définir un état comme un String de la forme "i j X"
     * i représente le nombre de missionaire sur le rive droite, il est compris entre 0 et 3
     * j représente le nombre de cannibale sur la rive droite,il est compris entre 0 et 3
     * X représente la position du bateau, c'est L ou R
     * La connaisance de l'état sur la rive droite permet de connaitre celui de la rive gauche
     */
    private MissionariesState initialState = new MissionariesState("3 3 L");
    private MissionariesState finalState = new MissionariesState("0 0 R");

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
        String s = ((MissionariesState) state).value;
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
        String boatPosition = splitState[2];
        int numberIndex = splitState.length;
        if (boatPosition.equals("R")) {
            getAllMove(availableActions,splitState,1,"L", 2,numberIndex);
        }
        else {
            getAllMove(availableActions,splitState,-1,"R",2,numberIndex);
        }
        return availableActions;
    }

    /**
     * Fonction qui permet de récupérer tous les états possibles depuis un état initial
     * Sans chercher à savoir si il respecte les règles du jeu
     * @param availableActions Liste de String qu'on va remplir
     * @param splitState Etat actuel sous la forme d'un String[]
     * @param moreLess Permet de savoir si on ajoute ou retire des missionnaires
     * @param newBoatPosition Position à laquelle va le bateau
     * @param boatIndex Indice du bateau dans le String[]
     * @param numberIndex Taille du String[]
     */
    private void getAllMove(ArrayList<String> availableActions, String[] splitState, int moreLess, String newBoatPosition, int boatIndex, int numberIndex) {
        for (int position = 0; position<numberIndex-1;position++) {
            //On va essayer de bouger chaque entité du problème
            for (int number = 1; number<3; number++) {
                //On déplace soit 1 soit 2 personnes
                String[] action = splitState.clone();
                //On réalise les déplacements
                move(action,position,newBoatPosition,boatIndex,number,moreLess);
                //On vérifie si l'état est valide
                if (isOk(action)) {
                    //On ajoute l'état dans la liste si c'est le cas
                    availableActions.add(combine(action));
                }
            }
        }
        //Cas ou on déplace un missionaire et un cannibale
        String[] action = splitState.clone();
        action[0] = String.valueOf(Integer.parseInt(action[0]) + moreLess);
        action[1] = String.valueOf(Integer.parseInt(action[1]) + moreLess);
        action[boatIndex] = newBoatPosition;
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
     * @param number Nombre de personne à bouger
     * @param moreLess Permet de savoir si on ajoute ou retire ces personnes
     */
    private void move(String[] action, int position, String side, int boatPosition, int number, int moreLess) {
        action[position] = String.valueOf(Integer.parseInt(action[position]) + moreLess*number);
        action[boatPosition] = side;
    }

    /**
     * Fonction qui permet de passer d'un String[] à un String
     * @param action String[] à transformer
     * @return Retourne le String correspondant
     */
    private String combine(String[] action) {
        String str = "";
        for (int i = 0; i < 2;i++) {
            str += action[i] + " ";
        }
        str += action[2];
        return str;
    }

    /**
     * Fonction qui permet de savoir si notre état respecte les règles
     * @param action Etat à tester sous la forme d'un String[]
     * @return Retourne True si l'état est valide sinon False
     */
    private boolean isOk(String[] action) {
        //Nombre de missionnaires sur la rive droite
        int missionariesNumber = Integer.parseInt(action[0]);
        //Nombre de cannibale sur la rive droite
        int cannibalsNumber = Integer.parseInt(action[1]);
        //On vérifie qu'on a entre 0 et 3 missionaires
        boolean isMissionariesInRange = ( 0<= missionariesNumber) && (missionariesNumber <= 3);
        //On vérifie qy'ib a entre 0 et 3 cannibales
        boolean isCannibalsinRange = (0<=cannibalsNumber)&&(cannibalsNumber<=3);
        //On vérifie qu'on a autant de missionnaires que de cannibales
        boolean equaliy = (missionariesNumber == cannibalsNumber);
        //On vérifie si on a 0 missionaire
        boolean noMissionaries = (missionariesNumber == 0);
        //On vérife si on a 3 cannibales
        boolean allMissionaries = (missionariesNumber == 3);
        //On vérifie que les cannibales ne sont pas capables de manger les missionaires
        return (equaliy || noMissionaries || allMissionaries)&&(isMissionariesInRange&&isCannibalsinRange);
    }

    /**
     * Fonction qui permet de créer un état à partir d'une action
     * @param state Paramètre qui représente l'état actuel
     * @param action Représente une action, c'est à dire un String
     * @return Renvoi l'état qui correspond à l'action
     */
    @Override
    public Object getNextState(Object state, Object action) {
        return new MissionariesState((String) action);
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
