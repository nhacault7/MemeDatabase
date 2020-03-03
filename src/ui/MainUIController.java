/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import collections.LinkedList;
import io.Dialogs;
import io.FileHandler;
import java.awt.List;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import memedatabase.Meme;
import tools.Search;
import tools.Sort;

/**
 *
 * @author n.hacault
 */
public class MainUIController {

    private JLabel                          memeImageLabel;
    private JTextField                      dateCreatedTextbox;
    private JTextField                      authorTextbox; 
    private JTextField                      keywordTextbox; 
    private List                            keywordsList;
    private List                            memesList;
    private MainUI                          userInterface;
    
    private File                            file = null;
    private String                          keyword = null;
    private String                          author = null;
    private String                          date = null;
    private LinkedList<String>              keywords = null;
    
    private LinkedList<Meme>                list = new LinkedList<>();
    
    private Dialogs                         dialog = new Dialogs
                                            ("Meme database", userInterface);
    
    private Search                          search = new Search();
    private Sort                            sort = new Sort();
    
    private FileHandler<LinkedList<Meme>>   fileHandler = new FileHandler<>();
    
    MainUIController(JLabel memeImageLabel, 
            JTextField dateCreatedTextbox, 
            JTextField authorTextbox, 
            JTextField keywordTextbox, 
            List keywordsList, 
            List memesList, 
            MainUI userInterface) {
        
        this.memeImageLabel         = memeImageLabel;
        this.dateCreatedTextbox     = dateCreatedTextbox;
        this.authorTextbox          = authorTextbox;
        this.keywordTextbox         = keywordTextbox;
        this.keywordsList           = keywordsList;
        this.memesList              = memesList;
        this.userInterface          = userInterface;
        
        userInterface.setSize(596, 766);
        userInterface.setResizable(false);
        userInterface.setLocationRelativeTo(null);
        userInterface.setVisible(true);
    }

    void selectImage() {
        file = dialog.openFile(userInterface);
        if (file != null) {
            Icon image = new ImageIcon(file.getAbsolutePath());
            memeImageLabel.setIcon(image);
        }
    }

    void enterKeyword() {
        keyword = keywordTextbox.getText();
        if (keyword != null && !keyword.equals("")) {
            
            if (keywords == null || keywords.isEmpty()); {
                keywords = new LinkedList<>();
            }
            keywords.add(keyword);
            keywordsList.add(keyword);
            keywordTextbox.setText("");
            keywordTextbox.requestFocus();
            keyword = null;
        }
    }

    void deleteSelectedKeyward() {
        int index = keywordsList.getSelectedIndex();
        
    }
    
    void saveMeme() {

    }
    
    void clearFields() {

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
