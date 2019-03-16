package fr.emse.ai.search.cans;

public class CansState {
    public final static String A15B0 = "15 0";
    public final static String A15B1 = "15 1";
    public final static String A15B2 = "15 2";
    public final static String A15B3 = "15 3";
    public final static String A15B4 = "15 4";
    public final static String A15B5 = "15 5";
    public final static String A14B0 = "14 0";
    public final static String A14B1 = "14 1";
    public final static String A14B2 = "14 2";
    public final static String A14B3 = "14 3";
    public final static String A14B4 = "14 4";
    public final static String A14B5 = "14 5";
    public final static String A13B0 = "13 0";
    public final static String A13B1 = "13 1";
    public final static String A13B2 = "13 2";
    public final static String A13B3 = "13 3";
    public final static String A13B4 = "13 4";
    public final static String A13B5 = "13 5";
    public final static String A12B0 = "12 0";
    public final static String A12B1 = "12 1";
    public final static String A12B2 = "12 2";
    public final static String A12B3 = "12 3";
    public final static String A12B4 = "12 4";
    public final static String A12B5 = "12 5";
    public final static String A11B0 = "11 0";
    public final static String A11B1 = "11 1";
    public final static String A11B2 = "11 2";
    public final static String A11B3 = "11 3";
    public final static String A11B4 = "11 4";
    public final static String A11B5 = "11 5";
    public final static String A10B0 = "10 0";
    public final static String A10B1 = "10 1";
    public final static String A10B2 = "10 2";
    public final static String A10B3 = "10 3";
    public final static String A10B4 = "10 4";
    public final static String A10B5 = "10 5";
    public final static String A9B0 = "9 0";
    public final static String A9B1 = "9 1";
    public final static String A9B2 = "9 2";
    public final static String A9B3 = "9 3";
    public final static String A9B4 = "9 4";
    public final static String A9B5 = "9 5";
    public final static String A8B0 = "8 0";
    public final static String A8B1 = "8 1";
    public final static String A8B2 = "8 2";
    public final static String A8B3 = "8 3";
    public final static String A8B4 = "8 4";
    public final static String A8B5 = "8 5";
    public final static String A7B0 = "7 0";
    public final static String A7B1 = "7 1";
    public final static String A7B2 = "7 2";
    public final static String A7B3 = "7 3";
    public final static String A7B4 = "7 4";
    public final static String A7B5 = "7 5";
    public final static String A6B0 = "6 0";
    public final static String A6B1 = "6 1";
    public final static String A6B2 = "6 2";
    public final static String A6B3 = "6 3";
    public final static String A6B4 = "6 4";
    public final static String A6B5 = "6 5";
    public final static String A5B0 = "5 0";
    public final static String A5B1 = "5 1";
    public final static String A5B2 = "5 2";
    public final static String A5B3 = "5 3";
    public final static String A5B4 = "5 4";
    public final static String A5B5 = "5 5";
    public final static String A4B0 = "4 0";
    public final static String A4B1 = "4 1";
    public final static String A4B2 = "4 2";
    public final static String A4B3 = "4 3";
    public final static String A4B4 = "4 4";
    public final static String A4B5 = "4 5";
    public final static String A3B0 = "3 0";
    public final static String A3B1 = "3 1";
    public final static String A3B2 = "3 2";
    public final static String A3B3 = "3 3";
    public final static String A3B4 = "3 4";
    public final static String A3B5 = "3 5";
    public final static String A2B0 = "2 0";
    public final static String A2B1 = "2 1";
    public final static String A2B2 = "2 2";
    public final static String A2B3 = "2 3";
    public final static String A2B4 = "2 4";
    public final static String A2B5 = "2 5";
    public final static String A1B0 = "1 0";
    public final static String A1B1 = "1 1";
    public final static String A1B2 = "1 2";
    public final static String A1B3 = "1 3";
    public final static String A1B4 = "1 4";
    public final static String A1B5 = "1 5";
    public final static String A0B0 = "0 0";
    public final static String A0B1 = "0 1";
    public final static String A0B2 = "0 2";
    public final static String A0B3 = "0 3";
    public final static String A0B4 = "0 4";
    public final static String A0B5 = "0 5";

    public String value;

    public CansState(String value){this.value = value;}

    public boolean equals(Object o){
        if (o instanceof CansState){
            return ((CansState) o).value.equals(this.value);
        }
        return false;
    }

    public String toString(){return value;}
}
