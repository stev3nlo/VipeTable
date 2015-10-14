/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipetablelogic;

import java.awt.Color;
import java.util.ArrayList;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class VipeTableLogic {
    
    private Directory dir;
    Scanner keyboard = new Scanner(System.in);
    
    public VipeTableLogic() {
        dir = new Directory(new ArrayList<VipeFile>(), new int[600]);
        
        while (true) {
            System.out.println("VipeTable Functions:");
            System.out.println("\t 1) import Data");
            System.out.println("\t 2) add file");
            System.out.println("\t 3) delete file");
            System.out.println("\t 4) edit file");
            
            String choice = keyboard.next();
            
            switch (new Integer(choice)) {
                case 1 : importData(); break;
                case 2 : writeData(); break;
                case 3 : deleteData(); break;
                case 4 : editData(); break;
            }
            System.out.println(dir);
        }
    }
    
    private String getChunkString(int fileID) {
            //returns a String representation of a file’s chunks
        ArrayList<VipeFile> file = dir.file;
        return file.get(fileID).getChunkString();
    }
    private int getAvailableSize() {
            //returns the total number of unmarked sectors
        int unmarked = 0;
        for (int sector: dir.getSectors())
            if (sector == 0)
                unmarked++;
        return unmarked;
    }
    private Chunk getNextChunk() {
        int start = -1;
        int end = 0;
            //returns the next available chunk
        for (int i = 0; i < dir.sectors.length; i++)
            if (start == -1)
                if (dir.sectors[i] == 0)
                    start = i;
            else
                if (dir.sectors[i] != 0)
                    end = i - 1;
        return new Chunk(start, end);
    }
    private void writeFile(VipeFile file) {
            //writes file to the directory’s sector array
        String name = file.getFileName();
        int size = file.getFileSize();
        addFile(name, size);
    }
    private void writeGrid() {
            //creates the 2DGraphic representation of the directory
        System.out.println(dir);
    }
    private void deleteFile(int fileID) {
            //removes the file from the directory and calls writeGrid()
        dir.deleteFile(new Integer(fileID));
    }
    
    private void editFile(int fileID, int sectorChange) {
            //adds or removes sectors from the file
        dir.editFile(fileID, sectorChange);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VipeTableLogic vtl = new VipeTableLogic();
    }

    private void importData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    private void writeData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("WRITE FILE: \nEnter FILE NAME: ");
        String name = keyboard.next();
        System.out.println("Enter FILE SIZE: ");
        int size = new Integer(keyboard.next());
        
        writeFile(new VipeFile(size, name, Color.WHITE, getNextID()));
    }

    private void deleteData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("DELETE FILE: \nEnter FILE ID: ");
        deleteFile(Integer.parseInt(keyboard.next()));
    }

    private void editData() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        Scanner keyboard = new Scanner(System.in);
        System.out.println(dir.file.toString());
        System.out.println("EDIT FILE: \nEnter FILE ID: ");
        int id = keyboard.nextInt();
        System.out.println("Enter Sector Changed: ");
        int sec = keyboard.nextInt();
        editFile(id, sec);
    }

    private int getNextID() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        //loop through files aray and find max value
        int max = 0;
        
        for (VipeFile file: dir.file) {
            if (file.getFileID() > max)
                max = file.getFileID();
        }
    return max + 1;
    }
    
    private void addFile(String name, int size) {
        Color color = new Color(255, 255, 255);
        dir.addFile(new VipeFile(size, name, color, getNextID()));
    }
}