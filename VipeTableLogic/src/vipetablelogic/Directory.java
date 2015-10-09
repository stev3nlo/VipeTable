/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipetablelogic;

import java.util.ArrayList;

/**
 *
 * @author Steven
 */
public class Directory {
    
    ArrayList<VipeFile> file;
    int[] sectors = new int[600];
    
    
    
    public Directory(ArrayList<VipeFile> fs, int[] sc) {
        file = fs;
        sectors = sc;
    }

    public ArrayList<VipeFile> getFile() {
        return file;
    }

    public int[] getSectors() {
        return sectors;
    }

    public void setFile(ArrayList<VipeFile> file) {
        this.file = file;
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
        ArrayList<Chunk> files = new ArrayList<>();
        int start = 0;
        int end = 0;
        int size = file.getFileSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < sectors.length; j++) {
                if (sectors[j] == 0) {
                    if (sectors[j + 1] != 0) {
                        end = j;
                        files.add(new Chunk(start + 1, end + 1));
                    }
                sectors[j] = file.getFileID();
                break;
                }
            }
        }
        file.setChunks(files);
        this.file.add(file);
    }
}