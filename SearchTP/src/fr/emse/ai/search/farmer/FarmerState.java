package fr.emse.ai.search.farmer;

public class FarmerState {

    public final static String LLLL = "L L L L";
    public final static String LLRL = "L L R L";
    public final static String RLLL = "R L L L";
    public final static String LRLL = "L R L L";
    public final static String LRRL = "L R R L";
    public final static String RLRL = "R L R L";
    public final static String RRLL = "R R L L";
    public final static String RRRL = "R R R L";
    public final static String LLLR = "L L L R";
    public final static String LLRR = "L L R R";
    public final static String RLLR = "R L L R";
    public final static String LRLR = "L R L R";
    public final static String LRRR = "L R R R";
    public final static String RLRR = "R L R R";
    public final static String RRLR = "R R L R";
    public final static String RRRR = "R R R R";

    public String value;

    public FarmerState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof FarmerState) {
            return ((FarmerState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }
}
