package net.pentlock.thunderdataengine.utilities;

import java.util.Map;
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

        int length;
        String[] newArray;
        if (oldArray.length >= 50) {
            newArray = new String[50];
            length = 50;
        } else {
            length = oldArray.length + 1;
            newArray = new String[length + 1];
        }
        newArray[0] = value;
        for (int i = 0; i < length;) {
            newArray[i + 1] = oldArray[i];
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
    public static long[] addToArray(long[] oldArray, long value) {

        int length;
        long[] newArray;
        if (oldArray.length >= 50) {
            newArray = new long[50];
            length = 49;

        } else {
            length = oldArray.length;
            newArray = new long[length + 1];
        }
        newArray[0] = value;
        for (int i = 0; i < length;) {
            newArray[i + 1] = oldArray[i];
            i++;
        }

        return newArray;
    }

    /**
     * <h3>Array Util</h3>
     * A handy tool to update arrays!
     * Can only be used for Session Total
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is adding to
     */
    public static double[] addToArraySessionTotal(double[] oldArray, double value, Map<String, double[]> sessionStats, String type) {

        int length;
        double[] newArray;
        if (oldArray.length  >= 50) {
            double[] stats = sessionStats.get(type);
            double totalStat = 0;
            for (int i = 0; i < stats.length;) {
                totalStat = totalStat + stats[i];
                i++;
            }
            sessionStats.put(type, new double[0]);
            double[] totalStats = sessionStats.get(type+"Ave");
            double[] newAveStats = new double[1];
            if (totalStats.length == 1) {
                newAveStats[0] = totalStats[0] + totalStat;
            } else {
                newAveStats[0] = totalStat;
            }
            sessionStats.put(type+"Ave", newAveStats);
            return newAveStats;
        } else {
            length = oldArray.length;
            newArray = new double[length + 1];
            newArray[0] = value;
            for (int i = 0; i < length;) {
                newArray[i + 1] = oldArray[i];
                i++;
            }
            sessionStats.put(type, newArray);
            return newArray;
        }
    }

    /**
     * <h3>Array Util</h3>
     * A handy tool to update arrays!
     * Can only be used for Session Total
     *
     * @param oldArray The current array that is being updated
     * @param value The values that an array is adding to
     */
    public static double[] addToArraySessionAverage(double[] oldArray, double value, Map<String, double[]> sessionStats, String type) {

        int length;
        double[] newArray;
        if (oldArray.length  >= 50) {
            double[] stats = sessionStats.get(type);
            double totalStat = 0;
            for (int i = 0; i < stats.length;) {
                totalStat = totalStat + stats[i];
                i++;
            }
            double averageStat = totalStat / oldArray.length;
            sessionStats.put(type, new double[0]);
            double[] aveStats = sessionStats.get(type+"Ave");
            double[] newAveStats = new double[1];
            if (aveStats.length == 1) {
                newAveStats[0] = (averageStat + totalStat) /2;
            } else {
                newAveStats[0] = totalStat;
            }
            sessionStats.put(type+"Ave", newAveStats);
            return newAveStats;
        } else {
            length = oldArray.length;
            newArray = new double[length + 1];
            newArray[0] = value;
            for (int i = 0; i < length;) {
                newArray[i + 1] = oldArray[i];
                i++;
            }
            sessionStats.put(type, newArray);
            return newArray;
        }
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
    public static double[] addToArray(double[] oldArray, double value) {

        int length;
        double[] newArray;
        if (oldArray.length >= 50) {
            newArray = new double[50];
            length = 49;
        } else {
            length = oldArray.length;
            newArray = new double[length + 1];
        }
        newArray[0] = value;
        for (int i = 0; i < length;) {
            newArray[i + 1] = oldArray[i];
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

        int length;
        UUID[] newArray;
        if (oldArray.length >= 50) {
            newArray = new UUID[50];
            length = 49;
        } else {
            length = oldArray.length;
            newArray = new UUID[length + 1];
        }
        newArray[0] = value;
        for (int i = 0; i < length;) {
            newArray[i + 1] = oldArray[i];
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
    public static long[] removeFromArray(long[] oldArray, long value) {

        long[] newArray = new long[oldArray.length - 1];
        int y = 0;
        for (int i = 0; i < oldArray.length;) {

            if (oldArray[i] != value) {
                newArray[y] = oldArray[i];
                y++;
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
    public static double[] removeFromArray(double[] oldArray, double value) {

        double[] newArray = new double[oldArray.length - 1];
        int y = 0;
        for (int i = 0; i < oldArray.length;) {

            if (oldArray[i] != value) {
                newArray[y] = oldArray[i];
                y++;
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
        for (int i = 0; i < oldArray.length;) {

            if (!oldArray[i].equalsIgnoreCase(value)) {
                newArray[y] = oldArray[i];
                y++;
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
        for (int i = 0; i < oldArray.length;) {

            if (!oldArray[i].toString().equalsIgnoreCase(value.toString())) {
                newArray[y] = oldArray[i];
                y++;
            }
            i++;
        }

        return newArray;
    }
}
