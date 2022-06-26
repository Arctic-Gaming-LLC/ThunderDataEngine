package net.pentlock.thunderdataengine.utilities;

public class FileNameCleaner {

    private int middlePoint;


    public FileNameCleaner() {
    }

    public String fileNameCleaner(String name) {

            if (name.contains(".")) {
                int size = name.length();
                for (int i = 0; i < size; ) {
                    if (String.valueOf(name.charAt(i)).equalsIgnoreCase(".")) {
                        this.middlePoint = i;
                    }
                    i++;
                }
                return name.substring(0, middlePoint);
            }
            return name;
    }
}
