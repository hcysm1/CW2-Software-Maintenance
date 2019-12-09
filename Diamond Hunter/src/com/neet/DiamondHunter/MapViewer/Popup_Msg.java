package com.neet.DiamondHunter.MapViewer;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.*;

public class Popup_Msg {

	/* Pop up message whenever user input incorrect value into answer field. */
	public static void display(String title, String message) {
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(300);
		window.setMinHeight(80);

		/* Setting a label and a close button to the pop up notification window */
		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("Close");
		closeButton.setOnAction(e -> window.close());

		/* Aligning pop messages messages to the center of the game window */
		VBox layout = new VBox();
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);

		/* Show window until user clicks on the close button */
		Scene alert_scene = new Scene(layout);
		window.setScene(alert_scene);
		window.showAndWait();
	}

}
