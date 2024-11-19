package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FileReader {
    public Profile getDataFromFile(File file) {
        StringBuilder dataFromFile = new StringBuilder();
        try(FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                dataFromFile.append((char) ch);
            }
        // } catch (FileRiderException e) {
        //    e.getCause();
        } catch (IOException e) {
            e.getCause();
        }

        HashMap<String, String> dataInLibraryMap= new HashMap<>();
        String[] base = dataFromFile.toString().split(System.lineSeparator());
        Profile anna = new Profile();
        for (String pair : base) {
            String[] pairs = pair.split(": ");
            dataInLibraryMap.put(pairs[0], pairs[1]);
        }

        for (Map.Entry<String, String> entry : dataInLibraryMap.entrySet()){
            if (Objects.equals(entry.getKey(), "Name")) anna.setName(entry.getValue());
            if (Objects.equals(entry.getKey(), "Age")) anna.setAge(Integer.parseInt(entry.getValue()));
            if (Objects.equals(entry.getKey(), "Email")) anna.setEmail(entry.getValue());
            if (Objects.equals(entry.getKey(), "Phone")) anna.setPhone(Long.parseLong(entry.getValue()));
        }

        return anna;
    }

     public static class FileRiderException extends IOException{
        public FileRiderException(String message){
            super(message);
        }
    }

    public static class SomeIOException extends IOException {
        public SomeIOException(Exception cause) {
            super(cause);
            throw new RuntimeException(cause);
        }
    }
}