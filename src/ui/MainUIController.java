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
import tools.Images;
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
        if (index != -1) {
            if(dialog.yesNo("are you sure you want to " 
                    + "delete the selected keyword?")) {
                keywordsList.remove(index);
                if(keywords != null) keywords.remove(index);
            }
        }
    }
    
    void saveMeme() {
        date = dateCreatedTextbox.getText();
        author = authorTextbox.getText();
        if (date == null) {
            dialog.output("Please enter a date!");
            dateCreatedTextbox.requestFocus();
        }
        else if (author == null) {
        dialog.output("Please enter an author!");
        authorTextbox.requestFocus();
        }
        else if (file == null) {
            dialog.output("Please select an image file!");
            memeImageLabel.requestFocus();
        }
        else {
            Meme meme = new Meme(file, author, date, keywords);
            list.add(meme);
            memesList.add(meme.toString());
            clearFields();
        }
      
    }
    
    void clearFields() {
        memeImageLabel.setIcon(null);
        dateCreatedTextbox.setText("");
        authorTextbox.setText("");
        keywordTextbox.setText("");
        keywordsList.removeAll();
        date = null;
        author = null;
        file = null;
        if (keywords != null) {
            keywords.clear();
            keywords = null;
        }
    }

    void editSelectedMeme() {
        int index = memesList.getSelectedIndex();
        if (index != -1) {
            clearFields();
            Meme meme = list.get(index);
            file = meme.pictureFile;
            author = meme.author;
            date = meme.dateCreated;
            if(meme.keywords != null) {
                keywords = new LinkedList<>();
                for (int i = 0; i < meme.keywords.size(); i++) {
                    keywords.add(meme.keywords.get(i));
                }
            }
            String path = file.getAbsolutePath();
            Icon icon = new ImageIcon(path);
            memeImageLabel.setIcon(icon);
            Images.resizeToContainer(memeImageLabel);
            dateCreatedTextbox.setText(date);
            authorTextbox.setText(author);
            if (keywords != null) {
                for (int i = 0; i < keywords.size(); i++) {
                    keywordsList.add(keywords.get(i));
                }
            }
            memesList.remove(index);
            list.remove(index);
        }
    }

    void deleteSelectedMeme() {
        int index = memesList.getSelectedIndex();
        if (index != -1) {
            if (dialog.yesNo("Are you sure you want to " 
                    + "delete the selected meme?")) {
                memesList.remove(index);
                list.remove(index);
            }
        }
    }

    void sortMemes() {
        sort.bubble(list);
        memesList.removeAll();
        for (int i = 0; i < list.size(); i++) {
            memesList.add(list.get(i).toString());
        }
    }

    void searchMemes() {
        String searchText = dialog.input("Enter word to search for");
        searchText = searchText.toLowerCase();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            Meme meme = list.get(i);
            String words = meme.toString();
            words = words.toLowerCase();
            if (words.contains(searchText)) {
                index = i;
                i = list.size();
            }
        }
        if (index != -1) memesList.select(index);
        else dialog.output(searchText + " not found!");
    }
        

    void saveMemeList() {
        file = dialog.saveFile(userInterface);
        if (file != null && list != null) fileHandler.saveObject(list, file);
    }

    void openMemeList() {
        file = dialog.openFile(userInterface);
        if (file != null) {
            list = (LinkedList<Meme>) fileHandler.openObject(file);
            if (list != null) {
                memesList.removeAll();
                for (int i = 0; i < list.size(); i++) {
                    Meme meme = list.get(i);
                    String text = meme.toString();
                    memesList.add(text);
                }
            }
        }
    }
}
