package com.neet.DiamondHunter.MapViewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//This is the code for Map_viewer Application
public class Map_Viewer extends Application {

	public static void main(String[] args) {
		Application.launch();
	}

	// Creating GUI for Map_viewer application
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Map_Editor.fxml"));
		primaryStage.setTitle("Map Viewer");
		primaryStage.setScene(new Scene(root, 940, 700));
		primaryStage.setResizable(true);
		primaryStage.show();
	}

}