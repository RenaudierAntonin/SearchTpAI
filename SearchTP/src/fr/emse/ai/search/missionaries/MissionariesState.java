package fr.emse.ai.search.missionaries;

public class MissionariesState {

    // Un état est de la forme "i j L/R" ou i correspond au nombre de missionaires à Gauche et j au nombre de cannibales à Gauche"
    public final static String ZZL = "0 0 L";
    public final static String UUL = "1 1 L";
    public final static String DDL = "2 2 L";
    public final static String TTL = "3 3 L";
    public final static String UZL = "1 0 L";
    public final static String DZL = "2 0 L";
    public final static String TZL = "3 0 L";
    public final static String UDL = "1 2 L";
    public final static String UTL = "1 3 L";
    public final static String DUL = "2 1 L";
    public final static String DTL = "2 3 L";
    public final static String TUL = "3 1 L";
    public final static String TDL = "3 2 L";
    public final static String ZUL = "0 1 L";
    public final static String ZDL = "0 2 L";
    public final static String ZTL = "0 3 L";
    public final static String ZZR = "0 0 R";
    public final static String UUR = "1 1 R";
    public final static String DDR = "2 2 R";
    public final static String TTR = "3 3 R";
    public final static String UZR = "0 1 R";
    public final static String DZR = "2 0 R";
    public final static String TZR = "3 0 R";
    public final static String UDR = "1 2 R";
    public final static String UTR = "1 3 R";
    public final static String DUR = "2 1 R";
    public final static String DTR = "2 3 R";
    public final static String TUR = "3 1 R";
    public final static String TDR = "3 2 R";
    public final static String ZUR = "0 1 R";
    public final static String ZDR = "0 2 R";
    public final static String ZTR = "0 3 R";

    public String value;

    public MissionariesState(String value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o instanceof MissionariesState) {
            return ((MissionariesState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString() {
        return value;
    }
}
