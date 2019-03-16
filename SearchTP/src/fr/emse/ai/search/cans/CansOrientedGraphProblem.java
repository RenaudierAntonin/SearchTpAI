package fr.emse.ai.search.cans;
import fr.emse.ai.search.core.Problem;
import fr.emse.ai.search.farmer.FarmerState;

import java.util.ArrayList;
import java.util.Collection;


public class CansOrientedGraphProblem implements Problem{

    CansState initialState = new CansState(CansState.A12B3);
    CansState finalState = new CansState(CansState.A10B5);

    // we add the volume of the two cans, then the problem is flexible
    Integer volumeB;
    Integer volumeA;

    // constructor that initiate volumes
    CansOrientedGraphProblem(Integer volumeA, Integer volumeB){
        this.volumeA = volumeA;
        this.volumeB = volumeB;
    }

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
        String s = ((CansState) state).value;
        ArrayList<String> availableActions = getAvaibleActions(s);
        return new ArrayList<>(availableActions);
    }


    private ArrayList<String> getAvaibleActions(String state) {
        String[] splitState = state.split(" ");
        ArrayList<String> availableActions = new ArrayList<>();
        Integer canA = Integer.parseInt(splitState[0]);
        Integer canB = Integer.parseInt(splitState[1]);

        // we add two action -> empty can A and empty can B
        String emptyACanAction = "0 " +splitState[1];
        String emptyBcanAction = splitState[0] + " 0";
        availableActions.add(emptyACanAction);
        availableActions.add(emptyBcanAction);

        if(canA != this.volumeA && canB != 0){
            if( canA + canB <=this.volumeA){
                // Action to empty B in A
                String action1 = Integer.toString(canA+canB);
                action1 = action1 + " 0";
                availableActions.add(action1);
            }
            if (canA + canB >this.volumeA){
                // Action of filling A to 15, but B is not empty
                String action2 = "15 ";
                action2 = action2 + Integer.toString(canB - (15-canA));
                availableActions.add(action2);
            }
        }

        if(canB != this.volumeB && canA != 0){
            if( canA + canB <=this.volumeB){
                // Action to empty A in B
                String action3 = Integer.toString(canA+canB);
                action3 = "0 " + action3;
                availableActions.add(action3);
            }
            if (canA + canB >this.volumeB){
                // Action of filling B to 5, but A is not empty
                String action4 = Integer.toString(canA - (5-canB));
                action4 = action4 + " 5";
                availableActions.add(action4);

            }
        }
        return availableActions;
    }


    @Override
    public Object getNextState(Object state, Object action) {

        if (action.equals("15 0")) return new CansState(CansState.A15B0);
        if (action.equals("15 1")) return new CansState(CansState.A15B1);
        if (action.equals("15 2")) return new CansState(CansState.A15B2);
        if (action.equals("15 3")) return new CansState(CansState.A15B3);
        if (action.equals("15 4")) return new CansState(CansState.A15B4);
        if (action.equals("15 5")) return new CansState(CansState.A15B5);

        if (action.equals("14 0")) return new CansState(CansState.A14B0);
        if (action.equals("14 1")) return new CansState(CansState.A14B1);
        if (action.equals("14 2")) return new CansState(CansState.A14B2);
        if (action.equals("14 3")) return new CansState(CansState.A14B3);
        if (action.equals("14 4")) return new CansState(CansState.A14B4);
        if (action.equals("14 5")) return new CansState(CansState.A14B5);

        if (action.equals("13 0")) return new CansState(CansState.A13B0);
        if (action.equals("13 1")) return new CansState(CansState.A13B1);
        if (action.equals("13 2")) return new CansState(CansState.A13B2);
        if (action.equals("13 3")) return new CansState(CansState.A13B3);
        if (action.equals("13 4")) return new CansState(CansState.A13B4);
        if (action.equals("13 5")) return new CansState(CansState.A13B5);

        if (action.equals("12 0")) return new CansState(CansState.A12B0);
        if (action.equals("12 1")) return new CansState(CansState.A12B1);
        if (action.equals("12 2")) return new CansState(CansState.A12B2);
        if (action.equals("12 3")) return new CansState(CansState.A12B3);
        if (action.equals("12 4")) return new CansState(CansState.A12B4);
        if (action.equals("12 5")) return new CansState(CansState.A12B5);

        if (action.equals("11 0")) return new CansState(CansState.A11B0);
        if (action.equals("11 1")) return new CansState(CansState.A11B1);
        if (action.equals("11 2")) return new CansState(CansState.A11B2);
        if (action.equals("11 3")) return new CansState(CansState.A11B3);
        if (action.equals("11 4")) return new CansState(CansState.A11B4);
        if (action.equals("11 5")) return new CansState(CansState.A11B5);

        if (action.equals("10 0")) return new CansState(CansState.A10B0);
        if (action.equals("10 1")) return new CansState(CansState.A10B1);
        if (action.equals("10 2")) return new CansState(CansState.A10B2);
        if (action.equals("10 3")) return new CansState(CansState.A10B3);
        if (action.equals("10 4")) return new CansState(CansState.A10B4);
        if (action.equals("10 5")) return new CansState(CansState.A10B5);

        if (action.equals("9 0")) return new CansState(CansState.A9B0);
        if (action.equals("9 1")) return new CansState(CansState.A9B1);
        if (action.equals("9 2")) return new CansState(CansState.A9B2);
        if (action.equals("9 3")) return new CansState(CansState.A9B3);
        if (action.equals("9 4")) return new CansState(CansState.A9B4);
        if (action.equals("9 5")) return new CansState(CansState.A9B5);

        if (action.equals("8 0")) return new CansState(CansState.A8B0);
        if (action.equals("8 1")) return new CansState(CansState.A8B1);
        if (action.equals("8 2")) return new CansState(CansState.A8B2);
        if (action.equals("8 3")) return new CansState(CansState.A8B3);
        if (action.equals("8 4")) return new CansState(CansState.A8B4);
        if (action.equals("8 5")) return new CansState(CansState.A8B5);

        if (action.equals("7 0")) return new CansState(CansState.A7B0);
        if (action.equals("7 1")) return new CansState(CansState.A7B1);
        if (action.equals("7 2")) return new CansState(CansState.A7B2);
        if (action.equals("7 3")) return new CansState(CansState.A7B3);
        if (action.equals("7 4")) return new CansState(CansState.A7B4);
        if (action.equals("7 5")) return new CansState(CansState.A7B5);

        if (action.equals("6 0")) return new CansState(CansState.A9B0);
        if (action.equals("6 1")) return new CansState(CansState.A6B1);
        if (action.equals("6 2")) return new CansState(CansState.A6B2);
        if (action.equals("6 3")) return new CansState(CansState.A6B3);
        if (action.equals("6 4")) return new CansState(CansState.A6B4);
        if (action.equals("6 5")) return new CansState(CansState.A6B5);

        if (action.equals("5 0")) return new CansState(CansState.A5B0);
        if (action.equals("5 1")) return new CansState(CansState.A5B1);
        if (action.equals("5 2")) return new CansState(CansState.A5B2);
        if (action.equals("5 3")) return new CansState(CansState.A5B3);
        if (action.equals("5 4")) return new CansState(CansState.A5B4);
        if (action.equals("5 5")) return new CansState(CansState.A5B5);

        if (action.equals("4 0")) return new CansState(CansState.A9B0);
        if (action.equals("4 1")) return new CansState(CansState.A9B1);
        if (action.equals("4 2")) return new CansState(CansState.A9B2);
        if (action.equals("4 3")) return new CansState(CansState.A9B3);
        if (action.equals("4 4")) return new CansState(CansState.A9B4);
        if (action.equals("4 5")) return new CansState(CansState.A9B5);

        if (action.equals("3 0")) return new CansState(CansState.A3B0);
        if (action.equals("3 1")) return new CansState(CansState.A3B1);
        if (action.equals("3 2")) return new CansState(CansState.A3B2);
        if (action.equals("3 3")) return new CansState(CansState.A3B3);
        if (action.equals("3 4")) return new CansState(CansState.A3B4);
        if (action.equals("3 5")) return new CansState(CansState.A3B5);

        if (action.equals("2 0")) return new CansState(CansState.A2B0);
        if (action.equals("2 1")) return new CansState(CansState.A2B1);
        if (action.equals("2 2")) return new CansState(CansState.A2B2);
        if (action.equals("2 3")) return new CansState(CansState.A2B3);
        if (action.equals("2 4")) return new CansState(CansState.A2B4);
        if (action.equals("2 5")) return new CansState(CansState.A2B5);

        if (action.equals("1 0")) return new CansState(CansState.A1B0);
        if (action.equals("1 1")) return new CansState(CansState.A1B1);
        if (action.equals("1 2")) return new CansState(CansState.A1B2);
        if (action.equals("1 3")) return new CansState(CansState.A1B3);
        if (action.equals("1 4")) return new CansState(CansState.A1B4);
        if (action.equals("1 5")) return new CansState(CansState.A1B5);

        if (action.equals("0 0")) return new CansState(CansState.A0B0);
        if (action.equals("0 1")) return new CansState(CansState.A0B1);
        if (action.equals("0 2")) return new CansState(CansState.A0B2);
        if (action.equals("0 3")) return new CansState(CansState.A0B3);
        if (action.equals("0 4")) return new CansState(CansState.A0B4);
        if (action.equals("0 5")) return new CansState(CansState.A0B5);

        return null;
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        return 1;
    }


}
