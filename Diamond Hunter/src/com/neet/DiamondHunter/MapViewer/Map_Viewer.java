package com.neet.DiamondHunter.MapViewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//This is the code for Map_viewer Application
//The code generates a plain GUI window which will
//be linked to the map editor file to add gaming components.
public class Map_Viewer extends Application {

	public static void main(String[] args) {
		Application.launch();
	}
     // Creating GUI for Map_viewer application using Scene builder spplication
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Map_Editor.fxml"));
		primaryStage.setTitle("Map Viewer");
		primaryStage.setScene(new Scene(root, 940, 700));
		primaryStage.setResizable(true);
		primaryStage.show();
	}
}
