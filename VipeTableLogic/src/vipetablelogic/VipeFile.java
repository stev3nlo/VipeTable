/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipetablelogic;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Steven
 */
public class VipeFile {
    
    /* VipeFile is a data class that keeps track of chunks as they are allocated
    across the directory. When displayed in the directory, a VipeFile will show
    a color and the file ID. To serialize instances of the VipeFile, "fileID"
    will be declared static.
     */
    
    ArrayList<Chunk> chunks;
    int             fileSize;
    String          fileName;
    Color           sectorColor;
    int             fileID;
    
    public VipeFile(int fs, String fn, Color c, int fid) {
        fileSize    = fs;
        fileName    = fn;
        sectorColor = c;
        fileID      = fid;
        
        chunks      = new ArrayList<Chunk>();
        
        //serialize fileID
    }
    
    public ArrayList<Chunk> getChunks() {
        return chunks;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public Color getSectorColor() {
        return sectorColor;
    }

    
    public int getFileID() {
        return fileID;
    }

    public void setChunks(ArrayList<Chunk> chunks) {
        this.chunks = chunks;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSectorColor(Color sectorColor) {
        this.sectorColor = sectorColor;
    }
    
    
    //serialized across all VipeFile instances

    @Override
    public String toString() {
        /*
        <fileID> <fileName> (<sectorColor>, <fileSize>s)
                <chunks>
    
    Example:
        1 Quiz.doc (Red, 15s)
            [0-6] [12-18] [39-40]
    */
        return fileID + fileName + "(" + sectorColor + "," + fileSize + "s" +
        "/n   " + getChunkString();
    }
    
    public String getChunkString() {
        String output = "";
        for (int i = 0; i < chunks.size(); i++) {
            Chunk c = chunks.get(i);
            output += "[" + c.getStartIndex() + "-" + c.getEndIndex() + "]";
            if (i < chunks.size() - 1)
                output += " ";
        }
        return output;
    }
            
}