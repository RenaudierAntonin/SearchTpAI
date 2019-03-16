package fr.emse.ai.search.missionaries;

public class MissionariesState {


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
