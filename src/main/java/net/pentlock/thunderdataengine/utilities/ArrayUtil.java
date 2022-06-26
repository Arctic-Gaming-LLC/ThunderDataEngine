package net.pentlock.thunderdataengine.utilities;

import java.util.UUID;

public class ArrayUtil {

    /**
     * <h3>Array Util</h3>
     * A handy tool to update arrays!
     * String Edition!
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is adding to
     * @return Array of object type
     */

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

    /**
     * <h3>Array Util</h3>
     * A handy tool to update arrays!
     * Extra-Long Edition!
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is adding to
     * @return Array of object type
     */
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

    /**
     * <h3>Array Util</h3>
     * A handy tool to update arrays!
     * Double Edition
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is adding to
     * @return Array of object type
     */
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

    /**
     * <h3>Array Util</h3>
     * A handy tool to update arrays!
     * Less-Long Edition!
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is removing from
     * @return Array of object type
     */
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

    /**
     * <h3>Array Util</h3>
     * A handy tool to shorten arrays!
     * Double Edition!
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is removing from
     * @return Array of object type
     */
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

    /**
     * <h3>Array Util</h3>
     * A handy tool to shorten arrays!
     * String Edition!
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is removing from
     * @return Array of object type
     */
    public static String[] removeFromArray(String[] oldArray, String value) {

        String[] newArray = new String[oldArray.length - 1];
        int y = 0;
        for (int i = 0; i < oldArray.length - 1;) {

            if (oldArray[i] == value) {
                newArray[y] = oldArray[i];

            }
            i++;
        }

        return newArray;
    }

    /**
     * <h3>Array Util</h3>
     * A handy tool to shorten arrays!
     * UUID Edition!
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is removing from
     * @return Array of object type
     */
    public static UUID[] removeFromArray(UUID[] oldArray, UUID value) {

        UUID[] newArray = new UUID[oldArray.length - 1];
        int y = 0;
        for (int i = 0; i < oldArray.length - 1;) {

            if (oldArray[i] == value) {
                newArray[y] = oldArray[i];

            }
            i++;
        }

        return newArray;
    }

    /**
     * <h3>Array Util</h3>
     * A handy tool to update arrays!
     * UUID Edition
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is adding to
     * @return Array of object type
     */
    public static UUID[] addToArray(UUID[] oldArray, UUID value) {

        UUID[] newArray = new UUID[oldArray.length + 1];

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
}
