package ir.lazydeveloper.common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static String[] getListOfFileName(String directoryName) {
        File file = new File(directoryName);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("This is not directory ->" + directoryName);
        }
        return file.list();
    }

    public static List<File> getListOfFiles(String path) {
        List<File> files = new ArrayList<>();
        String[] fileNames = getListOfFileName(path);
        for (String fileName : fileNames) {
            File file = new File(path + fileName);
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }
}
