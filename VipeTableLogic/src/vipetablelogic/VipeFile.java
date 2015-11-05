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
public class VipeFile { //default constructor which instantiates variables
    
    /* VipeFile is a data class that keeps track of chunks as they are allocated
    across the directory. When displayed in the directory, a VipeFile will show
    a color and the file ID. To serialize instances of the VipeFile, "fileID"
    will be declared static.
     */
    
    ArrayList<Chunk> chunks;        //instantiates an arraylist that holds the chunks in a file
    int             fileSize;       //instantiates an int variable that stores the size of the file
    String          fileName;       //instantiates a string variable that stores the name of the file
    Color           sectorColor;	//instantiates a color variable that stores the color for the sector
    int             fileID;			//instantiates an int variable that stores the ID of the file
    
    public VipeFile(int fs, String fn, Color c, int fid) {	//constructor with parameters for the size, name, color, and ID of the file
        fileSize    = fs;									//sets the fileSize
        fileName    = fn;									//sets the fileName
        sectorColor = c;									//sets the sectorColor
        fileID      = fid;									//sets the fileID
        
        chunks      = new ArrayList<Chunk>();				//instantiates a new arrayList of chunks
        
        //serialize fileID
    }
    
    public ArrayList<Chunk> getChunks() {	//get method that returns the arraylist of chunks
        return chunks;
    }
    
    public Chunk getChunk(int i) {	//get method that returns the chunk at spot i of arraylist chunks
        return chunks.get(i);
    }

    public int getFileSize() {	//get method that returns the file size
        return fileSize;
    }

    public String getFileName() {	//get method that returns the file name
        return fileName;
    }

    public Color getSectorColor() {	//get method that returns the sector color
        return sectorColor;
    }

    
    public int getFileID() {	//get method that returns the ID
        return fileID;
    }

    public void setChunks(ArrayList<Chunk> chunks) {	//set method that resets the arrayList chunks
        this.chunks = chunks;
    }

    public void setFileSize(int fileSize) {		//set method that resets the file size variable
        this.fileSize = fileSize;
    }

    public void setFileName(String fileName) {	//set method that resets the file name variable
        this.fileName = fileName;
    }

    public void setSectorColor(Color sectorColor) {	//set method that resets the color variable
        this.sectorColor = sectorColor;
    }
    
    
    //serialized across all VipeFile instances

    @Override
    public String toString() {	//to string that formats the vipefile output
        /*
        <fileID> <fileName> (<sectorColor>, <fileSize>s)
                <chunks>
    
    Example:
        1 Quiz.doc (Red, 15s)
            [0-6] [12-18] [39-40]
    */
        return fileID + fileName + "(" + sectorColor + "," + fileSize + "s" +	//returns the variables formatted as...
        ")/n   " + getChunkString();											//IDName(color,sizes)
    }																			//	chunks**
    
    public String getChunkString() {											//**outputs chunks formatted like a list [start-end] [start-end] [start-end]
        String output = "";							//variable for the output
        for (int i = 0; i < chunks.size(); i++) {	//loops through chunks arraylist
            Chunk c = chunks.get(i);				//creates variable for the chunk at each index in chunks
            output += "[" + c.getStartIndex() + "-" + c.getEndIndex() + "]";	//adds [start-end] to output
            if (i < chunks.size() - 1)				//if not at end of arraylist
                output += " ";						//add space after chunk
        }
        return output;
    }
            
}