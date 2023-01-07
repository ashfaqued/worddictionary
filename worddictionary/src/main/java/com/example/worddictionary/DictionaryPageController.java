package com.example.worddictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {
    @FXML
    TextField search;
    @FXML
    TextField newword;
    @FXML
    TextField meaning;
    @FXML
    TextField findword;

    private DictionarySaver db;

    @FXML
    public void searchButton(MouseEvent event) throws ClassNotFoundException, IOException {
        //System.out.println("Button clicked");
        try{
            //   System.out.println(search.getText());
        db= new DictionarySaver();
        //db.serializeHashMap();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");

         if(search.getText().equals(""))
            {
                alert.setContentText("Please enter word to Search");
                alert.showAndWait();
            }


          else if(db.getDictionaryList().containsKey(search.getText().toLowerCase())) {
            //   System.out.println("the word is availble");
            alert.setContentText("The  Word is Available in the Dictionary");
            alert.showAndWait();
        }
        else{
            alert.setContentText("The Word is Not available in the Dictionary");
            alert.showAndWait();
            //System.out.println("the word is not available");
        }

            }
        catch(IOException ex){
            db.serializeHashMap();

        }


    }
    @FXML
    public void Add(MouseEvent event) throws IOException, ClassNotFoundException {
        //System.out.println("Button clicked");
    //    System.out.println(search.getText());
          db= new DictionarySaver();
          db.deserializeHashMap();

          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");

        if(newword.getText().equals("") || meaning.getText().equals(""))
        {
            alert.setContentText("Please enter word/Meaing to add to the Dictionary");
            alert.showAndWait();
        }
        else if (db.getDictionaryList().containsKey(newword.getText().toLowerCase()))
        {
            alert.setContentText("The Word is already present in the Dictionary");
            alert.showAndWait();
        }
        else{
            db.getDictionaryList().put(newword.getText().toLowerCase(), meaning.getText());
            db.serializeHashMap();
            alert.setContentText("New Word is Added to the Dictionary");
            alert.showAndWait();
        }
    }
    @FXML
    public void Meaning(MouseEvent event) throws IOException, ClassNotFoundException {
        //System.out.println("Button clicked");
        //System.out.println(search.getText());
        db=new DictionarySaver();

        db.deserializeHashMap();


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Meaning");
        if(findword.getText().equals(""))
        {
            alert.setContentText("Please enter word to find Meaning");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(findword.getText().toLowerCase())){
          //  System.out.println(db.getDictionaryList().get(findword.getText()));

            alert.setContentText(db.getDictionaryList().get(findword.getText()));
            alert.showAndWait();

          }
           else {
            alert.setContentText("The  Word is not availble in the Dictionary");
            alert.showAndWait();
        }

    }
}
