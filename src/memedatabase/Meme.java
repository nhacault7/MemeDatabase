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
    
    public File pictureFile;
    public String author;
    public String dateCreated;
    public LinkedList<String> keywords;
    
    public Meme(File pictureFile, String author, 
            String dateCreated, 
            LinkedList<String> keywords) {
        
        this.pictureFile    = pictureFile;
        this.author         = author;
        this.dateCreated    = dateCreated;
        
        if (keywords != null) {
            this.keywords = new LinkedList<>();
            for (int i = 0; i < keywords.size(); i++) {
                this.keywords.add(keywords.get(i));
            }
        }
    }
    
    public String toString() {
        String text = author + " (";
        text += dateCreated + "): ";
        if (keywords == null || keywords.isEmpty()) {
            text += "no keywords";
        } 
        else {
            text += "keywords = ";
            for (int i = 0; i < keywords.size()-1; i++) {
                text += keywords.get(i) + ";";
            }
            text += keywords.get(keywords.size()-1);
        }
        return text;
    }

    @Override
    public int compareTo(Object object) {
        Meme that = (Meme)object;
        String value1 = this.toString();
        String value2 = that.toString();
        return value1.compareToIgnoreCase(value2);
    }
}
