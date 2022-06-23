package net.pentlock.thunderdataengine.utilities;

public class ArrayUtil {

    public static String[] addToArray(String[] oldArray, String value) {

        String[] newArray = new String[oldArray.length + 1];

        for (int i = 0; i < oldArray.length + 1;) {

            if (i < oldArray.length) {
                newArray[i] = oldArray[i];
            } else {
                newArray[i] = value;
            }
            i++;
        }

        return newArray;
    }

    public static Long[] addToArray(Long[] oldArray, long value) {

        Long[] newArray = new Long[oldArray.length + 1];

        for (int i = 0; i < oldArray.length + 1;) {

            if (i < oldArray.length) {
                newArray[i] = oldArray[i];
            } else {
                newArray[i] = value;
            }
            i++;
        }

        return newArray;
    }

    public static Double[] addToArray(Double[] oldArray, double value) {

        Double[] newArray = new Double[oldArray.length + 1];

        for (int i = 0; i < oldArray.length + 1;) {

            if (i < oldArray.length) {
                newArray[i] = oldArray[i];
            } else {
                newArray[i] = value;
            }
            i++;
        }

        return newArray;
    }

    public static Long[] removeFromArray(Long[] oldArray, long value) {

        Long[] newArray = new Long[oldArray.length - 1];
        int y = 0;
        for (int i = 0; i < oldArray.length - 1;) {

            if (oldArray[i] == value) {
                newArray[y] = oldArray[i];

            }
            i++;
        }

        return newArray;
    }


    public static Double[] removeFromArray(Double[] oldArray, double value) {

        Double[] newArray = new Double[oldArray.length - 1];
        int y = 0;
        for (int i = 0; i < oldArray.length - 1;) {

            if (oldArray[i] == value) {
                newArray[y] = oldArray[i];

            }
            i++;
        }

        return newArray;
    }
}
