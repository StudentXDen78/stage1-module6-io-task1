package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class FileReader {
    public static Profile getDataFromFile(File file)
    {
        StringBuilder dataFromFile = new StringBuilder();
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                dataFromFile.append((char) ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }

        HashMap<String, String> dataInLibraryMap= new HashMap<>();
        String[] base = dataFromFile.toString().split(System.lineSeparator());
        Profile anna = new Profile();
        for (String pair : base) {
            String[] pairs = pair.split(": ");
            dataInLibraryMap.put(pairs[0], pairs[1]);
        }

        for (Map.Entry<String, String> key : dataInLibraryMap.entrySet()){
            if (Objects.equals(key.getKey(), "Name")) anna.setName(dataInLibraryMap.get(key.getKey()));
            if (Objects.equals(key.getKey(), "Age")) anna.setAge(Integer.parseInt(dataInLibraryMap.get(key.getKey())));
            if (Objects.equals(key.getKey(), "Email")) anna.setEmail(dataInLibraryMap.get(key.getKey()));
            if (Objects.equals(key.getKey(), "Phone")) anna.setPhone(Long.parseLong(dataInLibraryMap.get(key.getKey())));
        }

        return anna;
    }

    public static void main(String[] args){
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt");
        getDataFromFile(file);
    }
}
