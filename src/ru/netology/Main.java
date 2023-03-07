package ru.netology;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static StringBuilder mkDirectory(File newDirectory, StringBuilder str){
        if(newDirectory.mkdir()){
            str.append("Catalog " + newDirectory.getName() + " created in the way " + newDirectory.getAbsolutePath() + "\n");
        } else {
            str.append("Catalog " + newDirectory.getName() + " not created in the way " + newDirectory.getAbsolutePath() + "\n");
        }
        return str;
    }

    public static StringBuilder mkFiles(File newFile, StringBuilder str){
        try{
            if(newFile.createNewFile()){
                str.append("Catalog " + newFile.getName() + " created in the way " + newFile.getAbsolutePath() + "\n");
            }
        } catch (IOException ex){
            str.append("File " + newFile.getName() + " not created in the way " + newFile.getAbsolutePath() + "\n");
        }
        return str;
    }

    public static void main(String[] args) {
    StringBuilder str = new StringBuilder();

	File src = new File("C://Valerya//Folder//Games//src");
    File res = new File("C://Valerya//Folder//Games//res");
    File savegames = new File("C://Valerya//Folder//Games//savegames");
    File temp = new File("C://Valerya//Folder//Games//temp");

    str = mkDirectory(src, str);
    str = mkDirectory(res, str);
    str = mkDirectory(savegames, str);
    str = mkDirectory(temp, str);

    File srcMain = new File("C://Valerya//Folder//Games//src//main");
    File srcTest = new File("C://Valerya//Folder//Games//src//test");
    File resDrawables = new File("C://Valerya//Folder//Games//res//drawables");
    File resVectors = new File("C://Valerya//Folder//Games//res//vectors");
    File resIcons = new File("C://Valerya//Folder//Games//res//icons");

    str = mkDirectory(srcMain, str);
    str = mkDirectory(srcTest, str);
    str = mkDirectory(resDrawables, str);
    str = mkDirectory(resVectors, str);
    str = mkDirectory(resIcons, str);

    File srcMainFileMain = new File("C://Valerya//Folder//Games//src//main//Main.java");
    File srcMainFileUtils = new File("C://Valerya//Folder//Games//src//main//Utils.java");
    File tempFileTemp = new File("C://Valerya//Folder//Games//temp//temp.txt");

    str = mkFiles(srcMainFileMain, str);
    str = mkFiles(srcMainFileUtils, str);
    str = mkFiles(tempFileTemp, str);

    try (FileWriter writer = new FileWriter((tempFileTemp), false)) {
        writer.write(str.toString());
        writer.flush();
    } catch (IOException ex){
        System.out.println(ex.getMessage());
    }
    }
}
