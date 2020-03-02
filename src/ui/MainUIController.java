/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author n.hacault
 */
public class MainUIController {

    private JLabel memeImageLabel;
    private JTextField dateCreatedTextbox;
    private JTextField authorTextbox; 
    private JTextField keywordTextbox; 
    private List keywordsList;
    private List memesList;
    
    MainUIController(JLabel memeImageLabel, 
            JTextField dateCreatedTextbox, 
            JTextField authorTextbox, 
            JTextField keywordTextbox, 
            List keywordsList, 
            List memesList, 
            MainUI userInterface) {
        
        this.memeImageLabel = memeImageLabel;
        this.dateCreatedTextbox = dateCreatedTextbox;
        this.authorTextbox = authorTextbox;
        this.keywordTextbox = keywordTextbox;
        this.keywordsList = keywordsList;
        this.memesList = memesList;
        
        userInterface.setSize(596, 766);
        userInterface.setResizable(false);
        userInterface.setLocationRelativeTo(null);
        userInterface.setVisible(true);
    }

    void selectImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void enterKeyword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteSelectedKeyward() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void saveMeme() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void editSelectedMeme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteSelectedMeme() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void sortMemes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void searchMemes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void saveMemeList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void openMemeList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
