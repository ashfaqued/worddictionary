package com.example.worddictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Group root;
    @Override
// start of project
    public void start(Stage stage) throws IOException {
        root=new Group();
      //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
      //  Scene scene = new Scene(fxmlLoader.load(), 320, 240);

   //     primaryStage.setTitle
        stage.setTitle("word Dictionary");

        DictionaryPage page= new DictionaryPage();
        root.getChildren().add(page.root);

        stage.setScene(new Scene(root, 500,500));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}