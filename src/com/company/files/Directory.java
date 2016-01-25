package com.company.files;

import java.util.*;

/**
 * Created by Yevgen on 20.12.2015.
 */
public class Directory extends SimpleFile {
    public final static String DIRECTORY_FILE_TYPE = "Directory File Type";

    private HashMap<String, SimpleFile> files;

    public HashMap<String, SimpleFile> getFiles() {
        return files;
    }

    public Directory(String fileName) {
        super(fileName, DIRECTORY_FILE_TYPE);

        files = new HashMap<>();
    }

    public void addFile(SimpleFile file) {
        files.put(file.getFileName(), file);
    }

    public ArrayList getSortedFileNameList() {
        ArrayList resultSet = new ArrayList<>();

        List<String> sourceList = new ArrayList<>(files.keySet());
        sourceList
                .stream()
                .sorted((f1, f2) -> f1.compareTo(f2))
                .forEach(f -> resultSet.add(f));

        return resultSet;
    }

    public void sortDirectoryByFilename() {
        HashMap<String, SimpleFile> list = new HashMap<>();
        ArrayList filenameList = getSortedFileNameList();

        list.putAll(files);
        files.clear();

        filenameList
                .stream()
                .forEach(f -> addFile(list.get(f)));
    }
}
