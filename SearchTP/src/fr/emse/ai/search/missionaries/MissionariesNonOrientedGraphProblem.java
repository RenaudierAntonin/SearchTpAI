package fr.emse.ai.search.missionaries;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class MissionariesNonOrientedGraphProblem implements Problem {

    MissionariesState initialState = new MissionariesState("3 3 L");
    MissionariesState finalState = new MissionariesState("0 0 R");

    @Override
    public Object getInitialState() {
        return initialState;
    }

    @Override
    public boolean isGoal(Object state) {
        return state.equals(finalState);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        String s = ((MissionariesState) state).value;
        ArrayList<String> availableActions = getAvaibleActions(s);
        return new ArrayList<>(availableActions);
    }

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

    private void getAllMove(ArrayList<String> availableActions, String[] splitState, int moreLess, String newBoatPosition, int boatIndex, int numberIndex) {
        for (int position = 0; position<numberIndex-1;position++) {
            for (int number = 1; number<3; number++) {
                String[] action = splitState.clone();
                move(action,position,newBoatPosition,boatIndex,number,moreLess);
                if (isOk(action)) {
                    availableActions.add(combine(action));
                }
            }
        }
        String[] action = splitState.clone();
        action[0] = String.valueOf(Integer.parseInt(action[0]) + moreLess);
        action[1] = String.valueOf(Integer.parseInt(action[1]) + moreLess);
        action[boatIndex] = newBoatPosition;
        if (isOk(action)) {
            availableActions.add(combine(action));
        }
    }

    private void move(String[] action, int position, String side, int boatPosition, int number, int moreLess) {
        action[position] = String.valueOf(Integer.parseInt(action[position]) + moreLess*number);
        action[boatPosition] = side;
    }

    private String combine(String[] action) {
        String str = "";
        for (int i = 0; i < 2;i++) {
            str += action[i] + " ";
        }
        str += action[2];
        return str;
    }

    private boolean isOk(String[] action) {
        int missionariesNumber = Integer.parseInt(action[0]);
        int cannibalsNumber = Integer.parseInt(action[1]);
        boolean isMissionariesInRange = ( 0<= missionariesNumber) && (missionariesNumber <= 3);
        boolean isCannibalsinRange = (0<=cannibalsNumber)&&(cannibalsNumber<=3);
        boolean equaliy = (missionariesNumber == cannibalsNumber);
        boolean noMissionaries = (missionariesNumber == 0);
        boolean allMissionaries = (missionariesNumber == 3);
        return (equaliy || noMissionaries || allMissionaries)&&(isMissionariesInRange&&isCannibalsinRange);
    }

    @Override
    public Object getNextState(Object state, Object action) {
        return new MissionariesState((String) action);
    }
    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

}
