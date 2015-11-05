/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipetablelogic;

/**
 *
 * @author Steven
 */
public class Chunk {    //default constructor
    int startIndex;     //instantiates variable for where chunck starts
    int endIndex;       //instantiates variable for where chunk ends
    
    public Chunk(int s, int e) {    //constructor with two int parameters for start/end
        startIndex = s;             //sets startIndex variable to parameter s
        endIndex = e;               //sets endIndex variable to parameter e
    }
    
    public int getStartIndex() {    //get method that returns startIndex variable
        return startIndex;
    }

    public int getEndIndex() {  //get method that returns endIndex variable
        return endIndex;
    }
    
    public void setStartIndex(int startIndex) { //resets startIndex to parameter
        this.startIndex = startIndex;
    }

    public void setEndIndex(int endIndex) {     //resets endIndex to parameter
        this.endIndex = endIndex;
    }
    
    @Override
    public String toString() {
        /* Chunk holds the index reference for a span of sector data
        *
        * [<startIndex>-<endIndex>]
        * Example:
        * [0-6]
        */
        
        //string output for chunk class
        return "[" + startIndex + "-" + endIndex + "]"; //returns chunk data (start/end) in [start-end] notation
    }
}