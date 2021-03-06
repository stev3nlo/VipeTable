/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipetablelogic;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Steven
 */
public class Directory {
    
    ArrayList<VipeFile> files;
    int[] sectors = new int[600];
    
    
    
    public Directory(ArrayList<VipeFile> fs, int[] sc) {
        files = fs;
        sectors = sc;
    }

    public ArrayList<VipeFile> getFile() {
        return files;
    }

    public int[] getSectors() {
        return sectors;
    }

    public void setFile(ArrayList<VipeFile> file) {
        this.files = file;
    }

    public void setSectors(int[] sectors) {
        this.sectors = sectors;
    }
    
    @Override
    public String toString() {
    // Display at 2D array of the directory values
        int var = 0;
        String output = "";
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 30; c++) {
                output += sectors[var];
                var++;
            }
            if (r != 19)
                output += "\n";
                
        }
        return output;
    }

    public void addFile(VipeFile file) {
            ArrayList<Chunk> list = new ArrayList<>();
            int start = 0;
            int end = 0;
            int size = file.getFileSize();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < sectors.length; j++) {
                    if (sectors[j] == 0) {
                        if (sectors[j + 1] != 0) {
                            end = j;
                            list.add(new Chunk(start + 1, end + 1));
                        }
                        sectors[j] = file.getFileID();
                        break;
                    }
                }
            }
            file.setChunks(list);
            this.files.add(file);
    }
    
    public void deleteFile(int ID) {
        for (int i = 0; i < sectors.length; i++) {
            if (sectors[i] == ID) {
                sectors[i] = 0;
            }
        }
    }
    
    public void editFile(int ID, int size) {
        int overflow = 0;
        for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getFileID() == ID) {
                return;
            }
            if (files.get(i).getFileSize() > size) {
                overflow = files.get(i).getFileSize() - size;
                for (int j = 0; j < overflow; j++) {
                    sectors[files.get(i).getChunk(0).getStartIndex() + j] = 0;
                }
            }
        }
    }
    
    private int getAvailableSize() {
            //returns the total number of unmarked sectors
        int unmarked = 0;
        for (int sector: getSectors())
            if (sector == 0)
                unmarked++;
        return unmarked;
    }
}