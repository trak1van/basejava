package com.urise.webapp;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        String filePath = ".\\.gitignore";

       /* File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/ru/javawebinar/basejava");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        File dir2 = new File("E:\\repository\\basejava\\basejava");
        String LS = "+";
        printFile(dir2, LS);
    }

    public static void printFile(File catalog, String LS) {
        File[] files = catalog.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(LS + file.getName());
                    LS += "+";
                    printFile(file, LS);
                } else {
                    System.out.println(LS + file.getName());
                }
            }
        }
    }
}