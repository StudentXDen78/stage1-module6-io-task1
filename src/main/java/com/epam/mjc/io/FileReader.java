package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;


public class FileReader {
    public static Profile getDataFromFile(File file)
    {
        String absolutePath = "C:\\Users\\Admin\\IdeaProjects\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt";
        //System.out.println(absolutePath);
        StringBuilder dataFromFile = new StringBuilder();
        try(FileInputStream fileInputStream = new FileInputStream(absolutePath)) {
            int ch;
            while((ch = fileInputStream.read()) != -1) {
                // System.out.print((char)ch);
                dataFromFile.append((char)ch);
            }
            // System.out.print(dataFromFile);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException a) {
            System.out.println(a.getMessage());
        }

        HashMap<String, String> dataInLibraryMap= new HashMap<>();
        String[] base = dataFromFile.toString().split("\r\n");
        Profile anna = new Profile();
        for (String pair : base) {
            String[] pairs = pair.split(": ");
            dataInLibraryMap.put(pairs[0], pairs[1]);
        }

        for (String key : dataInLibraryMap.keySet()){
            System.out.println(key + " : " + dataInLibraryMap.get(key));
            if (Objects.equals(key, "Name")) anna.setName(dataInLibraryMap.get(key));
            if (Objects.equals(key, "Age")) anna.setAge(Integer.parseInt(dataInLibraryMap.get(key)));
            if (Objects.equals(key, "Email")) anna.setEmail(dataInLibraryMap.get(key));
            if (Objects.equals(key, "Phone")) anna.setPhone(Long.parseLong(dataInLibraryMap.get(key)));
        }

        return anna;
    }
}
