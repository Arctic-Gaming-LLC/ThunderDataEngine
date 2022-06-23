package net.pentlock.thunderdataengine.utilities;

public class Test {

    public static String[] addToArray(String[] oldArray, Object object) {

        Object[] newArray = new Object[];

        int y = 0;

        for (int i = 0; i < oldArray.length + 1;) {

            if (i <= oldArray.length) {
                newArray[i] = oldArray[i];
            } else {
                newArray[i] = object;
            }
            i++;
        }

        return newArray;
    }
}
