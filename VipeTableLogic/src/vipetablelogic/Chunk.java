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
public class Chunk {
    int startIndex;
    int endIndex;
    
    public Chunk(int s, int e) {
        startIndex = s;
        endIndex = e;
    }
    
    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }
    
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public void setEndIndex(int endIndex) {
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
        return "[" + startIndex + "-" + endIndex + "]";
    }
}