package fr.emse.ai.search.missionaries;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class MissionariesNonOrientedGraphProblem implements Problem {

    MissionariesState initialState = new MissionariesState(MissionariesState.TTL);
    MissionariesState finalState = new MissionariesState(MissionariesState.ZZR);

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
        if (action.equals("0 0 L")) return new MissionariesState(MissionariesState.ZZL);
        if (action.equals("1 1 L")) return new MissionariesState(MissionariesState.UUL);
        if (action.equals("2 2 L")) return new MissionariesState(MissionariesState.DDL);
        if (action.equals("3 3 L")) return new MissionariesState(MissionariesState.TTL);
        if (action.equals("1 0 L")) return new MissionariesState(MissionariesState.UZL);
        if (action.equals("2 0 L")) return new MissionariesState(MissionariesState.DZL);
        if (action.equals("3 0 L")) return new MissionariesState(MissionariesState.TZL);
        if (action.equals("1 2 L")) return new MissionariesState(MissionariesState.UDL);
        if (action.equals("1 3 L")) return new MissionariesState(MissionariesState.UTL);
        if (action.equals("2 1 L")) return new MissionariesState(MissionariesState.DUL);
        if (action.equals("2 3 L")) return new MissionariesState(MissionariesState.DTL);
        if (action.equals("3 1 L")) return new MissionariesState(MissionariesState.TUL);
        if (action.equals("3 2 L")) return new MissionariesState(MissionariesState.TDL);
        if (action.equals("0 1 L")) return new MissionariesState(MissionariesState.ZUL);
        if (action.equals("0 2 L")) return new MissionariesState(MissionariesState.ZDL);
        if (action.equals("0 3 L")) return new MissionariesState(MissionariesState.ZTL);
        if (action.equals("0 0 R")) return new MissionariesState(MissionariesState.ZZR);
        if (action.equals("1 1 R")) return new MissionariesState(MissionariesState.UUR);
        if (action.equals("2 2 R")) return new MissionariesState(MissionariesState.DDR);
        if (action.equals("3 3 R")) return new MissionariesState(MissionariesState.TTR);
        if (action.equals("1 0 R")) return new MissionariesState(MissionariesState.UZR);
        if (action.equals("2 0 R")) return new MissionariesState(MissionariesState.DZR);
        if (action.equals("3 0 R")) return new MissionariesState(MissionariesState.TZR);
        if (action.equals("1 2 R")) return new MissionariesState(MissionariesState.UDR);
        if (action.equals("1 3 R")) return new MissionariesState(MissionariesState.UTR);
        if (action.equals("2 1 R")) return new MissionariesState(MissionariesState.DUR);
        if (action.equals("2 3 R")) return new MissionariesState(MissionariesState.DTR);
        if (action.equals("3 1 R")) return new MissionariesState(MissionariesState.TUR);
        if (action.equals("3 2 R")) return new MissionariesState(MissionariesState.TDR);
        if (action.equals("0 1 R")) return new MissionariesState(MissionariesState.ZUR);
        if (action.equals("0 2 R")) return new MissionariesState(MissionariesState.ZDR);
        if (action.equals("0 3 R")) return new MissionariesState(MissionariesState.ZTR);
        return null;
    }
    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

}
