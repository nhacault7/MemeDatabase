/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memedatabase;

import collections.LinkedList;
import java.io.File;
import java.io.Serializable;

/**
 *
 * @author n.hacault
 */
public class Meme implements Comparable, Serializable {
    
    private File pictureFile;
    private String author;
    private String dateCreated;
    private LinkedList<String> keywords;
    
    public Meme(File pictureFile, String author, 
            String dateCreated, 
            LinkedList<String> keywords) {
        
        
        this.pictureFile = pictureFile;
        this.author = author;
        this.dateCreated = dateCreated;
        this.keywords = keywords;
    }
    

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    
    
    
    
}
