package fr.emse.ai.search.farmer;

import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class FarmerNonOrientedGraphProblem implements Problem {

    FarmerState initialState = new FarmerState(FarmerState.LLLL);
    FarmerState finalState = new FarmerState(FarmerState.RRRR);

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
        String s = ((FarmerState) state).value;
        ArrayList<String> availableActions = getAvaibleActions(s);
        return new ArrayList<>(availableActions);
    }

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

    private void getAllMove(ArrayList<String> availableActions, String[] splitState, String boatPosition, String newBoatPosition, int boatIndex, int numberIndex) {
        for (int i= 0; i<numberIndex;i++) {
            if(splitState[i].equals(boatPosition)) {
                String[] action = splitState.clone();
                move(action,i,newBoatPosition,boatIndex);
                if (isOk(action)) {
                    availableActions.add(combine(action));
                }
            }
        }
        String[] action = splitState.clone();
        move(action,3,newBoatPosition,boatIndex);
        if (isOk(action)) {
            availableActions.add(combine(action));
        }
    }

    private void move(String[] action, int position, String side, int boatPosition) {
        action[position] = side;
        action[boatPosition] = side;
    }

    private String combine(String[] action) {
        String str = "";
        for (int i = 0; i < 3;i++) {
            str += action[i] + " ";
        }
        str += action[3];
        return str;
    }

    private boolean isOk(String[] action) {
        boolean wolfGoat = action[0].equals(action[1]);
        boolean goatCab = action[1].equals(action[2]);
        boolean boatOk = action[1].equals(action[3]);
        return !(wolfGoat || goatCab) || boatOk;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        if (action.equals("L L L L")) return new FarmerState(FarmerState.LLLL);
        if (action.equals("L L R L")) return new FarmerState(FarmerState.LLRL);
        if (action.equals("L R L L")) return new FarmerState(FarmerState.LRLL);
        if (action.equals("R L L L")) return new FarmerState(FarmerState.RLLL);
        if (action.equals("R R L L")) return new FarmerState(FarmerState.RRLL);
        if (action.equals("R L R L")) return new FarmerState(FarmerState.RLRL);
        if (action.equals("L R R L")) return new FarmerState(FarmerState.LRRL);
        if (action.equals("R R R L")) return new FarmerState(FarmerState.RRRL);
        if (action.equals("L L L R")) return new FarmerState(FarmerState.LLLR);
        if (action.equals("L L R R")) return new FarmerState(FarmerState.LLRR);
        if (action.equals("L R L R")) return new FarmerState(FarmerState.LRLR);
        if (action.equals("R L L R")) return new FarmerState(FarmerState.RLLR);
        if (action.equals("R R L R")) return new FarmerState(FarmerState.RRLR);
        if (action.equals("R L R R")) return new FarmerState(FarmerState.RLRR);
        if (action.equals("L R R R")) return new FarmerState(FarmerState.LRRR);
        if (action.equals("R R R R")) return new FarmerState(FarmerState.RRRR);
        return null;
    }
    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }

}
